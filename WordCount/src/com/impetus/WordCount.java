package com.impetus;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,InterruptedException,ClassNotFoundException{
		// TODO Auto-generated method stub
		
		if(args.length!=2){
			System.out.println("Syntax:WordCount <path to input> <path to output>");
			System.exit(-1);
		}
		
		Job job=new Job();
		job.setJarByClass(WordCount.class);
		job.setJobName("Word Count");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));		
		
		//set Mapper and reducers
		//job.setMapperClass(WordCountMapper.class);  //for Simple WordCount
		job.setMapperClass(WordCounterMapperVovel.class);  //for vovel count
		job.setReducerClass(WordCountReducer.class);
		
		//set key, value output format
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true)?0:1);
		
	}

}
