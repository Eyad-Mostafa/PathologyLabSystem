package com.mycompany.pathologylabsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Main class for the Pathology Lab System, handling user interaction and managing
 * users, patients, and test requests.
 */
public class PathologyLabSystem {

    private static final String PATIENTS_FILE = "patients.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private FileManager fileManager = new FileManager();
    private List<User> users; // List of users
    private List<Patient> patients; // List of patients

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
    // Create the main frame
        JFrame frame = new JFrame("Pathology Lab System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("Pathology Lab System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Buttons
        JButton addUserButton = new JButton("Add User");
        JButton logInButton = new JButton("Log In");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        buttonPanel.add(addUserButton);
        buttonPanel.add(logInButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Button actions
        addUserButton.addActionListener(e -> addUser());
        logInButton.addActionListener(e -> logIn());
        exitButton.addActionListener(e -> System.exit(0)); // Exit application

        // Show the frame
        frame.setVisible(true);
    }

    /**
     * Adds a new user to the system after validating user input.
     */
    private void addUser() {
        // Create a JFrame for user input
        JFrame frame = new JFrame("Add User");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        // Input fields and labels
        JLabel idLabel = new JLabel("Enter ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Enter Name:");
        JTextField nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Enter Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel roleLabel = new JLabel("Choose Role:");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Doctor", "Receptionist"});
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        // Add components to the frame
        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(roleLabel);
        frame.add(roleComboBox);
        frame.add(submitButton);
        frame.add(cancelButton);

        frame.setVisible(true);

        // Handle the Submit button action
        submitButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) roleComboBox.getSelectedItem();

            // Validation
            if (id.isEmpty() || name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Long.parseLong(id); // Validate ID as a number
                for (User user : users) {
                    if (user.getId().equals(id)) {
                        JOptionPane.showMessageDialog(frame, "User ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create the new user
            User user = new User(id, name, password, role);
            fileManager.addUser(user);
            users.add(user);

            JOptionPane.showMessageDialog(frame, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose(); // Close the frame

            // Redirect to the respective menu based on role
            if (role.equals("Doctor")) {
                doctorMenu(name);
            } else {
                receptionistMenu(name);
            }
        });

        // Handle the Cancel button action
        cancelButton.addActionListener(e -> frame.dispose());
    }

    /**
     * Handles user login by checking the credentials and directing the user to
     * the appropriate menu based on their role.
     */
    private void logIn() {
        // Create a JFrame for login
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        // Create components for input
        JLabel idLabel = new JLabel("Enter ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Enter Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        // Add components to the frame
        frame.add(idLabel);
        frame.add(idField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(cancelButton);

        frame.setVisible(true);

        // Handle Login button action
        loginButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());

            // Search for user with matching credentials
            for (User user : users) {
                if (user.getId().equals(id) && user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose(); // Close the frame

                    // Redirect to the appropriate menu based on the role
                    if (user.getRole().equals("Doctor")) {
                        doctorMenu(user.getName());
                    } else {
                        receptionistMenu(user.getName());
                    }
                    return;
                }
            }

            // Show error message if credentials are invalid
            JOptionPane.showMessageDialog(frame, "Invalid ID or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        // Handle Cancel button action
        cancelButton.addActionListener(e -> frame.dispose());
    }

    /**
     * Displays the menu for doctors after they log in.
     *
     * @param name The name of the logged-in doctor.
     */ 
    public void doctorMenu(String doctorName) {
        // Create the main frame
        JFrame frame = new JFrame("Doctor Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome, Dr. " + doctorName, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Panel for pending tests
        JPanel pendingTestsPanel = new JPanel();
        pendingTestsPanel.setLayout(new BorderLayout());
        JLabel pendingTestsLabel = new JLabel("Pending Tests:", SwingConstants.LEFT);
        pendingTestsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pendingTestsPanel.add(pendingTestsLabel, BorderLayout.NORTH);

        // Load pending tests
        List<String> pendingTests = fileManager.loadPendingTests();
        DefaultListModel<String> pendingTestsModel = new DefaultListModel<>();
        if (pendingTests.isEmpty()) {
            pendingTestsModel.addElement("No pending tests.");
        } else {
            for (String test : pendingTests) {
                pendingTestsModel.addElement(test);
            }
        }
        JList<String> pendingTestsList = new JList<>(pendingTestsModel);
        pendingTestsPanel.add(new JScrollPane(pendingTestsList), BorderLayout.CENTER);
        frame.add(pendingTestsPanel, BorderLayout.WEST);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        // Buttons
        JButton searchPatientButton = new JButton("Search for Patient");
        JButton addTestResultButton = new JButton("Add Test Result");
        JButton addNewTestButton = new JButton("Add New Test");
        JButton clearPendingTestsButton = new JButton("Clear Pending Tests");
        JButton logoutButton = new JButton("Log Out");

        // Add buttons to the panel
        buttonPanel.add(searchPatientButton);
        buttonPanel.add(addTestResultButton);
        buttonPanel.add(addNewTestButton);
        buttonPanel.add(clearPendingTestsButton);
        buttonPanel.add(logoutButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Button actions
        searchPatientButton.addActionListener(e -> searchForPatient());
        addTestResultButton.addActionListener(e -> addTestResult());
        addNewTestButton.addActionListener(e -> addNewTest());
        clearPendingTestsButton.addActionListener(e -> {
            fileManager.clearPendingTests();
            pendingTestsModel.clear();
            pendingTestsModel.addElement("No pending tests.");
        });
        logoutButton.addActionListener(e -> frame.dispose()); // Close the window on logout

        // Show the frame
        frame.setVisible(true);
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
    public void receptionistMenu(String name) {
        // Frame setup
        JFrame frame = new JFrame("Receptionist Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome, MR. " + name, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton addPatientButton = new JButton("Add Patient");
        JButton searchPatientButton = new JButton("Search for Patient");
        JButton updatePatientButton = new JButton("Update Patient Data");
        JButton logoutButton = new JButton("Log Out");

        buttonPanel.add(addPatientButton);
        buttonPanel.add(searchPatientButton);
        buttonPanel.add(updatePatientButton);
        buttonPanel.add(logoutButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Button Actions
        addPatientButton.addActionListener(e -> addPatient());
        searchPatientButton.addActionListener(e -> searchForPatient());
        updatePatientButton.addActionListener(e -> updatePatientData());
        logoutButton.addActionListener(e -> frame.dispose()); // Close the frame

        frame.setVisible(true);
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
        try {
            Long.parseLong(id); // Attempt to parse the string as a number
            // Check if a patient with the same ID already exists
            boolean patientExists = false;
            for (Patient patient : patients) {
                if (patient.getId().equals(id)) {
                    patientExists = true;
                    break; // Stop checking further once a match is found
                }
            }

            if (patientExists) {
                System.out.println("Patient with this ID already exists. Please use a different ID.");
                return; // Exit the method without adding the user
            }
        } catch (NumberFormatException e) {
                System.out.println("ID must be number.");
                return;
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
                if (weight > 20 && weight <= 400) {
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
        try {
            Long.parseLong(contactInfo); // Attempt to parse the string as a number
        } catch (NumberFormatException e) {
                System.out.println("Phone number must be number.");
                return;
        }
        while(contactInfo.length() != 11){
            System.out.println("Phone number must be 11 Character.");
            contactInfo = scanner.nextLine();
        }
    
        Patient patient = new Patient(id, name, age, gender, weight, height, contactInfo);
        fileManager.addPatient(patient);
        patients.add(patient); // Add to in-memory list
        System.out.println("Patient added successfully!");
        displayPatientProfile(patient);
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
    public void searchForPatient() {
        JFrame frame = new JFrame("Search for Patient");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel idLabel = new JLabel("Enter Patient ID:");
        JTextField idField = new JTextField();
        JButton searchButton = new JButton("Search");

        frame.add(idLabel);
        frame.add(idField);
        frame.add(searchButton);

        searchButton.addActionListener(e -> {
            String patientId = idField.getText();
            for (Patient patient : patients) {
                if (patient.getId().equals(patientId)) {
                    displayPatientProfile(patient);
                    frame.dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Patient not found!");
        });

        frame.setVisible(true);
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
    private void updatePatientData() {
        // Create the main frame
        JFrame frame = new JFrame("Update Patient Data");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Components for ID validation
        JLabel idLabel = new JLabel("Enter Patient ID to update:");
        JTextField idField = new JTextField();
        JButton validateButton = new JButton("Validate ID");
        JLabel validationMessage = new JLabel("");
        validationMessage.setForeground(Color.RED);

        // Components for updating fields
        JLabel ageLabel = new JLabel("Enter New Age:");
        JTextField ageField = new JTextField();

        JLabel weightLabel = new JLabel("Enter New Weight:");
        JTextField weightField = new JTextField();

        JLabel heightLabel = new JLabel("Enter New Height:");
        JTextField heightField = new JTextField();

        JLabel contactLabel = new JLabel("Enter New Phone Number:");
        JTextField contactField = new JTextField();

        JButton updateButton = new JButton("Update");
        JLabel updateMessage = new JLabel("");
        updateMessage.setForeground(Color.RED);

        // Add components to the frame
        frame.add(idLabel);
        frame.add(idField);
        frame.add(new JLabel()); // Empty space
        frame.add(validateButton);
        frame.add(validationMessage);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(contactLabel);
        frame.add(contactField);
        frame.add(new JLabel()); // Empty space
        frame.add(updateButton);
        frame.add(updateMessage);

        // Initially disable update fields
        ageField.setEnabled(false);
        weightField.setEnabled(false);
        heightField.setEnabled(false);
        contactField.setEnabled(false);
        updateButton.setEnabled(false);

        // Action listener for ID validation
        validateButton.addActionListener(e -> {
            String id = idField.getText();
            boolean validID = false;

            // Check if ID exists in the list
            for (Patient patient : patients) {
                if (id.equals(patient.getId())) {
                    validID = true;
                    break;
                }
            }

            if (!validID) {
                validationMessage.setText("Invalid ID! Try again.");
            } else {
                validationMessage.setText("ID validated. Proceed with updates.");
                // Enable fields for updating data
                ageField.setEnabled(true);
                weightField.setEnabled(true);
                heightField.setEnabled(true);
                contactField.setEnabled(true);
                updateButton.setEnabled(true);
            }
        });

        // Action listener for updating data
        updateButton.addActionListener(e -> {
            try {
                // Validate input fields
                int age = validateIntField(ageField.getText(), 1, 120, "Age");
                int weight = validateIntField(weightField.getText(), 21, 500, "Weight");
                int height = validateIntField(heightField.getText(), 31, 220, "Height");
                String contactInfo = validatePhoneField(contactField.getText());

                // Perform the update
                fileManager.updatePatientDate(idField.getText(), age, height, weight, contactInfo);
                loadData(); // Refresh the patient list
                JOptionPane.showMessageDialog(frame, "Patient data updated successfully!");
                frame.dispose(); // Close the frame
            } catch (IllegalArgumentException ex) {
                updateMessage.setText(ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, 
                    "An error occurred while updating patient data: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private int validateIntField(String input, int min, int max, String fieldName) {
        try {
            int value = Integer.parseInt(input);
            if (value < min || value > max) {
                throw new IllegalArgumentException(fieldName + " must be between " + min + " and " + max + ".");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.");
        }
    }

    private String validatePhoneField(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        if (input.length() != 11) {
            throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
        }
        try {
            Long.parseLong(input); // Check if it's numeric
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Phone number must contain only digits.");
        }
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
    public void displayPatientProfile(Patient patient) {
        JFrame frame = new JFrame("Patient Profile");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Patient Info
        JTextArea profileArea = new JTextArea();
        profileArea.setEditable(false);
        profileArea.setText("Patient ID: " + patient.getId() + "\n" +
                "Name: " + patient.getName() + "\n" +
                "Age: " + patient.getAge() + "\n" +
                "Weight: " + patient.getWeight() + "\n" +
                "Height: " + patient.getHeight() + "\n" +
                "Gender: " + patient.getGender() + "\n" +
                "Phone: " + patient.getContactInfo() + "\n");

        // Load Pending Tests
        List<String> pendingTests = fileManager.loadPendingTestsForPatient(patient.getId());
        profileArea.append("\nPending Tests:\n");
        for (int i = 0; i < pendingTests.size(); i += 2) {
            profileArea.append((i / 2 + 1) + ". " + pendingTests.get(i) + " (Date: " + pendingTests.get(i + 1) + ")\n");
        }

        frame.add(new JScrollPane(profileArea), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Adjusted for 3 buttons
        JButton viewHistoryButton = new JButton("View Test History");
        JButton addTestButton = new JButton("Add Test to Pending");
        JButton backButton = new JButton("Back");

        buttonPanel.add(viewHistoryButton);
        buttonPanel.add(addTestButton);
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        viewHistoryButton.addActionListener(e -> viewTestHistory(patient));
        addTestButton.addActionListener(e -> addTestToPending(patient));
        backButton.addActionListener(e -> frame.dispose()); // Closes the current frame

        frame.setVisible(true);
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

        if (availableTests.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No available tests at the moment.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create frame for adding test
        JFrame frame = new JFrame("Add Test to Pending");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("Select a Test for Patient: " + patient.getName(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Available tests list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String test : availableTests) {
            listModel.addElement(test);
        }
        JList<String> testList = new JList<>(listModel);
        testList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(testList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Test");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> {
            int selectedIndex = testList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedTest = availableTests.get(selectedIndex);
                String currentDate = java.time.LocalDate.now().toString();

                // Save test to pending tests
                fileManager.addPendingTest(patient.getId(), selectedTest, currentDate);
                JOptionPane.showMessageDialog(frame, "Test added to pending for Patient ID: " + patient.getId(), "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a test to add.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Cancel button action
        cancelButton.addActionListener(e -> frame.dispose());

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Prompts the user to enter details for a new test and then adds the test to the system.
     * The method collects the test name, minimum value, and maximum value from the user,
     * creates a new `Test` object, and passes it to the `fileManager` to be added to the file.
     */
    private void addNewTest(){
        System.out.println("Enter TestName :");
        String name=scanner.nextLine();
        System.out.println("Enter min :");
        double min=scanner.nextDouble();
        System.out.println("Enter max :");
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
            displayPatientProfile(patient);
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
                displayPatientProfile(patient); // Back to patient profile
                break;
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
//            if (result.getDate().compareTo(startDate) >= 0 && result.getDate().compareTo(endDate) <= 0) {
//                filteredResults.add(result);
//            }
            if (fileManager.isDateInRange(result.getDate(), startDate, endDate)) {
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
     * Generates health report based on the patient's test history.
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
