package com.impetus;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCounterMapperVovel extends Mapper<LongWritable,Text,Text,IntWritable> {


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
			String str=t.toString();
			if(str.length()>0){
				switch(str.substring(0, 1).toUpperCase()){
				case "A":
					t.set("A");
					context.write(t, val);
					break;
				case "E":
					t.set("E");
					context.write(t, val);
					break;
				case "I":
					t.set("I");
					context.write(t, val);
					break;
				case "O":
					t.set("O");
					context.write(t, val);
					break;
				case "U":
					t.set("U");
					context.write(t, val);
					break;


				}
			}
			
			/*
			if(str.charAt(0)=='A' || str.charAt(0)=='a' || str.charAt(0)=='E'|| str.charAt(0)=='e'|| str.charAt(0)=='I'|| str.charAt(0)=='i'
					  || str.charAt(0)=='O'|| str.charAt(0)=='o'|| str.charAt(0)=='U'|| str.charAt(0)=='u' ){
				t.set(stk.nextToken());
				context.write(t, val);
			}*/
			
		}
		
	}

}
