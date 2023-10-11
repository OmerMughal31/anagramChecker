/**
 * The FeatureImpl class implements the Features interface, providing
 * functionality related to anagrams and text processing.
 * <p>
 * This class maintains a map of anagram pairs and offers methods to perform
 * various operations on strings, including checking if two strings are
 * anagrams, finding anagrams for a given string, and adding new anagram pairs
 * to the map.
 *
 * @author Omer Shahzad Mughal
 * @version 1.0
 * @see Features
 */
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

	private final Map<String, List<String>> anagramsMap = new HashMap<>();

	/**
	 * Retrieves the anagrams map.
	 *
	 * @return A map containing string keys and their corresponding lists of
	 *         anagrams.
	 */
	public Map<String, List<String>> getAnagramsMap() {
		return anagramsMap;
	}

	/**
	 * Checks if the input string contains only letters and whitespaces.
	 *
	 * @param input The input string to be validated.
	 * @return true if the input is a valid text (contains only letters and
	 *         whitespaces), false otherwise.
	 */
	@Override
	public boolean isText(String input) {
		return input != null && !input.isEmpty() && input.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c));
	}

	/**
	 * Retrieves the list of anagrams for the given input string.
	 *
	 * @param input The input string for which anagrams are to be retrieved.
	 * @return A list of anagrams for the input string, or an empty list if no
	 *         anagrams are found.
	 */
	@Override
	public List<String> getAnagrams(String input) {

		return this.anagramsMap.getOrDefault(input, Collections.emptyList());
	}

	/**
	 * Sorts the characters of a string in alphabetical order using bubble sort
	 * algorithm.
	 *
	 * @param charArray The character array to be sorted.
	 * @return The sorted character array.
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

	/**
	 * Checks if two input strings are anagrams.
	 *
	 * @param str1 The first input string.
	 * @param str2 The second input string.
	 * @return true if the input strings are anagrams, false otherwise.
	 */
	@Override
	public Boolean areAnagram(String str1, String str2) {
		char[] charArray1 = str1.replaceAll("[\\s]", "").toLowerCase().toCharArray();
		char[] charArray2 = str2.replaceAll("[\\s]", "").toLowerCase().toCharArray();
		return Arrays.equals(sortedString(charArray1), sortedString(charArray2));
	}

	/**
	 * Adds a pair of anagrams to the anagrams map.
	 *
	 * @param str1 The first string in the anagram pair.
	 * @param str2 The second string in the anagram pair.
	 */
	@Override
	public void addAnagramPair(String str1, String str2) {
		this.anagramsMap.computeIfAbsent(str1, k -> new ArrayList<>()).add(str2);
		this.anagramsMap.computeIfAbsent(str2, k -> new ArrayList<>()).add(str1);
	}
}
