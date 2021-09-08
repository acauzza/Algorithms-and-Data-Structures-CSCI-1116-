import java.util.*;

public class Exercise22_3 {
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		System.out.print("Enter a string s1: ");
		String string1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String string2 = input.nextLine();

		int index = -1;
		int matches = 0;


		for (int i = 0; i < string1.length(); i++) {
			if (string1.charAt(i) == string2.charAt(0) && matches == 0) {
				index = i;
				matches++;
			}
			else if (string1.charAt(i) == string2.charAt(matches)) {
				matches++;
			}
			else {
				matches = 0;
				index = -1;
			}

			if (matches == string2.length())
				break;
		}

		if (index > 1)
			System.out.println("matched at index " + index);
		else
			System.out.println("string2 is not a substring of string1");
	}
}