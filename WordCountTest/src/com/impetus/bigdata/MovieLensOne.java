package com.impetus.bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
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

public class MovieLensOne {

	// static Logger logger = Logger.getLogger(MovieLensOne.class);

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path(
				"/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
		Job job = Job.getInstance(conf);
		job.addCacheFile(new Path("file:///home/impadmin/movielens/movies.dat")
				.toUri());
		job.getCacheFiles();
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

		private Map<String, String> mapMovieMap = new HashMap<String, String>();
		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		@Override
		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			StringTokenizer stringTokenizer = new StringTokenizer(
					value.toString(), ":");
			for (int i = 0; stringTokenizer.hasMoreElements(); i++) {
				if (i == 1) {
					word.set((String) stringTokenizer.nextElement());
					context.write(word, one);
					break;
				} else {
					stringTokenizer.nextElement();
				}
			}
		}

		@Override
		public void setup(Context context) throws IOException {
			System.out.println("Mapper Setupppppppppppppppppppppppppppp");
			Job job = Job.getInstance(context.getConfiguration());
			URI[] uris = job.getCacheFiles();
			if (uris != null) {
				BufferedReader br = null;
				String[] stringArray = null;
				for (URI uri : uris) {
					String currentLine = null;
					br = new BufferedReader(new FileReader(new File(uri)));
					while ((currentLine = br.readLine()) != null) {
						stringArray = currentLine.split(":");
						mapMovieMap.put(stringArray[0], stringArray[1]);
					}
				}
			}

		}
	}

	public static class IntSumReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {

		private Map<String, String> mapMovieMap = new HashMap<String, String>();
		private IntWritable result = new IntWritable();

		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			mapMovieMap.get("1049");
			key.set(mapMovieMap.get(key.toString()));
			context.write(key, result);
		}

		@Override
		public void setup(Context context) throws IOException {
			System.out.println("Reducer Setupppppppppppppppppppppppppppp");
			Job job = Job.getInstance(context.getConfiguration());
			URI[] uris = job.getCacheFiles();
			if (uris != null) {
				BufferedReader br = null;
				String[] stringArray = null;
				for (URI uri : uris) {
					String currentLine = null;
					br = new BufferedReader(new FileReader(new File(uri)));
					while ((currentLine = br.readLine()) != null) {
						stringArray = currentLine.split(":");
						mapMovieMap.put(stringArray[0], stringArray[1]);
					}
				}
			}

		}
	}
}
