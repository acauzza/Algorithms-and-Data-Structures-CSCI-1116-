/*
 * Name: Amanda Cauzza
 * Date: 9/1/21
 */

import java.util.*;

public class Exercise21_7 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		//Revise TreeMap to HashSet
		Map<String, Integer> map = new HashMap<String, Integer>();

		//
		String[] words = text.split("[ \n\t\r.,;:!?()]");
		for (String word: words) {
			String key = word.toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		ArrayList<WordOccurrence> list = new ArrayList<>();
		
		map.forEach((k, v) -> list.add(new WordOccurrence(k, v)));
		Collections.sort(list);
		System.out.println(list);
	}
}