# Pathology Lab System

## Overview

The **Pathology Lab System** is a Java-based application designed to manage patient data, test results, and user profiles within a pathology lab environment. The system offers a graphical user interface (GUI) for an intuitive and user-friendly experience, providing role-based access for doctors and receptionists to streamline operations.

## Features

- **User Management**: 
  - Add and load users (doctors and receptionists) with role-based access.
  - User login system through a GUI.

- **Patient Management**:
  - Add and update patient profiles, including contact information and medical history.
  - Search for patient profiles by ID.
  - All operations are accessible through an intuitive patient management interface.

- **Test Management**:
  - View and manage a list of available tests.
  - Request tests for patients with a few clicks.
  - Manage pending test requests in a dedicated view.
  - Record and view patient test results.

- **Data Persistence**:
  - All data (users, patients, tests, test results) is stored in text files.
  - Robust file handling ensures data integrity.
  - Data operations are seamlessly integrated into the GUI.

- **Graphical User Interface**:
  - Easy-to-navigate main menu.
  - Role-specific interfaces for doctors and receptionists.
  - Pop-up dialogs for operations like test requests, test result entry, and profile management.

## File Structure

The system uses the following files for data persistence:

- `users.txt`: Stores user profiles.
- `patients.txt`: Stores patient details.
- `tests.txt`: Stores available tests and their reference ranges.
- `pendingTests.txt`: Stores pending test requests.
- `patientHistory.txt`: Stores historical test results for patients.

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Eyad-Mostafa/pathology-lab-system.git
   ```
2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
3. Ensure your Java environment is properly set up.
4. Run the main application file to launch the GUI.

## Usage

1. Launch the application.
2. From the main menu, select:
   - **Add User**
   - **Log In** (Doctor or Receptionist)
   - **Exit**

3. Depending on the role:
   - **Receptionist**: Manage patient data, request tests.
   - **Doctor**: View pending requests, add test results.

4. All functionalities, including file operations, are integrated into the GUI.

## Classes Overview

- **FileManager**: Handles all file operations (read, write, update).
- **User**: Represents users with fields for ID, name, password, and role.
- **Patient**: Represents patients with fields for ID, name, age, gender, weight, height, and contact information.
- **Test**: Represents a test with fields for name, minimum, and maximum reference ranges.
- **TestResult**: Represents a test result associated with a patient.
- **GUI Components**: 
  - Custom Java Swing components for forms, tables, and dialog windows.

## UML Diagram

![UML Diagram](image./__Java%20Team__%20UML.png)

## Contributing

We're actually not looking for contributions to this repository, and we won't be actively watching it. However, feel free to fork the repository and make your own changes!


## License

This project is licensed under the MIT License.
