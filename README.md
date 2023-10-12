# Anagram Checker

Anagram Checker is a project developed as an interview task to check if two strings are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of a different word or phrase, using all the original letters exactly once. This project provides two different solution approaches to solving the anagram problem:

## 1. User Interactive Approach
This approach allows users to input two strings and checks whether they are anagrams. It provides a simple and straightforward way for users to interactively check anagrams.

### How to Use the User Interactive Approach:
1. Run the application.
2. Enter the first string.
3. Enter the second string.
4. The application will output whether the input strings are anagrams or not.

## 2. REST API Approach
This approach provides a RESTful API for checking anagrams. Users can send HTTP requests with two strings as parameters, and the API will respond with a JSON object indicating whether the strings are anagrams.

### How to Use the REST API Approach:
1. Start the server.
2. Send a POST request to the `/checkAnagrams` endpoint with the following JSON payload:
   ```json
   {
     "firstString": "your_first_string",
     "secondString": "your_second_string"
   }
   ```
3. Send a Get request to the `/extractAnagrams/{your-string}` endpoint.
