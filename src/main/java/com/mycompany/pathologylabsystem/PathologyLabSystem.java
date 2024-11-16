package com.mycompany.pathologylabsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Main class for the Pathology Lab System, handling user interaction and managing
 * users, patients, and test requests.
 */
public class PathologyLabSystem {

    private static final String PATIENTS_FILE = "patients.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private FileManager fileManager = new FileManager();
    private List<User> users; // List of users
    private List<Patient> patients; // List of patientsS

    /**
     * Main method to start the Pathology Lab System.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        PathologyLabSystem system = new PathologyLabSystem();
        system.loadData(); // Load existing users and patients from files
        system.start();
    }

    /**
     * Loads the users and patients data from the file system.
     */
    private void loadData() {
        users = fileManager.loadUsers(); // Load users from the file
        patients = fileManager.loadPatients(); // Load patients from the file
    }

    /**
     * Starts the system and presents the main menu to the user.
     */
    private void start() {
        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    /**
     * Adds a new user to the system after validating user input.
     */
    private void addUser() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        // Check if a user with the same ID already exists
        boolean userExists = false;
        for (User user : users) {
            if (user.getId().equals(id)) {
                userExists = true;
                break; // Stop checking further once a match is found
            }
        }

        if (userExists) {
            System.out.println("User with this ID already exists. Please use a different ID.");
            return; // Exit the method without adding the user
        }

        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Choose Role (1. Doctor, 2. Receptionist):");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String role = (roleChoice == 1) ? "Doctor" : "Receptionist";

        // Create the new user and add it to the list
        User user = new User(id, name, password, role);
        fileManager.addUser(user);
        users.add(user); // Add the new user to the current list in memory

        System.out.println("User added successfully!");

        if (role.equals("Doctor")) {
            doctorMenu(name);
        } else {
            receptionistMenu(name);
        }
    }

