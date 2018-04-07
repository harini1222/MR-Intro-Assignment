import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Assgn4Task1 {

	public static void main(String[] args) 
            throws IOException, ClassNotFoundException, InterruptedException {

//Job Related Configurations
Configuration conf = new Configuration();
Job job = new Job(conf, "Assignment 4	");
job.setJarByClass(Assgn4Task1.class);

//Explicitly set the reduce task to zero so that the reducer does not come into the picture
job.setNumReduceTasks(0);

//Set the mapper class
job.setMapperClass(Task1Mapper.class);

//Set the output key class and values
job.setMapOutputKeyClass(Text.class);
job.setMapOutputValueClass(Text.class);

//Set the path to take input file
FileInputFormat.addInputPath(job, new Path(args[0]));

//set the out path and delete it on the second run
Path outputPath = new Path(args[1]);
FileOutputFormat.setOutputPath(job, outputPath);
outputPath.getFileSystem(conf).delete(outputPath, true);

//Execute the job
job.waitForCompletion(true);

}

}
