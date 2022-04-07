package Hash;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class CovidData {
    Hashtable<String,Integer> data;
	public CovidData(String filename) {
		data = new Hashtable<String,Integer>();
		try {
			Scanner in = new Scanner(new File(filename));
			in.useDelimiter(",");
			while(in.hasNext()) {
				String[] next = in.nextLine().split(",");
				data.put(next[0],Integer.parseInt(next[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public int find(String d) {
		if(!data.containsKey(d)) return -1;
		else {
			return data.get(d);
		}

	}
    
}
