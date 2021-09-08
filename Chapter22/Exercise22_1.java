import java.util.*;

 class Exercise22_1 {
	 private static Scanner input;

	public static void main(String[] args) {
		 input = new Scanner(System.in);
		 
		 ArrayList<Character> max = new ArrayList<>();
		 ArrayList<Character> list = new ArrayList<>();

		 System.out.print("Enter a string: ");
		 String s = input.nextLine(); 

			for (int i = 0; i < s.length(); i++) { 
				if (list.size() > 1 && s.charAt(i) <= list.get(0) && 
					list.contains(s.charAt(i))) {
					list.clear(); 
				}

				list.add(s.charAt(i));

				if (list.size() > max.size()) { 
					max.clear();
					max.addAll(list);
				}
			}
			
			System.out.print("The maximum consecutive substring is: " );
			
			for (Character ch: max) { 
				System.out.print(ch); 
			}
		}
 }

 /*
  * 	2 for loops;
  * 	T(n) = O(n) Linear
  */