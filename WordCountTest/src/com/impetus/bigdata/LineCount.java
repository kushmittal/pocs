package com.impetus.bigdata;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//import org.apache.log4j.Logger;

public class LineCount {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path(
				"/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.setJarByClass(LineCount.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		Path path = new Path(args[0]);
		FileSystem fs = path.getFileSystem(new Configuration());
		FileStatus[] status = fs.listStatus(path);
		for (int i=0;i<status.length;i++){
			if(status[i].isDirectory())
			{
				 FileStatus[] fileStatuses =fs.listStatus(status[i].getPath());
				 for(FileStatus fileStatus : fileStatuses)
				 {
					 FileInputFormat.addInputPath(job, fileStatus.getPath());	 
				 }
			}
        }
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	public static class TokenizerMapper extends
			Mapper<Object, Text, Text, LongWritable> {

		private final static LongWritable one = new LongWritable(1);
		private Text word = new Text("lineCount");

		@Override
		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			context.write(word, one);
		}
	}

	public static class IntSumReducer extends
			Reducer<Text, LongWritable, Text, LongWritable> {

		private static LongWritable result = new LongWritable(1);

		public void reduce(Text key, Iterable<LongWritable> values,
				Context context) throws IOException, InterruptedException {
			long sum = 0;
			for (LongWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}
}
