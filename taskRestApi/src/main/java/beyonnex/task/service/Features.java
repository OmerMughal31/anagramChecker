package beyonnex.task.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Features {

	/***
	 * Retrieves a list of anagrams for a given input string.
	 * @param input The input string for which anagrams are to be retrieved.
	 * @return A list of anagrams for the given input string.
	 */
	List<String> getAnagrams(String input);

	/***
	 * Sorts an array of characters using bubble sort and returns the sorted array.
	 * @param inputStr The array of characters to be sorted.
	 * @return A sorted array of characters.
	 */
	char[] sortedString(char[] inputStr);

	/***
	 *  Checks if two input strings are anagrams of each other.
	 * @param str1 The first input string/ text
	 * @param str2 The second input string/ text
	 * @return true if the input strings are anagrams
	 * or false otherwise.
	 */
	Boolean areAnagram(String str1, String str2);

	/***
	 * Determines if a given input string contains only letters and whitespace.
	 * @param input String that is to be validated.
	 * @return true if the input test/ string consists only of letters and whitespace
	 * or false otherwise.
	 */
	boolean isText(String input);

	/***
	 * Adds a pair of anagrams to the internal storage.
	 * @param str1 The first string in the anagram pair.
	 * @param str2 The second string in the anagram pair.
	 */
	void addAnagramPair(String str1, String str2);
}
