# Anagram Checker REST API

This RESTful API provides an interface for anagram-related operations, 
including checking if two strings are anagrams and extracting anagrams from a given input string.

## Endpoints

### 1. Check Anagrams

#### `POST /checkanagrams`

Evaluates if two input strings are anagrams.

- **Request:**
    - Method: `POST`
    - URL: `/checkanagrams`
    - Body: JSON object containing `firstString` and `secondString` properties representing the input strings.
- **Response:**
    - Body: `true` if the input strings are anagrams, `false` otherwise. Returns `null` if the request body is invalid.

### 2. Extract Anagrams

#### `GET /extractanagrams/{input}`

Extracts anagrams for the given input string.

- **Request:**
    - Method: `GET`
    - URL: `/extractanagrams/{input}`
    - Path Variable: `input` (String) - The input string for which anagrams are to be extracted.
- **Response:**
    - Body: A list of anagrams for the provided input string wrapped in an `AnagramResponse` object.

## Usage

1. **Check Anagrams:**
    - Send a POST request to `/checkanagrams` with a JSON object containing `firstString` and `secondString`.
    - Example Request Body: `{"firstString": "listen", "secondString": "silent"}`
    - Example Response Body: `true` (if anagrams) or `false` (if not anagrams)

2. **Extract Anagrams:**
    - Send a GET request to `/extractanagrams/{input}` where `{input}` is the input string for which anagrams are to be extracted.
    - Example URL: `/extractanagrams/listen`
    - Example Response Body: `{"anagrams": ["silent", "enlist"]}`

## Dependencies

- Java 17
- Spring Boot
- Maven or Gradle for build management

## Build and Run

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd anagram-checker-api
   ```

2. Build the project:

   For Maven:

   ```bash
   mvn clean install
   ```

   For Gradle:

   ```bash
   gradle build
   ```

3. Run the application:

   For Maven:

   ```bash
   mvn spring-boot:run
   ```

   The application will start and be accessible at `http://localhost:8080`.
