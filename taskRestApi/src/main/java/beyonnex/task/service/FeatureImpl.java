package beyonnex.task.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeatureImpl implements Features {
	/***
	 *The FeatureImpl class implements the Features interface, providing functionality related
	 * to anagrams and text manipulation. Anagrams are words or phrases formed by rearranging
	 * the letters of another, using all the original letters exactly once.
	 * This class manages anagrams, checks if two strings are anagrams, and handles the storage of anagram pairs.
	 */

	private final Map<String, List<String>> anagramsMap = new HashMap<>();

	public Map<String, List<String>> getAnagramsMap() {
		return anagramsMap;
	}

	/***
	 * Determines if a given input string contains only letters and whitespace.
	 * @param input String that is to be validated.
	 * @return true if the input test/ string consists only of letters and whitespace
	 * or false otherwise.
	 */
	@Override
	public boolean isText(String input) {
		return input != null && !input.isEmpty() && input.chars().allMatch(
				c -> Character.isLetter(c) || Character.isWhitespace(c));
	}

	/***
	 * Retrieves a list of anagrams for a given input string.
	 * @param input The input string for which anagrams are to be retrieved.
	 * @return A list of anagrams for the given input string.
	 */
	@Override
	public List<String> getAnagrams(String input) {

		return this.anagramsMap.getOrDefault(input, Collections.emptyList());
	}

	/***
	 * Sorts an array of characters using bubble sort and returns the sorted array.
	 * @param charArray The array of characters to be sorted.
	 * @return A sorted array of characters.
	 */
	@Override
	public char[] sortedString(char[] charArray) {

		// Perform bubble sort
		for (int i = 0; i < charArray.length - 1; i++) {
			for (int j = 0; j < charArray.length - i - 1; j++) {
				if (charArray[j] > charArray[j + 1]) {
					// Swap characters
					char temp = charArray[j];
					charArray[j] = charArray[j + 1];
					charArray[j + 1] = temp;
				}
			}
		}
		return charArray;
	}

	/***
	 *  Checks if two input strings are anagrams of each other.
	 * @param str1 The first input string/ text
	 * @param str2 The second input string/ text
	 * @return true if the input strings are anagrams
	 * or false otherwise.
	 */
	@Override
	public Boolean areAnagram(String str1, String str2) {
		char[] charArray1 = str1.replaceAll("[\\s]", "").toLowerCase().toCharArray();
		char[] charArray2 = str2.replaceAll("[\\s]", "").toLowerCase().toCharArray();
		return Arrays.equals(sortedString(charArray1), sortedString(charArray2));
	}

	/***
	 * Adds a pair of anagrams to the internal storage.
	 * @param str1 The first string in the anagram pair.
	 * @param str2 The second string in the anagram pair.
	 */
	@Override
	public void addAnagramPair(String str1, String str2) {
		this.anagramsMap.computeIfAbsent(str1, k -> new ArrayList<>()).add(str2);
		this.anagramsMap.computeIfAbsent(str2, k -> new ArrayList<>()).add(str1);
	}
}
