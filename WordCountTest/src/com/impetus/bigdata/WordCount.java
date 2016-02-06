package com.impetus.bigdata;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
    	int i =0;
    	System.out.println(key.toString());
    	System.out.println("timer"+ i++);
    	System.out.println(value.toString());
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }
  
  /*public static class WordPartitioner extends Partitioner<Text, IntWritable>
  {

	@Override
	public int getPartition(Text key, IntWritable value, int numPartitions) {
		return key.toString().hashCode() * numPartitions;
	}
	  
  }*/
  
  public static class WordCombiner extends WritableComparator
  {

	  protected WordCombiner() {
		  super(Text.class, true);
		  System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
	    } 
	  
	@Override
	public int compare(WritableComparable o1, WritableComparable o2) {
		 Text key1 = (Text) o1;
	        Text key2 = (Text) o2;   
		return -1 * key1.compareTo(key2);
	}
	  
  }
  

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
    	  System.out.println(val+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        sum += val.get();
      }
      System.out.println("sum="+sum);
      result.set(sum);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    conf.addResource(new Path("/home/impadmin/hadoop-2.2.0/etc/hadoop/core-site.xml"));
    Job job = new Job(conf,"word count");
    //Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    //job.setPartitionerClass(WordPartitioner.class);
    job.setReducerClass(IntSumReducer.class);
    job.setSortComparatorClass(WordCombiner.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}