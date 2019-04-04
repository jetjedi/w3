import java.io.File;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) throws Exception{
		
		String myFile = "C:\\piglatin.txt";
		String currentWord;
		
		File file = new File(myFile);
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()) {
			currentWord = input.next();
			System.out.println(currentWord + "\t " + convertWord(currentWord));
		}
		input.close();

	}

	public static String convertWord(String word) {
		
		String wordLower = word.toLowerCase();	//force word to lower to find vowel index, non-case
		int length = wordLower.length();
		int index = -1; 						//assign to default -1 in case no vowel is found
		
		//find if a vowel exists in the word and assign the index location
		for (int i = 0; i < length; i++) {
			if (wordLower.charAt(i) == 'a' ||
				wordLower.charAt(i) == 'e' ||
				wordLower.charAt(i) == 'i' ||
				wordLower.charAt(i) == 'o' ||
				wordLower.charAt(i) == 'u'){
					
				index = i;
				if (index !=-1) {
					if (index == 0) {
						return wordLower.toUpperCase() + "WAY";
					}
					else {
						return wordLower.substring(index).toUpperCase() + 
								wordLower.substring(0,index).toUpperCase() + "AY";	
					}					
				}
				else {
					return "No vowel found";
				}
			}		
		}		
		return null;
	}
}
