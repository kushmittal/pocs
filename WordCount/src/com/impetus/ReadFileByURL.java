package com.impetus;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;


public class ReadFileByURL {

	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}

	public static void main(String[] args) throws Exception {
		InputStream in = null;
		try {
			//in = new URL("hdfs://192.168.213.169/ivy.xml").openStream();
			//IOUtils.copyBytes(in, System.out, 4096, false);
			Path myfile = new Path("/ivy.xml");
			ReadFileByURL rfbu=new ReadFileByURL();
			rfbu.readLines(myfile, new Configuration());
		} finally {
			IOUtils.closeStream(in);
		}
	}
	
	public List<String> readLines(Path location, Configuration conf) throws Exception {
	    FileSystem fileSystem = FileSystem.get(location.toUri(), conf);
	    CompressionCodecFactory factory = new CompressionCodecFactory(conf);
	    FileStatus[] items = fileSystem.listStatus(location);
	    if (items == null) return new ArrayList<String>();
	    List<String> results = new ArrayList<String>();
	    for(FileStatus item: items) {

	      // ignoring files like _SUCCESS
	      if(item.getPath().getName().startsWith("_")) {
	        continue;
	      }

	      CompressionCodec codec = factory.getCodec(item.getPath());
	      InputStream stream = null;

	      // check if we have a compression codec we need to use
	      if (codec != null) {
	        stream = codec.createInputStream(fileSystem.open(item.getPath()));
	      }
	      else {
	        stream = fileSystem.open(item.getPath());
	      }

	      StringWriter writer = new StringWriter();
	      IOUtils.copyBytes(stream, System.out, 4096,false);
	      
	      String raw = writer.toString();
	      String[] resulting = raw.split("\n");
	      for(String str: raw.split("\n")) {
	        results.add(str);
	      }
	    }
	    return results;
	  }

}
