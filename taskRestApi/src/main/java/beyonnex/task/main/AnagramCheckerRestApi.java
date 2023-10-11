package beyonnex.task.main;

import beyonnex.task.service.FeatureImpl;

import java.util.List;
import java.util.Map;

public class AnagramCheckerRestApi {
	/***
	 * The AnagramCheckerRestApi class provides an API for working with anagrams.
	 * It utilizes the FeatureImpl class to perform anagram-related operations,
	 * such as evaluating anagrams, extracting anagrams, and printing anagram sets.
	 * Anagrams are words or phrases formed by rearranging the letters of another,
	 * using all the original letters exactly once.
	 */
	FeatureImpl feature = new FeatureImpl();

	/***
	 * Prints all sets of anagrams found in the given map.
	 * @param anagrams A map where keys represent strings,
	 *                 and values are lists of their corresponding anagrams
	 */
	public void printAllAnagrams(Map<String, List<String>> anagrams) {

		for (List<String> anagramList : anagrams.values()) {
			if (anagramList.size() > 1) {
				System.out.println("All Anagrams in a Run are: " + anagramList);
			}
		}
	}

	/***
	 * Checks if two input strings are anagrams, adds them to the internal storage if they are,
	 * and prints all anagram sets.
	 * @param str1 The first input string that is to be evaluated.
	 * @param str2 The second input string that is to be evaluated.
	 * @return true if the input strings are anagrams and are successfully processed
	 * or false otherwise.
	 */
	public Boolean evaluateAnagrams(String str1, String str2) {
		if (feature.isText(str1) && feature.isText(str2) && feature.areAnagram(str1, str2)) {
			feature.addAnagramPair(str1, str2);
			printAllAnagrams(feature.getAnagramsMap());
			return true;
		}
		return false;
	}

	/***
	 *  Extracts and returns a list of anagrams for a given input string.
	 * @param str The input string for which anagrams are to be extracted.
	 * @return A list of anagrams for the given input string.
	 */
	public List<String> extractAnagrams(String str) {
		return feature.getAnagrams(str);
	}
}
