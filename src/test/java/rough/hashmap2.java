package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class hashmap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create map to store
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		// create list one and store values
		ArrayList<String> valSetOne = new ArrayList<String>();
		valSetOne.add("Apple");
		valSetOne.add("Aeroplane");
		// create list two and store values
		ArrayList<String> valSetTwo = new ArrayList<String>();
		valSetTwo.add("Bat");
		valSetTwo.add("Banana");
		// create list three and store values
		ArrayList<String> valSetThree = new ArrayList<String>();
		valSetThree.add("Cat");
		valSetThree.add("Car");

		// put values into map
		map.put("A", valSetOne);
		map.put("B", valSetTwo);
		map.put("C", valSetThree);

		// iterate and display values
		System.out.println("Fetching Keys and corresponding [Multiple] Values n");
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> values = entry.getValue();
			System.out.println("Key = " + key);
			System.out.println("Values = " + values + "n");
		}

	}

}
