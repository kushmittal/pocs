package com.impetus;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	
		@Override
		public void reduce(Text key,Iterable<IntWritable> value,Context context) throws IOException,InterruptedException{
			
			/*
			 * here key is the word and size of val will be the number of counts
			 * 
			 */
			int count=0;
			for(IntWritable v:value){
				count++;
			}
			IntWritable val=new IntWritable(count);
			context.write(key, val);
		}
	
}
