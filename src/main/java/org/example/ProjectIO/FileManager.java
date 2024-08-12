package org.example.ProjectIO;

import org.example.ProjectIO.DirectoryHandler;
import org.example.ProjectIO.FileHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {
    private static final Logger logger = Logger.getLogger(FileManager.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentDirectory;

        try {
            currentDirectory = setupDirectory(scanner);
            runFileManager(scanner, currentDirectory);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred during file operations", e);
        } finally {
            scanner.close();
        }
    }

    /**
     * Sets up the working directory, either creating a new one or navigating to an existing one.
     *
     * @param scanner Scanner for user input.
     * @return The directory path as a string.
     * @throws IOException If directory creation fails.
     */
    private static String setupDirectory(Scanner scanner) throws IOException {
        System.out.println("Create a new directory or enter an existing directory:");
        return getOrCreateDirectory(scanner);
    }

    /**
     * Runs the main loop of the file manager, offering various file and directory operations.
     *
     * @param scanner Scanner for user input.
     * @param directory The initial working directory.
     * @throws IOException If an I/O error occurs.
     */
    private static void runFileManager(Scanner scanner, String directory) throws IOException {
        String currentDirectory = directory;
        while (true) {
            displayMenu();
            int choice = getChoice(scanner);
            if (choice == 10) {
                System.out.println("Exiting...");
                return;
            }
            currentDirectory = handleUserChoice(scanner, currentDirectory, choice);
            DirectoryHandler.displayDirectoryContents(currentDirectory);
        }
    }

    /**
     * Displays the menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Display directory contents");
        System.out.println("2. Add file");
        System.out.println("3. Copy file");
        System.out.println("4. Move file");
        System.out.println("5. Delete file");
        System.out.println("6. Create directory");
        System.out.println("7. Delete directory");
        System.out.println("8. Search for files");
        System.out.println("9. Move between directories");
        System.out.println("10. Exit");
    }

    /**
     * Gets the user's choice from the menu.
     *
     * @param scanner Scanner for user input.
     * @return The selected menu option.
     */
    private static int getChoice(Scanner scanner) {
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid input, please enter a number between 1 and 10.");
            choice = -1;
        }
        return choice;
    }

    /**
     * Handles the user's menu choice.
     *
     * @param scanner Scanner for user input.
     * @param directory The current working directory.
     * @param choice The user's menu choice.
     * @throws IOException If an I/O error occurs during file operations.
     * @return The updated current directory after handling the user's choice.
     */
    private static String handleUserChoice(Scanner scanner, String directory, int choice) throws IOException {
        switch (choice) {
            case 1 -> DirectoryHandler.displayDirectoryContents(directory);
            case 2 -> addFile(scanner, directory);
            case 3 -> copyFile(scanner, directory);
            case 4 -> moveFile(scanner, directory);
            case 5 -> deleteFile(scanner, directory);
            case 6 -> createDirectory(scanner, directory);
            case 7 -> deleteDirectory(scanner);
            case 8 -> searchFiles(scanner, directory);
            case 9 -> directory = moveBetweenDirectories(scanner, directory);
            default -> System.out.println("Invalid choice. Try again.");
        }
        return directory;
    }

    private static void addFile(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter the file name to add:");
        String fileName = scanner.nextLine();
        FileHandler.addFile(directory, fileName);
    }

    private static void copyFile(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter the file name to copy:");
        String fileName = scanner.nextLine();
        FileHandler.copyFile(directory, fileName);
    }

    private static void moveFile(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter the file name to move:");
        String sourceFileName = scanner.nextLine();
        System.out.println("Enter the destination directory ('up' for parent, or subdirectory name, or sibling directory):");
        String destinationDirName = scanner.nextLine();

        FileHandler.moveFile(directory, sourceFileName, destinationDirName);
    }

    private static void deleteFile(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter the file name to delete:");
        String fileToDelete = scanner.nextLine();
        FileHandler.deleteFile(directory, fileToDelete);
    }

    private static void createDirectory(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter directory name to create:");
        String dirToCreate = scanner.nextLine();
        DirectoryHandler.createDirectory(Paths.get(directory, dirToCreate).toString());
    }

    private static void deleteDirectory(Scanner scanner) throws IOException {
        System.out.println("Enter directory path to delete:");
        String dirToDelete = scanner.nextLine();
        DirectoryHandler.deleteDirectory(dirToDelete);
    }

    private static void searchFiles(Scanner scanner, String directory) throws IOException {
        System.out.println("Enter file name or extension to search:");
        String query = scanner.nextLine();
        DirectoryHandler.searchFiles(directory, query);
    }

    /**
     * Moves between directories, including navigating up to the parent directory.
     *
     * @param scanner Scanner for user input.
     * @param currentDirectory The current working directory.
     * @return The new working directory.
     */
    private static String moveBetweenDirectories(Scanner scanner, String currentDirectory) {
        System.out.println("Enter the subdirectory name to move into, or type 'up' to go to the parent directory:");
        String subdirectory = scanner.nextLine();
        Path newDirectoryPath;

        if ("up".equalsIgnoreCase(subdirectory)) {
            newDirectoryPath = Paths.get(currentDirectory).getParent();
            if (newDirectoryPath == null) {
                System.out.println("You are already at the root directory.");
                return currentDirectory;
            }
        } else {
            newDirectoryPath = Paths.get(currentDirectory, subdirectory);
            if (!Files.exists(newDirectoryPath) || !Files.isDirectory(newDirectoryPath)) {
                System.out.println("Subdirectory does not exist.");
                return currentDirectory;
            }
        }

        System.out.println("Moved into directory: " + newDirectoryPath.toString());
        return newDirectoryPath.toString();
    }

    /**
     * Gets or creates a directory based on user input.
     *
     * @param scanner Scanner for user input.
     * @return The path to the created or navigated directory.
     * @throws IOException If an error occurs during directory creation.
     */
    private static String getOrCreateDirectory(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("Enter the directory path to create or navigate to:");
            String directory = scanner.nextLine();
            Path path = Paths.get(directory);

            if (Files.exists(path) && Files.isDirectory(path)) {
                System.out.println("Navigating to existing directory: " + directory);
                return directory;
            } else if (Files.notExists(path)) {
                try {
                    DirectoryHandler.createDirectory(directory);
                    return directory;
                } catch (IOException e) {
                    System.err.println("Failed to create directory: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid directory path. Please try again.");
            }
        }
    }
}
