package com.mycompany.pathologylabsystem;

import java.io.*;
import java.util.*;

/**
 * The FileManager class handles the reading and writing of patient, test, and user data from and to text files.
 * This class ensures that the system can store and retrieve data persistently.
 */
public class FileManager {

    private static final String USERS_FILE = "users.txt";
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String TESTS_FILE = "tests.txt";
    private static final String PENDING_TESTS_FILE = "pendingTests.txt";
    private static final String PATIENT_HISTORY_FILE = "patientHistory.txt";

    /**
    * The constructor for the FileManager class.
    * This constructor is responsible for ensuring that the necessary data files are created if they do not already exist.
    * These files are crucial for storing system data, including users, patients, tests, pending test requests, and patient histories.
    * 
    * The constructor performs the following operations:
    * - Creates the `users.txt` file if it does not exist.
    * - Creates the `patients.txt` file if it does not exist.
    * - Initializes the `tests.txt` file with predefined test data (if required).
    * - Creates the `pendingTests.txt` file if it does not exist.
    * - Creates the `patientHistory.txt` file if it does not exist.
    */
    public FileManager() {
        // Ensure that the files are created if they don't exist
        createFileIfNotExists(USERS_FILE);
        createFileIfNotExists(PATIENTS_FILE);
        initializeTestsFile();
        createFileIfNotExists(PENDING_TESTS_FILE);
        createFileIfNotExists(PATIENT_HISTORY_FILE);
    }

    /**
    * Creates a new file if it doesn't already exist.
    *
    * @param fileName The name of the file to create.
    */
    private void createFileIfNotExists(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println(fileName + " not found. Created an empty file.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + fileName);
            e.printStackTrace();
        }
    }