    /**
     * Handles user login by checking the credentials and directing the user to
     * the appropriate menu based on their role.
     */
    private void logIn() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                if (user.getRole().equals("Doctor")) {
                    doctorMenu(user.getName());
                } else {
                    receptionistMenu(user.getName());
                }
                return;
            }
        }
        System.out.println("Invalid ID or Password!");
    }

    /**
     * Displays the menu for doctors after they log in.
     *
     * @param name The name of the logged-in doctor.
     */ 
    private void doctorMenu(String name) {
        System.out.println("Welcome, Dr." + name);
        while (true) {
            System.out.println("\n-------------------------");
            viewPendingTests();
            System.out.println("\n-------------------------");
            System.out.println("1. Search for Patient");
            System.out.println("2. Add Test Result");
            System.out.println("3. Add New Test");
            System.out.println("4. Log out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    searchForPatient();
                    break;
                case 2:
                    addTestResult();
                    break;
                case 3:
                    addNewTest();
                    break;
                case 4:
                   return; // Log out
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays a menu for the receptionist with options to add a patient, 
     * search for a patient, or log out. The menu loops until the user 
     * chooses to log out.
     *
     * @param name The name of the receptionist, used for a personalized greeting.
     *
     * Behavior:
     * 1. Prints a welcome message for the receptionist.
     * 2. Displays the menu options:
     *    - 1. Add Patient: Calls the addPatient() method.
     *    - 2. Search for Patient: Calls the searchForPatient() method.
     *    - 3. Log Out: Exits the menu.
     * 3. Validates user input and handles invalid entries.
     * 4. Loops until the "Log Out" option is selected.
     *
     * This method does not return any value.
     */
    private void receptionistMenu(String name) {
        System.out.println("Welcome, MR." + name);
        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Search for Patient");
            System.out.println("3. Update data for Patient");
            System.out.println("4. Log Out");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    searchForPatient();
                    break;
                case 3:
                    updatePationtData();
                    break;
                case 4:
                    return; // Log out by breaking out of the menu loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    /**
     * Collects and validates patient information from the user, creates a Patient object, 
     * and stores it in both the in-memory list and an external file.
     *
     * This method ensures that all inputs meet specified criteria:
     * - Patient ID: Cannot be empty.
     * - Name: Cannot be empty.
     * - Age: Must be a valid integer between 1 and 120.
     * - Gender: Must be either "Male" or "Female".
     * - Weight: Must be a valid integer between 20 and 500.
     * - Height: Must be a valid integer between 30 and 220.
     * - Contact Info: Cannot be empty.
     *
     * Once all inputs are valid, the patient is saved to persistent storage and added 
     * to the current in-memory patient list.
     *
     * Dependencies:
     * - `scanner`: Used to read user input.
     * - `Patient`: A class representing the patient model.
     * - `fileManager`: Handles file operations for saving patient data.
     * - `patients`: An in-memory list of patients.
     *
     * This method does not return any value.
     */
    private void addPatient() {
        System.out.println("Enter Patient ID:");
        String id = scanner.nextLine();
        while (id.isEmpty()) {
            System.out.println("Patient ID cannot be empty. Please enter a valid ID:");
            id = scanner.nextLine();
        }
    
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Please enter a valid name:");
            name = scanner.nextLine();
        }
    
        System.out.println("Enter Age:");
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age > 0 && age <= 120) {
                    validAge = true;
                } else {
                    System.out.println("Please enter a valid age between 1 and 120:");
                }
            } else {
                System.out.println("Please enter a valid number for age:");
                scanner.next(); 
            }
        }
        scanner.nextLine();
        
        System.out.println("Enter Gender (Male - Female):");
        String gender = scanner.nextLine();
        while (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {
            System.out.println("Invalid gender. Please enter Male, Female");
            gender = scanner.nextLine();
        }
        
        System.out.println("Enter weight:");
        int weight = 0;
        boolean validweight = false;
        while (!validweight) {
            if (scanner.hasNextInt()) {
                weight = scanner.nextInt();
                if (weight > 20 && weight <= 500) {
                    validweight = true;
                } else {
                    System.out.println("Please enter a valid weight:");
                }
            } else {
                System.out.println("Please enter a valid number for weight:");
                scanner.next(); 
            }
        }
        scanner.nextLine();
        
        System.out.println("Enter height:");
        int height = 0;
        boolean validheight = false;
        while (!validheight) {
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if (height > 30 && height <= 220) {
                    validheight = true;
                } else {
                    System.out.println("Please enter a valid height:");
                }
            } else {
                System.out.println("Please enter a valid number for height:");
                scanner.next(); 
            }
        }
        scanner.nextLine();
        
        System.out.println("Enter Phone Number:");
        String contactInfo = scanner.nextLine();
        while (contactInfo.isEmpty()) {
            System.out.println("Contact information cannot be empty. Please enter valid contact info:");
            contactInfo = scanner.nextLine();
        }
    
        Patient patient = new Patient(id, name, age, gender, weight, height, contactInfo);
        fileManager.addPatient(patient);
        patients.add(patient); // Add to in-memory list
        System.out.println("Patient added successfully!");
    }

    /**
     * Searches for a patient in the in-memory patient list by their ID.
     * If a matching patient is found, their profile is displayed.
     * Otherwise, it notifies the user that the patient was not found.
     *
     * Process:
     * 1. Prompts the user to enter a Patient ID.
     * 2. Iterates through the in-memory list of patients.
     * 3. If a patient with the matching ID is found:
     *    - Calls `displayPatientProfile(patient)` to show the patient's details.
     *    - Exits the method.
     * 4. If no matching patient is found, displays "Patient not found!".
     *
     * Dependencies:
     * - `scanner`: Used to read the Patient ID input.
     * - `patients`: An in-memory list of `Patient` objects.
     * - `displayPatientProfile(Patient patient)`: A method to display the patient's details.
     *
     * This method does not return any value.
     */
    private void searchForPatient() {
        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                displayPatientProfile(patient);
                return;
            }
        }
        System.out.println("Patient not found!");
    }
    
    /**
     * Updates the details of an existing patient in the system based on the patient ID.
     * The method prompts the user to enter the patient's ID and then asks for new values
     * for the patient's age, weight, height, and contact information. It validates each input
     * to ensure it meets the required criteria. After collecting valid input, the patient's
     * data is updated in the storage file.
     * 
     * @throws IOException if there is an error while updating the patient data in the file.
     */
    private void updatePationtData(){
         boolean flag = false;
         System.out.println("Enter Patient ID you want to update:");
         String id = scanner.nextLine();
         while(!flag){
            for (int i = 0; i < patients.size(); i++) {
                if(id.equals(patients.get(i).getId())){
                    
                    flag=true;
                    break;
                }
                else{
                    System.out.print("invalid ID");
                    System.out.println("press 1 for entring a ID, 0 for end program");
                    int x=scanner.nextInt();
                        if (x==1) {
                            System.out.println("Enter Patient ID you want to update:");
                            id = scanner.nextLine();
                        }
                    else{
                     return ;
                    }
                }
             }
         }
        System.out.println("Enter New Age:");
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age > 0 && age <= 120) {
                    validAge = true;
                } else {
                    System.out.println("Please enter a valid age between 1 and 120:");
                }
            } else {
                System.out.println("Please enter a valid number for age:");
                scanner.next(); 
            }
        }
        System.out.println("Enter New weight:");
        int weight = 0;
        boolean validweight = false;
        while (!validweight) {
            if (scanner.hasNextInt()) {
                weight = scanner.nextInt();
                if (weight > 20 && weight <= 500) {
                    validweight = true;
                } else {
                    System.out.println("Please enter a valid weight:");
                }
            } else {
                System.out.println("Please enter a valid number for weight:");
                scanner.next(); 
            }
        }
        System.out.println("Enter height:");
        int height = 0;
        boolean validheight = false;
        while (!validheight) {
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if (height > 30 && height <= 220) {
                    validheight = true;
                } else {
                    System.out.println("Please enter a valid height:");
                }
            } else {
                System.out.println("Please enter a valid number for height:");
                scanner.next(); 
            }
        }
        scanner.nextLine();

        System.out.println("Enter Phone Number:");
        String contactInfo = scanner.nextLine();
        while (contactInfo.isEmpty()) {
            System.out.println("Contact information cannot be empty. Please enter valid contact info:");
            contactInfo = scanner.nextLine();
        }
        
        try{
            fileManager.updatePatientDate(id,age,height,weight,contactInfo);
        }catch(IOException e){
            System.out.println("An Error occurred while updating patient.");
            System.out.println(e);
        }
