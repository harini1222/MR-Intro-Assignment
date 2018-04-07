package com.acadgild.Assgn4Task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task2Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    public void map(LongWritable key, Text value,
                    Mapper.Context context) throws IOException, InterruptedException {
      String line = value.toString();
      StringTokenizer tokenizer = new StringTokenizer(line,"|");
      ArrayList companies = new ArrayList<String>();
      while (tokenizer.hasMoreTokens()) {
    	 // System.out.println(tokenizer.nextToken());
    	  companies.add(tokenizer.nextToken());
        //word.set(tokenizer.nextToken());
      }
      for(int i=0;i<companies.size();i=i+6)
    	 // System.out.println(companies.get(i));
    	  context.write(new Text(companies.get(i).toString()), one);
    }
  }
