import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FileTask {

	public static void main(String[] args) {
		
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String word = "";
				List<String> str = new ArrayList<>();

	        BufferedReader reader = null;
	        
	        try {
	            reader = new BufferedReader(new FileReader(new File("D:\\JAVA\\fileExample.txt")));
	            int c;
	            //read the file by symphols
	            while ((c = reader.read()) != -1) { 
	                char ch = (char) c;
	            	//compare symbol with latin character
	                if (chars.contains(Character.toString(ch))) {
	            		word += ch;
	            	}
	            	else {
	            		if (word != "") {
	            			str.add(word);
	            			word = "";
	            		}		
	            	}
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        //sort alphabetically
	        
	        Collections.sort(str);
	        System.out.println("All words int text file - "  + str);
	        
	//        Set<String> wordSet = new TreeSet(str);
	        Map<String , Integer> mapSet = new TreeMap();
	       
	        for (String s : str) {
	        	if (mapSet.containsKey(s)) {
	        		mapSet.put(s , mapSet.get(s) + 1);
	        	} else {
	        		mapSet.put(s , 1);
	        	}
	        }
	        
	        System.out.println("Words and Number of repetitions of words - " + mapSet);
	        
	   }

}


