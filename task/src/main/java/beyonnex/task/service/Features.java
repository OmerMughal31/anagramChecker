/**
 * The Features interface defines a set of methods for handling anagrams and text
 * processing operations.
 * <p>
 * Implementing classes should provide concrete implementations for these
 * methods, including checking if a string is a valid text, finding anagrams,
 * checking if two strings are anagrams, and adding anagram pairs.
 *
 * @author Omer Shahzad Mughal
 * @version 1.0
 */
package beyonnex.task.service;

import java.util.List;
import java.util.Map;

public interface Features {

	/**
	 * Retrieves the list of anagrams for the given input string.
	 *
	 * @param input The input string for which anagrams are to be retrieved.
	 * @return A list of anagrams for the input string, or an empty list if no
	 *         anagrams are found.
	 */
	List<String> getAnagrams(String input);

	/**
	 * Sorts the characters of a string in alphabetical order.
	 *
	 * @param inputStr The input string to be sorted.
	 * @return The sorted character array.
	 */
	char[] sortedString(char[] inputStr);

	/**
	 * Checks if two input strings are anagrams.
	 *
	 * @param str1 The first input string.
	 * @param str2 The second input string.
	 * @return true if the input strings are anagrams, false otherwise.
	 */
	Boolean areAnagram(String str1, String str2);

	/**
	 * Checks if the input string contains only letters and whitespaces.
	 *
	 * @param input The input string to be validated.
	 * @return true if the input is a valid text (contains only letters and
	 *         whitespaces), false otherwise.
	 */
	boolean isText(String input);

	/**
	 * Adds a pair of anagrams to the anagrams collection.
	 *
	 * @param str1 The first string in the anagram pair.
	 * @param str2 The second string in the anagram pair.
	 */
	void addAnagramPair(String str1, String str2);
}
