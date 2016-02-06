package com.impetus.bigdata;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.log4j.Logger;

public class MovieLensThree {

	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path("/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.setJarByClass(MovieLensThree.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	public static class TokenizerMapper extends
			Mapper<Object, Text, Text, NullWritable> {

		private final static IntWritable one = new IntWritable(1);
		private NullWritable result = NullWritable.get();
		private Text word = new Text();
		private Map<String,Boolean> mapMovie = new HashMap<String,Boolean>();

		@Override
		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] stringArray = value.toString().split(":");
			if(!mapMovie.containsKey(stringArray[1]))
			{
					mapMovie.put(stringArray[1], true);
					word.set(stringArray[1]);
					context.write( word, result);
			}
		}
		
		@Override
		public void setup(Context context) throws IOException
		{
//			Job job = Job.getInstance(context.getConfiguration());
//			URI[] uris = job.getCacheFiles();
			
		}
	}

	public static class IntSumReducer extends
			Reducer<Text, NullWritable, Text, NullWritable> {
		private NullWritable result = NullWritable.get();

		public void reduce(Text key, Iterable<NullWritable> values,
				Context context) throws IOException, InterruptedException {
			context.write(key, result);
		}
	}
}
