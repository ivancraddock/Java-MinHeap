package taxman;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class TaxProgram {
   
    public static void main(String Args[]){
        Random generator = new Random();
        int taxid = 0;
        MinHeap prime = new MinHeap(1000);
        try{
        	  // Open the file that is the first 
        	  // command line parameter
        	  FileInputStream fstream = new FileInputStream("data.txt");
        	  // Get the object of DataInputStream
        	  DataInputStream in = new DataInputStream(fstream);
        	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
        	  String strLine;
        	  //Read File Line By Line
        	  while ((strLine = br.readLine()) != null)   {
        	  // Print the content on the console
        		  int comparator = Integer.parseInt(strLine);
        		  if(taxid<999){
                      prime.insert(new HeapNode(taxid, comparator));
                  }
                  else{
                      if(comparator >= prime.getMin()){
                          prime.removemin();
                          prime.insert(new HeapNode(taxid, comparator));
                      }
                  }
                  taxid++;
        		  
        	  }
        	  //Close the input stream
        	  in.close();
        	    }catch (Exception e){//Catch exception if any
        	  System.err.println("Error: " + e.getMessage());
        	  }
        prime.print();
       
        System.out.println(prime.getMin());
    }

}