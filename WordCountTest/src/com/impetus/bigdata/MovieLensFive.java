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

public class MovieLensFive {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path(
				"/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.setJarByClass(MovieLensFive.class);
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
			word.set(stringArray[0]);
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
			if(key.toString().equals("10349"))
			{
				System.out.println("testing");
			}
			for (FloatWritable val : values) {
				sumRating += val.get();
				numberTimes++;
				if(val.get() == 5 || val.get() == 1){
					maxMinRating = true;
				}
			}
			if(maxMinRating)
			{
				Movie movie = new Movie(sumRating/numberTimes, null);
				context.write(key, movie);
			}
			
		}
	}
}

/*FileSystem fs = FileSystem.get(new Configuration());
Path path=new Path(args[0]+ "/movie.dat");
path = path.makeQualified(fs);
BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
String line;
line=br.readLine();
while (line != null){
        System.out.println(line);
        line=br.readLine();
}*/
//FileInputFormat.addInputPaths(job, );
//FileInputFormat.setInputDirRecursive(job, true);
