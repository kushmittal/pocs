package com.impetus.bigdata;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//import org.apache.log4j.Logger;

public class MovieLensSix {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path(
				"/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.setJarByClass(MovieLensSix.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	public static class TokenizerMapper extends
			Mapper<Object, Text, Text, FloatWritable> {

		private final static FloatWritable one = new FloatWritable(1);
		private Text word = new Text();

		@Override
		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] stringArray = value.toString().split(":");
			word.set(stringArray[1]);
			one.set(Float.valueOf(stringArray[2]));
			context.write(word, one);
		}
	}

	public static class IntSumReducer extends
			Reducer<Text, FloatWritable, Text, Movie> {

		public void reduce(Text key, Iterable<FloatWritable> values,
				Context context) throws IOException, InterruptedException {
			
			float sumRating = 0;
			int numberTimes = 0;
			boolean maxMinRating = false;
			for (FloatWritable val : values) {
				sumRating += val.get();
				numberTimes++;
				if(val.get() == 5 || val.get() == 1){
					maxMinRating = true;
				}
			}
			if(maxMinRating)
			{
				Movie movie = new Movie(sumRating/numberTimes, key.toString());
				context.write(key, movie);
			}
			
		}
	}
}

class Movie {
	private int maxRating;
	private int minRating;
	private float avgRating;
	private String movieId;

	@Override
	public String toString() {
		return "Movie [maxRating=" + maxRating + ", minRating=" + minRating
				+ ", avgRating=" + avgRating + ", movieId=" + movieId + "]";
	}

	public Movie(float avgRating,
			String movieId) {
		super();
		this.maxRating = 5;
		this.minRating = 1;
		this.avgRating = avgRating;
		this.movieId = movieId;
	}

}