//      patients.add(patient); 
        //loadData(); // to update pateint list
    }

    /**
     * Displays the profile of a given patient, including their ID, name, age, weight, height, 
     * gender, and contact information. Provides the user with options to view the patient's 
     * test history or add a test to their pending list.
     *
     * Process:
     * 1. Prints the patient's profile details.
     * 2. Presents the user with the following menu options:
     *    - 1. View Test History: Calls `viewTestHistory(patient)`.
     *    - 2. Add Test to Pending: Calls `addTestToPending(patient)`.
     *    - 0. Back to Menu: Returns to the main menu without performing further actions.
     * 3. Reads the user's choice and executes the corresponding action.
     *
     * Dependencies:
     * - `scanner`: Used to read user input.
     * - `viewTestHistory(Patient patient)`: A method to display the patient's test history.
     * - `addTestToPending(Patient patient)`: A method to add a test to the patient's pending list.
     *
     * @param patient The `Patient` object whose profile is to be displayed.
     *
     * This method does not return any value.
    */ 
    private void displayPatientProfile(Patient patient) {
        System.out.println("Patient Profile Found:");
        System.out.println("- Patient ID: " + patient.getId());
        System.out.println("- Name: " + patient.getName());
        System.out.println("- Age: " + patient.getAge());
        System.out.println("- Weight: " + patient.getWeight());
        System.out.println("- Height: " + patient.getHeight());
        System.out.println("- Gender: " + patient.getGender());
        System.out.println("- Contact Information: " + patient.getContactInfo());
        System.out.println("Please choose an option:");
        System.out.println("1. View Test History");
        System.out.println("2. Add Test to Pending");
        System.out.println("0. Back to Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            viewTestHistory(patient);
        } else if (choice == 2) {
            addTestToPending(patient);
        }
    }

    /**
     * Adds a selected test to the pending tests for a given patient.
     *
     * Process:
     * 1. Loads the list of available tests from an external source via `fileManager`.
     * 2. Displays the available tests to the user.
     * 3. Prompts the user to choose a test by its number.
     * 4. Validates the user's input:
     *    - If the input is invalid, displays an error message and exits the method.
     * 5. If the input is valid:
     *    - Retrieves the selected test.
     *    - Gets the current date.
     *    - Saves the test as a pending test for the specified patient using `fileManager`.
     *    - Displays a confirmation message.
     *
     * Dependencies:
     * - `scanner`: Used to read user input.
     * - `fileManager`: Handles operations for loading tests and saving pending tests.
     * - `Patient`: The patient object to which the test is added.
     * - `java.time.LocalDate`: Used to get the current date.
     *
     * @param patient The `Patient` object for whom the test is being added.
     *
     * This method does not return any value.
     */
    private void addTestToPending(Patient patient) {
        // Load available tests
        List<String> availableTests = fileManager.loadAvailableTests();

        // Display available tests
        System.out.println("Available Tests:");
        for (int i = 0; i < availableTests.size(); i++) {
            System.out.println((i + 1) + ". " + availableTests.get(i));
        }

        // Ask user to choose a test
        System.out.println("Choose a test by number:");
        int testChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate choice
        if (testChoice < 1 || testChoice > availableTests.size()) {
            System.out.println("Invalid choice. Test not added.");
            return;
        }

        String selectedTest = availableTests.get(testChoice - 1); // Get selected test
        String currentDate = java.time.LocalDate.now().toString();

        // Save test to pending tests
        fileManager.addPendingTest(patient.getId(), selectedTest, currentDate);
        System.out.println("Test added to pending for Patient ID: " + patient.getId());
    }

    /**
     * Prompts the user to enter details for a new test and then adds the test to the system.
     * The method collects the test name, minimum value, and maximum value from the user,
     * creates a new `Test` object, and passes it to the `fileManager` to be added to the file.
     */
    private void addNewTest(){
        System.out.println("Enter TestName");
        String name=scanner.nextLine();
        System.out.println("Enter min");
        double min=scanner.nextDouble();
        System.out.println("Enter max");
        double max=scanner.nextDouble();
        Test test=new Test(name,min,max);
        fileManager.addNewTest(test);
        
    }

    /**
     * Displays a list of pending tests for all patients.
     *
     * Process:
     * 1. Loads the list of pending tests from an external source via `fileManager`.
     * 2. Checks if the list is empty:
     *    - If empty, displays "No pending tests."
     * 3. If the list contains tests:
     *    - Iterates through the list and displays each pending test with its index.
     *
     * Dependencies:
     * - `fileManager`: Handles operations for loading pending tests.
     *
     * This method does not return any value.
    */  
    private void viewPendingTests() {
        List<String> pendingTests = fileManager.loadPendingTests();
        if (pendingTests.isEmpty()) {
            System.out.println("No pending tests.");
        } else {
            System.out.println("Pending Tests:");
            for (int i = 0; i < pendingTests.size(); i++) {
                System.out.println((i + 1) + ". " + pendingTests.get(i));
            }
        }
    }

    /**
     * Adds a test result for a selected pending test.
     *
     * Process:
     * 1. Loads the pending tests from `fileManager`.
     * 2. If no pending tests are available, displays a message and exits.
     * 3. Displays the list of pending tests and prompts the user to select a test by number.
     * 4. Validates the user's input:
     *    - If invalid, displays an error message and exits.
     * 5. Parses the selected test info to extract the patient ID and test name.
     * 6. Prompts the user to enter the test result.
     * 7. Fetches the test details (e.g., min/max values) from `fileManager`.
     * 8. Determines the result status (`Low`, `Normal`, or `High`) based on the entered result and test range.
     * 9. Creates a new `TestResult` object and saves it to the patient's history.
     * 10. Removes the test from the pending list and confirms the addition.
     *
     * Dependencies:
     * - `scanner`: Used to read user input.
     * - `fileManager`: Handles operations for fetching tests, saving results, and updating pending tests.
     * - `Test` and `TestResult`: Classes representing the test details and results.
     * - `java.time.LocalDate`: Used to get the current date.
     *
     * This method does not return any value.
     */
    private void addTestResult() {
        System.out.println("Choose a pending test by number:");

        // Load pending tests for the patient
        List<String> pendingTests = fileManager.loadPendingTests();

        if (pendingTests.isEmpty()) {
            System.out.println("No pending tests available.");
            return;
        }

        // Display pending tests
        for (int i = 0; i < pendingTests.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTests.get(i));
        }

        // Ask the user to choose a test
        System.out.println("Choose a test by number:");
        int testChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate choice
        if (testChoice < 1 || testChoice > pendingTests.size()) {
            System.out.println("Invalid choice. Test result not added.");
            return;
        }

        String selectedTestInfo = pendingTests.get(testChoice - 1); // Get selected test
        String[] testParts = selectedTestInfo.split(","); // Assuming the format includes Patient ID and Test Name
        String patientId = testParts[0]; // Extract patient ID from selected test info
        String selectedTestName = testParts[1]; // Extract test name

        System.out.println("Enter test result for " + selectedTestName + ":");
        double testResult = scanner.nextDouble(); // Assuming the result is numeric
        scanner.nextLine(); // consume newline
        String currentDate = java.time.LocalDate.now().toString();

        // Fetch the test details (min/max) from the FileManager
        Test selectedTest = fileManager.getTestByName(selectedTestName); // Fetch the test details

        if (selectedTest == null) {
            System.out.println("Test not found.");
            return;
        }

        // Determine the status based on result and the min/max values
        String status;
        if (testResult < selectedTest.getMin()) {
            status = "Low";
        } else if (testResult > selectedTest.getMax()) {
            status = "High";
        } else {
            status = "Normal";
        }

        // Create a new test result object
        TestResult newTestResult = new TestResult(selectedTest, testResult, status,
                currentDate);

        // Add test result to patient history, including the patient ID
        fileManager.addTestResultToPatientHistory(patientId, newTestResult);

        // Remove the test from pending tests (assumes method exists in FileManager)
        fileManager.removeTestFromPending(selectedTestInfo);

        System.out.println("Test result added successfully for test: " + selectedTest.getName());
    }

    /**
     * Displays the test history of a given patient and provides options for further actions.
     *
     * Process:
     * 1. Loads the test history for the patient from `fileManager`.
     * 2. Displays the test history:
     *    - If no history is available, notifies the user and exits.
     *    - If history exists, lists each test result with details (test name, result, min/max values, status, date).
     * 3. Presents a menu with options:
     *    - Filter by date.
     *    - Generate a detailed test report.
     *    - Generate an overall health report.
     *    - Return to the patient profile.
     * 4. Executes the chosen action based on user input.
     *
     * Dependencies:
     * - `Patient` object to identify the patient.
     * - `fileManager` to load test history.
     * - `scanner` for user input.
     * - Methods: `filterByDate`, `generateTestReport`, `generateHealthReport`.
     *
     * This method does not return any value.
     *
     * @param patient The patient whose test history is to be displayed.
    */
    private void viewTestHistory(Patient patient) {
        // Load and display test history
        List<TestResult> testHistory = fileManager.loadPatientHistory(patient.getId());

        System.out.println("Test History for Patient ID: " + patient.getId());
        if (testHistory.isEmpty()) {
            System.out.println("No test history available.");
            return;
        }

        for (int i = 0; i < testHistory.size(); i++) {
            TestResult test = testHistory.get(i);
            System.out.println((i + 1) + ". " + test.getTestName() + " - Result: " + test.getResult()
                    + " - Min: " + test.getMin() + " - Max: " + test.getMax()
                    + " - Status: " + test.getStatus() + " - Date: " + test.getDate());
        }

        System.out.println("Please choose an option:");
        System.out.println("1. Filter by Date");
        System.out.println("2. Generate Test Report by Number");
        System.out.println("3. Generate Health Report");
        System.out.println("0. Back to Patient Profile");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                filterByDate(testHistory);
                break;
            case 2:
                generateTestReport(testHistory);
                break;
            case 3:
                generateHealthReport(testHistory);
                break;
            case 0:
                return; // Back to patient profile
            default:
                System.out.println("Invalid choice!");
        }
    }

    /**
     * Filters and displays test results within a specified date range.
     *
     * Process:
     * 1. Prompts the user to enter a start and end date.
     * 2. Calls `retrieveTestResultsByDate` to filter test results from the given `testHistory` within the specified date range.
     * 3. If no results match the date range, notifies the user.
     * 4. If results are found, displays the filtered test results, including test name, result, min/max values, and the test date.
     *
     * Dependencies:
     * - `testHistory`: A list of all test results for the patient.
     * - `scanner` for user input.
     * - Method `retrieveTestResultsByDate` to filter test results.
     *
     * This method does not return any value.
     *
     * @param testHistory A list of test results to filter.
     */
    private void filterByDate(List<TestResult> testHistory) {
        System.out.println("Enter Start Date (YYYY-MM-DD):");
        String startDate = scanner.nextLine();
        System.out.println("Enter End Date (YYYY-MM-DD):");
        String endDate = scanner.nextLine();

        // Call the method to retrieve test results by date
        List<TestResult> filteredResults = retrieveTestResultsByDate(testHistory, startDate, endDate);

        if (filteredResults.isEmpty()) {
            System.out.println("No test results found for the specified date range.");
        } else {
            System.out.println("Filtered Test Results:");
            for (TestResult result : filteredResults) {
                System.out.println(result.getTestName() + ": " + result.getResult() + " (Min: " + result.getMin() + ", Max: " + result.getMax()
                        + ") on " + result.getDate());
            }
        }
    }

    /**
     * Filters test results within a specified date range.
     *
     * Process:
     * 1. Iterates through each test result in `testHistory`.
     * 2. Checks if the test date is within the range specified by `startDate` and `endDate`.
     *    - Uses `String.compareTo` to compare dates as strings in the format "YYYY-MM-DD".
     *    - If `result.getDate()` is on or after `startDate` and on or before `endDate`, 
     *      the result is included in the filtered list.
     * 3. Returns a list of filtered test results within the date range.
     *
     * Assumptions:
     * - Dates are passed in the "YYYY-MM-DD" format and are valid.
     * - This function does not handle date parsing errors or invalid date formats.
     *
     * @param testHistory A list of all test results to filter.
     * @param startDate The start date of the filter range in "YYYY-MM-DD" format.
     * @param endDate The end date of the filter range in "YYYY-MM-DD" format.
     * @return A list of `TestResult` objects within the specified date range.
     */
    private List<TestResult> retrieveTestResultsByDate(List<TestResult> testHistory, String startDate, String endDate) {
        List<TestResult> filteredResults = new ArrayList<>();

        for (TestResult result : testHistory) {
            if (result.getDate().compareTo(startDate) >= 0 && result.getDate().compareTo(endDate) <= 0) {
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }

    /**
     * Generates and displays a detailed report for a specific test result chosen by the user.
     *
     * Process:
     * 1. Ask the user to enter the number of the test result they want to generate a report for.
     * 2. Validates the user's choice to ensure it falls within the range of available test results.
     *    - If the choice is invalid, an error message is displayed, and the method exits.
     * 3. Retrieves the selected `TestResult` from the provided `testHistory` list.
     * 4. Displays a detailed report of the selected test result, including:
     *    - Test name
     *    - Result
     *    - Minimum and maximum values
     *    - Status (e.g., Normal, Low, High)
     *    - Test date
     *
     * Assumptions:
     * - `testHistory` is non-null and contains at least one test result.
     * - The user inputs a valid integer for the test report number.
     *
     * @param testHistory A list of `TestResult` objects representing the patient's test history.
     */
    private void generateTestReport(List<TestResult> testHistory) {
        System.out.println("Enter the number of the test report you want to generate:");
        int reportNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (reportNumber < 1 || reportNumber > testHistory.size()) {
            System.out.println("Invalid choice. Test report not generated.");
            return;
        }

        TestResult selectedTest = testHistory.get(reportNumber - 1);
        System.out.println("Generating report for: " + selectedTest.getTestName());
        System.out.println("Result: " + selectedTest.getResult());
        System.out.println("Min: " + selectedTest.getMin());
        System.out.println("Max: " + selectedTest.getMax());
        System.out.println("Status: " + selectedTest.getStatus());
        System.out.println("Date: " + selectedTest.getDate());
    }

    /**
     * Generates a comprehensive health report based on the patient's test history.
     *
     * Process:
     * 1. Checks if the `testHistory` list is empty.
     *    - If empty, displays a message indicating no test history and exits.
     * 2. Iterates through each `TestResult` in the `testHistory` list.
     *    - Compares the test result against its normal range (min and max values).
     *    - Categorizes the result as LOW, HIGH, or NORMAL.
     *    - Appends the detailed test information and its status to the report.
     * 3. Provides a summary of the test statuses, including:
     *    - Count of NORMAL, LOW, and HIGH test results.
     * 4. Offers basic health suggestions based on the test status summary.
     *    - Recommends consulting a healthcare professional for LOW or HIGH results.
     *    - Encourages maintaining healthy practices if all results are NORMAL.
     *
     * Assumptions:
     * - `testHistory` is a valid list of `TestResult` objects.
     * - Each `TestResult` includes the test name, result, normal range (min and max), and status.
     *
     * @param testHistory A list of `TestResult` objects representing the patient's test history.
     */
    private void generateHealthReport(List<TestResult> testHistory) {
        if (testHistory.isEmpty()) {
            System.out.println("No test history available to generate a report.");
            return;
        }

        int normalCount = 0;
        int lowCount = 0;
        int highCount = 0;
        StringBuilder report = new StringBuilder();
        report.append("Health Report for Patient:\n");

        // Loop through each test result and compare it with the normal range
        for (TestResult result : testHistory) {
            report.append("Test Name: ").append(result.getTestName())
                    .append("\nResult: ").append(result.getResult())
                    .append(" (Normal Range: ").append(result.getMin()).append(" - ").append(result.getMax()).append(")\n");

            // Determine the status based on the result compared to the normal range
            if (result.getResult() < result.getMin()) {
                report.append("Status: LOW\n\n");
                lowCount++;
            } else if (result.getResult() > result.getMax()) {
                report.append("Status: HIGH\n\n");
                highCount++;
            } else {
                report.append("Status: NORMAL\n\n");
                normalCount++;
            }
        }

        // Summary of the report
        report.append("Summary of Results:\n")
                .append("Normal Tests: ").append(normalCount).append("\n")
                .append("Low Tests: ").append(lowCount).append("\n")
                .append("High Tests: ").append(highCount).append("\n");

        // Provide basic health suggestions based on the results
        report.append("\nHealth Suggestions:\n");
        if (lowCount > 0) {
            report.append("- Some tests show LOW results. Please consult a healthcare professional for further analysis.\n");
        }
        if (highCount > 0) {
            report.append("- Some tests show HIGH results. Follow up with your doctor for necessary action.\n");
        }
        if (normalCount == testHistory.size()) {
            report.append("- All test results are within the normal range. Keep up the good health practices!\n");
        }

        System.out.println(report.toString());
    }

}
