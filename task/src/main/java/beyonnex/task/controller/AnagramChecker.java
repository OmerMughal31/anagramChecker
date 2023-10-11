/**
 * The AnagramChecker class is responsible for interacting with the user to check,
 * evaluate, and extract anagrams based on user input. It utilizes the FeatureImpl
 * class to perform anagram-related operations.
 *
 * Anagrams can be checked, evaluated, and extracted through user interaction via
 * the console. The class provides methods to print all anagrams, evaluate anagrams
 * inputted by the user, and extract anagrams for a given input string.
 *
 * This class serves as the controller in the application, facilitating user input,
 * anagram processing, and output display.
 *
 * @author Omer Shahzad Mughal
 * @version 1.0
 * @see FeatureImpl
 */
package beyonnex.task.controller;

import beyonnex.task.service.FeatureImpl;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class AnagramChecker {
	FeatureImpl feature = new FeatureImpl();
	Scanner scanner = new Scanner(System.in);

	/**
	 * Prints all anagrams in the provided map.
	 *
	 * @param anagrams A map containing string keys and their corresponding lists of anagrams.
	 */
	public void printAllAnagrams(Map<String, List<String>> anagrams) {

		for (List<String> anagramList : anagrams.values()) {
			if (anagramList.size() > 1) {
				System.out.println("All Anagrams in a Run are: " + anagramList);
			}
		}
	}

	/**
	 * Allows the user to input two strings and checks if they are anagrams.
	 * Prints the result and adds the anagram pair to the anagrams map.
	 */
	public void evaluateAnagrams() {

		while (true) {
			System.out.println("Enter two strings to check if they are anagrams (or type 'exit' to quit):");
			String input1 = scanner.nextLine();
			if (feature.isText(input1)) {
				if (input1.equalsIgnoreCase("exit")) {
					break;
				}
				String input2 = scanner.nextLine();
				if (feature.isText(input2)) {

					if (feature.areAnagram(input1, input2)) {
						System.out.println("The two strings are anagrams!");
						feature.addAnagramPair(input1, input2);
					} else {
						System.out.println("The two strings are not anagrams.");
					}
				}
				printAllAnagrams(feature.getAnagramsMap());
				System.out.println("Goodbye!!!");
			}
			else {
				System.out.println("The given text is not valid. Enter a valid text");
			}

		}
	}

	/**
	 * Allows the user to input a string and extracts its anagrams.
	 * Prints the extracted anagrams for the input string.
	 */
	public void extractAnagrams() {
		while (true) {
			System.out.println("Enter a string to find its anagrams (or type 'exit' to quit):");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				break;
			}
			List<String> anagrams = feature.getAnagrams(input);

			List<String> extractedAnagrams = new ArrayList<>();
			for (String anagram : anagrams) {
				if (feature.areAnagram(input, anagram) && !input.equals(anagram)) {
					extractedAnagrams.add(anagram);
				}
			}
			System.out.println("Anagrams for " + input + ": " + extractedAnagrams);
		}
		System.out.println("Goodbye!!!");
	}
}
