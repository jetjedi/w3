import java.io.File;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) throws Exception{
		
		String myFile = "C:\\piglatin.txt";
		String currentWord;
		
		//create File instance to pass to Scanner
		File file = new File(myFile);
		Scanner input = new Scanner(file);
		
		//keep reading myFile and break up words by space, then pass each word to get converted into pigLatin.
		while (input.hasNextLine()) {
			currentWord = input.next();
			System.out.println(currentWord + "\t " + convertWord(currentWord));
		}
		input.close();

	}

	public static String convertWord(String word) {
		
		String wordLower = word.toLowerCase();	//force word to lower to find vowel index, non-case
		int length = wordLower.length();		//find the length of each word so that I can iterate through a loop.
		int index = -1; 						//assign to default -1 in case no vowel is found
		
		//find if a vowel exists in the word and assign the index location
		for (int i = 0; i < length; i++) {
			if (wordLower.charAt(i) == 'a' ||
				wordLower.charAt(i) == 'e' ||
				wordLower.charAt(i) == 'i' ||
				wordLower.charAt(i) == 'o' ||
				wordLower.charAt(i) == 'u'){
				
				index = i;
				
				//if vowel found, covert it
				if (index !=-1) {
					if (index == 0) {
						return wordLower.toUpperCase() + "WAY"; //when leading vowel is found, convert it to upper case and add WAY
					}
					else {
						//return everything after the 1st vowel, including the vowel 
						return wordLower.substring(index).toUpperCase() + 
								//grab the first letter up to the 1st vowel and add it to the end + AY
								wordLower.substring(0,index).toUpperCase() + "AY";	
					}					
				}
				else {
					return "No vowel found"; //in case no vowel is found in the word
				}
			}		
		}		
		return null; //to satisfy the eclipse error
	}
}
