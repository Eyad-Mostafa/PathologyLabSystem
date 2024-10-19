package com.mycompany.pathologylabsystem;

import java.util.*;

public class PathologyLabSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private FileManager fileManager = new FileManager();
    private List<User> users; // List of users
    private List<Patient> patients; // List of patients

    public static void main(String[] args) {
        PathologyLabSystem system = new PathologyLabSystem();
        system.loadData(); // Load existing users and patients from files
        system.start();
    }

    private void loadData() {
        users = fileManager.loadUsers(); // Load users from the file
        patients = fileManager.loadPatients(); // Load patients from the file
    }

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

    private void doctorMenu(String name) {
        System.out.println("Welcome, Dr." + name);
        while (true) {
            System.out.println("\n-------------------------");
            viewPendingTests();
            System.out.println("1. Search for Patient");
            System.out.println("2. Add Test Result");
            System.out.println("3. Log Out");
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
                    return; // Log out
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void receptionistMenu(String name) {
        System.out.println("Welcome, MR." + name);
        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Search for Patient");
            System.out.println("3. Log Out");
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
                    return; // Log out by breaking out of the menu loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


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

    private List<TestResult> retrieveTestResultsByDate(List<TestResult> testHistory, String startDate, String endDate) {
        List<TestResult> filteredResults = new ArrayList<>();

        for (TestResult result : testHistory) {
            if (result.getDate().compareTo(startDate) >= 0 && result.getDate().compareTo(endDate) <= 0) {
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }

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
