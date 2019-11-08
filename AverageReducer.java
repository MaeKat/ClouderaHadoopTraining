package stubs;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

	  int wordOccurrence =0;
	  double letterCounter =0;
    /*
     * TODO implement
     */
	 
		for (IntWritable value : values) {
		  
		  /*
		   * Add the value to the word count counter for this key.
		   */
			
			letterCounter += value.get();//counts the number of letters
			wordOccurrence ++;
		}
		
		/*
		 * Call the write method on the Context object to emit a key
		 * and a value from the reduce method. 
		 */
		double averageLength = letterCounter/wordOccurrence;
		context.write(key, new DoubleWritable(averageLength));
	  
  }
}