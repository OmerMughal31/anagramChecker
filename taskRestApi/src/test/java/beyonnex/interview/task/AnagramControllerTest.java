package beyonnex.interview.task;

import beyonnex.task.controller.TaskRestController;
import beyonnex.task.inputs.InputStrings;
import beyonnex.task.main.AnagramCheckerRestApi;
import beyonnex.task.service.FeatureImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AnagramControllerTest {
	/***
	 * Class contains some tests to test the functionality of anagram checking api
	 * anagramController is @{@link TaskRestController}
	 * anagramChecker is @{@link AnagramCheckerRestApi}
	 */
	@InjectMocks
	private TaskRestController anagramController;

	@Mock
	private AnagramCheckerRestApi anagramChecker;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCheckAnagramsSuccess() {
		InputStrings inputStrings = new InputStrings();
		inputStrings.setFirstString("listen");
		inputStrings.setSecondString("silent");

		// Mock the anagramChecker
		when(anagramChecker.evaluateAnagrams("listen", "silent")).thenReturn(true);
		Boolean result = anagramController.checkAnagrams(inputStrings); // Produces the results after checking anagramity of strings
		assertTrue(result); // evaluations
		verify(anagramChecker).evaluateAnagrams("listen", "silent"); // Verification of method mocked and execution results
	}

	@Test
	void testCheckAnagramsFailure() {
		InputStrings inputStrings = new InputStrings();
		inputStrings.setFirstString("hello");
		inputStrings.setSecondString("world");

		// Mocking the anagramChecker
		Boolean result = anagramController.checkAnagrams(inputStrings);

		assertFalse(result); // Assuming "Are Anagrams" is returned for both success and failure

		// Verification of method mocked and execution results
		verify(anagramChecker, times(1)).evaluateAnagrams("hello", "world");
	}

	@Test
	void testCheckAnagramsNullInput() {
		Boolean result = anagramController.checkAnagrams(null);

		assertNull(result);
		verify(anagramChecker, never()).evaluateAnagrams(any(), any());
	}

	@Test
	void testExtractAnagrams_Success() {
		String input = "listen";
		List<String> expectedAnagrams = Arrays.asList("silent", "enlist");

		// Mock the anagramChecker
		when(anagramChecker.extractAnagrams(input)).thenReturn(expectedAnagrams);
		List<String> result = anagramController.getAnagrams(input);
		assertNotNull(result);
		assertEquals(expectedAnagrams, result);
		verify(anagramChecker).extractAnagrams(input);
	}

	@Test
	void testGetAnagramsEndpoint_Success() {
		String input = "listen";
		List<String> expectedAnagrams = Arrays.asList("silent", "enlist");

		// Mock the anagramChecker
		when(anagramChecker.extractAnagrams(input)).thenReturn(expectedAnagrams);
		List<String> response = anagramController.getAnagrams(input);
		assertNotNull(response);
		assertEquals(expectedAnagrams, response);
		verify(anagramChecker).extractAnagrams(input);
	}

}
