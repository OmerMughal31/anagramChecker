package beyonnex.interview.task;

import beyonnex.task.controller.AnagramChecker;
import beyonnex.task.service.FeatureImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	private FeatureImpl feature;

	@InjectMocks
	private AnagramChecker anagramChecker1;
	@Mock
	private Scanner scanner;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach


	@Test
	void validStrings() {
		String text1 = "foo bl aL, foo";
		String text2 = "foo bl aL @";
		String text3 = "";
		String text4 = "Foo Baar";

		assertFalse(feature.isText(text1));
		assertFalse(feature.isText(text2));
		assertFalse(feature.isText(text3));
		assertTrue(feature.isText(text4));
	}

	@Test
	void areAnagrams() {
		assertTrue(feature.areAnagram("Funeral", "Fun Real"));
	}

	@Test
	void areNotAnagrams() {
		assertFalse(feature.areAnagram("Funerala", "Fun Reale"));
	}


	@Test
	void testAreAnagrams() {
		when(scanner.nextLine()).thenReturn("listen", "silent", "exit");
		anagramChecker1.evaluateAnagrams();
		verify(scanner, times(3)).nextLine(); // Checks if nextLine() was called 3 times
	}

}
