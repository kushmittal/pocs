package com.impetus.bigdata;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.log4j.Logger;

public class MovieLensTwo {

	//static Logger logger = Logger.getLogger(MovieLensOne.class);
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path("/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.setJarByClass(MovieLensOne.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	public static class TokenizerMapper extends
			Mapper<Object, Text, Text, IntWritable> {

		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			StringTokenizer stringTokenizer = new StringTokenizer(value.toString(),":");
			for(int i = 0 ; stringTokenizer.hasMoreElements();i++)
			{
				if(i==0)
				{
					word.set((String) stringTokenizer.nextElement());
			        context.write(word, one);
				}
				else
				{
					stringTokenizer.nextElement();					
				}
			}
			/*if ((stringArray != null && stringArray[1] != null)
					|| stringArray[2] != null) {
				word.set(stringArray[1]);
				if (stringArray[2] == null) {
					one.set(0);
					context.write(word,  one);
				} else {
					one.set(Double.valueOf(stringArray[2]));
					context.write(word,  one);
				}

			}*/
			
			
		}
	}

	public static class IntSumReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				 sum += val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}
}
