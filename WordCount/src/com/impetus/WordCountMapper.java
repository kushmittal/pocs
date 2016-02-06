package com.impetus;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {


		@Override
		public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException{
			
			/*
			 * here key will denote line offset, text is the line, 
			 * Tokeinze the line, iterate it and put each word in context as key and value as 1 by wrapper of WritableInt
			 */
			IntWritable val=new IntWritable(1);
			StringTokenizer stk=new StringTokenizer(value.toString());
			while(stk.hasMoreTokens()){
				Text t=new Text();
				t.set(stk.nextToken());
				context.write(t, val);
			}
			
		}
}
