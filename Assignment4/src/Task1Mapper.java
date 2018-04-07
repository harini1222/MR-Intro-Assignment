import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//Write a Map Reduce program to filter out the invalid records. Map only job will fit for this
//context.
public class Task1Mapper extends Mapper<LongWritable,Text, Text, Text> {
        private Text out = new Text();

        protected void map(LongWritable key, Text value, Context context)
            throws java.io.IOException, InterruptedException {
        	String line = value.toString();
        	
        	if (!Validate(line).equals("NA")) {
				out.set(Validate(line));
				context.write(out,new Text());
			}
        	
        
      	  
        }  
        static String Validate(String line) {
    		StringTokenizer stoken = new StringTokenizer(line, "|");
    		while (stoken.hasMoreTokens()) {
    			String token = stoken.nextToken();
    			if (token.equals("NA"))
    				return "NA";
    		}
    		return line;
    	}
}
