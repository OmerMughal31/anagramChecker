# Anagram Checker Application

This Java application allows users to check, evaluate, and extract anagrams. Anagrams are words or phrases formed by
rearranging the letters of a different word or phrase, using all the original letters exactly once.

## Features

- **Check Anagrams:** Check if two input strings are anagrams.
- **Evaluate Anagrams:** Input two strings and check if they are anagrams. Print anagrams found and add anagram pairs.
- **Extract Anagrams:** Input a string and find its anagrams based on predefined conditions.

## Implementation Details

### Classes

- **FeatureImpl:** Implements the anagram-related functionalities including checking if strings are anagrams, sorting
  strings, and managing anagrams pairs.
- **AnagramChecker:** The main controller class facilitating user input, anagram processing, and output display.

### Exception Handling

- **IllegalArgumentException:** Thrown for invalid inputs. Specific error messages are provided for different cases.

## Usage
Build mvn project with Java 17

Run Application in IntelliJ with Java17 or your favourite IDE
## Usage Examples
### To check anagrams
```
Enter two strings to check if they are anagrams (or type 'exit' to quit):
listen
silent
The two strings are anagrams!
All Anagrams in a Run are: [listen, silent]
Goodbye!!!
```
### To extract strings
```
Enter a string to find its anagrams (or type 'exit' to quit):
listen
Anagrams for listen: [silent]
Enter a string to find its anagrams (or type 'exit' to quit):
exit
Goodbye!!!
```