    /**
    * Initializes the tests.txt file with default test data if the file doesn't exist.
    */
    private void initializeTestsFile() {
        File file = new File(TESTS_FILE);
        try {
            if (file.createNewFile()) {
                System.out.println("tests.txt not found. Created with default tests.");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("Blood Pressure,90,120\n");
                    writer.write("Cholesterol,150,200\n");
                    writer.write("Blood Sugar,70,110\n");
                    writer.write("Heart Rate,60,100\n");
                    writer.write("Body Temperature,36.5,37.5\n");
                    writer.write("Respiratory Rate,12,16\n");
                    writer.write("Hemoglobin,13,17\n");
                    writer.write("White Blood Cells,4.5,11\n");
                    writer.write("Platelets,150,400\n");
                    writer.write("Creatinine,0.6,1.3\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error initializing tests.txt");
            e.printStackTrace();
        }
    }
    
    /**
    * Adds a pending test request for a patient to the pendingTests.txt file.
    *
    * @param patientId The ID of the patient.
    * @param testName The name of the test.
    * @param date The date of the test.
    */
    public void addPendingTest(String patientId, String testName, String date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PENDING_TESTS_FILE, true))) {
            writer.write(patientId + "," + testName + "," + date);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Loads all pending test requests from the pendingTests.txt file.
    *
    * @return A list of pending test requests.
    */
    public List<String> loadPendingTests() {
        List<String> pendingTests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PENDING_TESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pendingTests.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingTests;
    }
    
    /**
    * Clears all pending test data from the pendingTests.txt file.
    */
    public void clearPendingTests() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PENDING_TESTS_FILE))) {
            writer.write(""); // Clear file contents
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    /**
    * Adds a new user to the users.txt file.
    *
    * @param user The user object containing the user information (ID, name, password, role).
    */
    public void addUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(user.getId() + "," + user.getName() + "," + user.getPassword() + "," + user.getRole());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Loads all users from the users.txt file.
    *
    * @return A list of users loaded from the file.
    */
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2], data[3]));
            }
        } catch (FileNotFoundException e) {
            // If the file does not exist, return an empty list
            System.out.println("Users file not found. Starting with an empty list.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
    * Adds a new patient to the patients.txt file.
    *
    * @param patient The patient object containing the patient information (ID, name, age, weight, height, gender, contact info).
    */
    public void addPatient(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE, true))) {
            writer.write(
                    patient.getId() + "," + patient.getName() + "," + patient.getAge() + "," + patient.getGender() + "," + patient.getWeight() + "," + patient.getHeight() + "," + patient.getContactInfo());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Loads all patients from the patients.txt file.
    *
    * @return A list of patients loaded from the file.
    */
    public List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Trim the line to remove leading/trailing whitespaces
                line = line.trim();
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // Split the line by comma
                String[] data = line.split(",");
                if (data.length != 7) {
                    // Log and skip malformed lines
                    System.out.println("Malformed line skipped: " + line);
                    continue;
                }

                try {
                    // Parse and add the patient to the list
                    patients.add(new Patient(
                        data[0], 
                        data[1], 
                        Integer.parseInt(data[2]), 
                        data[3], 
                        Integer.parseInt(data[4]), 
                        Integer.parseInt(data[5]), 
                        data[6]
                    ));
                } catch (NumberFormatException e) {
                    // Log and skip lines with invalid number formats
                    System.out.println("Invalid number format in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Patients file not found. Starting with an empty list.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    /**
    * Loads all available tests from the tests.txt file.
    *
    * @return A list of available tests.
    */    
    public List<String> loadAvailableTests() {
        List<String> tests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tests.add(line); //     Each line in tests.txt represents a test
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tests;
    }

    /**
    * Loads the pending tests for a specific patient from the pendingTests.txt file.
    *
    * @param patientId The ID of the patient.
    * @return A list of pending tests for the patient.
    */
    public List<String> loadPendingTestsForPatient(String patientId) {
        List<String> pendingTests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PENDING_TESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(patientId)) {
                    pendingTests.add(data[1]); // Assuming the second element is the test name
                    pendingTests.add(data[4]); // Assuming the second element is the test date
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingTests;
    }

    /**
    * Adds a test result to the patient's history in the patientHistory.txt file.
    *
    * @param patientId The ID of the patient.
    * @param testResult The test result object containing test details (name, result, min/max, status, date).
    */
    public void addTestResultToPatientHistory(String patientId, TestResult testResult) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patientHistory.txt", true))) {
            writer.write(patientId + "," + testResult.getTestName() + "," + testResult.getResult() + ","
                    + testResult.getMin() + "," + testResult.getMax() + "," + testResult.getStatus() + ","
                    + testResult.getDate());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Removes a test from the pending tests file.
    *
    * @param testInfo The information of the test to be removed (patient ID, test name, etc.).
    */
    public void removeTestFromPending(String testInfo) {
        List<String> pendingTests = loadPendingTests(); // Load current pending tests
        pendingTests.remove(testInfo); // Remove the specified test
        
        // Write back the updated list to the pending tests file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pendingTests.txt"))) {
            for (String test : pendingTests) {
                writer.write(test);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Loads all tests from the tests.txt file.
    *
    * @return A list of Test objects loaded from the file.
    */
    public List<Test> loadTests() {
        List<Test> tests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Assuming the format is: name,min,max
                String testName = data[0];
                double min = Double.parseDouble(data[1]);
                double max = Double.parseDouble(data[2]);
                tests.add(new Test(testName, min, max));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tests;
    }

    /**
    * Retrieves a test by its name from the tests.txt file.
    *
    * @param testName The name of the test to retrieve.
    * @return A Test object containing the test details, or null if not found.
    */
    public Test getTestByName(String testName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(TESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double min = Double.parseDouble(data[1]);
                double max = Double.parseDouble(data[2]);

                if (name.equalsIgnoreCase(testName)) {
                    return new Test(name, min, max);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if the test was not found
    }

    /**
    * Loads the patient's test history from the patientHistory.txt file.
    *
    * @param patientId The ID of the patient.
    * @return A list of test results for the patient.
    */
    public List<TestResult> loadPatientHistory(String patientId) {
        List<TestResult> testResults = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("patientHistory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(patientId)) { // Check if patient ID matches
                    // Create a Test object with the necessary details (name, min, max)
                    Test test = new Test(data[1], Double.parseDouble(data[3]), Double.parseDouble(data[4]));

                    // Create a TestResult object with the Test object, result, status, and date
                    TestResult testResult = new TestResult(test, Double.parseDouble(data[2]), data[5], data[6]);

                    // Add the TestResult to the list
                    testResults.add(testResult);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testResults;
    }

    /**
    * Loads the test results for a patient within a specific date range.
    *
    * @param patientId The ID of the patient.
    * @param startDate The start date for filtering results.
    * @param endDate The end date for filtering results.
    * @return A list of test results within the specified date range.
    */
    public List<TestResult> loadTestResultsByDate(String patientId, String startDate, String endDate) {
        List<TestResult> filteredResults = new ArrayList<>();
        List<TestResult> allResults = loadPatientHistory(patientId); // Assuming this loads all results

        for (TestResult result : allResults) {
            if (isDateInRange(result.getDate(), startDate, endDate)) {
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }

    /**
    * Checks if a given date is within a specified date range.
    *
    * @param date The date to check.
    * @param startDate The start of the date range.
    * @param endDate The end of the date range.
    * @return true if the date is within the range, false otherwise.
    */
    private boolean isDateInRange(String date, String startDate, String endDate) {
        return (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0);
    }

    /**
    * Adds a new test to the tests file.
    *
    * This method appends a new test to the file containing available tests.
    * The test data is written in CSV format (test name, minimum value, maximum value).
    *
    * @param test The `Test` object containing the details of the test to be added.
    */
    public void addNewTest(Test test){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TESTS_FILE, true))) {
            writer.write(
                    test.getName() + "," + test.getMin()+ "," + test.getMax());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Updates a patient's data in the patients file.
     *
     * This method reads the patient file, updates the data for the specified patient ID, 
     * and writes the updated data back to the file.
     *
     * @param id          The ID of the patient to be updated.
     * @param age         The new age of the patient.
     * @param height      The new height of the patient.
     * @param weight      The new weight of the patient.
     * @param contactInfo The new contact information of the patient.
     * @throws IOException If an I/O error occurs during file operations.
     */
    public void updatePatientDate(String id,int age,int height,int weight,String contactInfo) throws IOException{
        List<String> lines = new ArrayList<>();
        boolean isUpdated = false;
        try(BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))){
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                String[] data = currentLine.split(",");
                String currentId = data[0];
                if(currentId.equals(id)){
                    lines.add(currentId + "," + data[1] + "," + age + "," + data[3] + "," + weight + "," + height + "," + contactInfo);
                    isUpdated = true;
                }else{
                    lines.add(currentLine);
                }
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))){
            for(String line : lines){
                writer.write(line);
                writer.newLine();
            }
        }
        if(!isUpdated){
            System.out.println("Patient ID not found.");
        }
    }
}