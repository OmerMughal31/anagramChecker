package beyonnex.task.controller;

import beyonnex.task.inputs.InputStrings;
import beyonnex.task.main.AnagramCheckerRestApi;
import beyonnex.task.response.AnagramResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskRestController {

	AnagramCheckerRestApi anagramChecker = new AnagramCheckerRestApi();

	/***
	 *  Evaluates if two input strings provided in the JSON request are anagrams and returns a Boolean response.
	 * @param request
	 * Method: POST
	 * URL: /checkanagrams
	 * Body: JSON object containing firstString and secondString properties representing the input strings.
	 * @return: True or false
	 */
	@PostMapping(value = "/checkanagrams", consumes = "application/json")
	public Boolean checkAnagrams(@RequestBody InputStrings request) {
		if (request != null) {
			String str1 = request.getFirstString();
			String str2 = request.getSecondString();
			return anagramChecker.evaluateAnagrams(str1, str2);
		} else {
			return null;
		}
	}

	/***
	 * Extracts anagrams for the given input string and returns a list of anagrams.
	 * @param input
	 * Method: GET
	 * URL: /extractanagrams/{input}
	 * Path Variable: input (String) - The input string for which anagrams are to be extracted.
	 * @return Body: A list of anagrams for the provided input string wrapped in an AnagramResponse object.
	 */
	@GetMapping("/extractanagrams/{input}")
	public List<String> getAnagrams(@PathVariable String input) {
		List<String> anagrams = anagramChecker.extractAnagrams(input);
		AnagramResponse anagramResponse = new AnagramResponse();
		anagramResponse.setAnagrams(anagrams);
		return anagramResponse.getAnagrams();
	}
}
