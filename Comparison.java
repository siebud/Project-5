import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Comparison {

	private String id;
	int zerod = 0;
	int ones = 0;	// count for nodes
	int twos = 0;
	int threes = 0;
	int fours = 0;
		ArrayList<String> zero = new ArrayList<String>(); // lists of stations each distance away from id
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<String> two = new ArrayList<String>();
		ArrayList<String> three = new ArrayList<String>();
		ArrayList<String> four = new ArrayList<String>();
		
	public Comparison(String ID)throws IOException {
		ArrayList<String> all = new ArrayList<String>();	
		   
		id = ID;
		File file = new File("Mesonet.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while(line != null) {
				all.add(line);						// makes all a list of the names
				line = br.readLine();				// read next line
			}
			br.close();

		for(int i = 0; i<all.size() ;i++) {			// add up distance of names from ID
			int distance = getHammingDist(id, all.get(i));
			switch(distance) {
			case 0:
				zero.add(all.get(i));
				zerod++;
				break;
			case 1:
				one.add(all.get(i));
				ones++;	
				break;
			case 2:
				two.add(all.get(i));
				twos++;
				break;
			case 3:
				three.add(all.get(i));
				threes++;
				break;
			case 4:
				four.add(all.get(i));
				fours++;
				break;
			}
		}
			
		}	
	
	public int getHammingDist(String a, String b) {
	int count = 0;
		for (int i = 0;i<a.length(); i++ ) {
			if (a.charAt(i) != b.charAt(i)) 
				count++;
		}
	return count;		
	}
	
	public int getZeros() {
		return zerod;
	}
	public int getOnes() {
		return ones;
	}
	public int getTwos() {
		return twos;
	}
	public int getThrees() {
		return threes;
	}
	public int getFours() {
		return fours;
	}
	public ArrayList<String> getNames(int away){
		if(away ==1)
			return one;
		if(away ==2)
			return two;
		if(away == 3)
			return three;
		if(away == 4)
			return four;
		else 
			return zero;
		
	}
}