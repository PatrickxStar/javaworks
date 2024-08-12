package org.example.ProjectIO;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private static final Logger logger = Logger.getLogger(FileHandler.class.getName());

    /**
     * Adds a file within the specified directory.
     *
     * @param directory The directory in which to add the file.
     * @param fileName The name of the file to add.
     * @throws IOException If an error occurs during file creation.
     */
    public static void addFile(String directory, String fileName) throws IOException {
        Path path = Paths.get(directory, fileName);
        if (Files.notExists(path)) {
            Files.createFile(path);
            logger.log(Level.INFO, "File created successfully: " + path);
        } else {
            logger.log(Level.WARNING, "File already exists: " + path);
        }
    }

    /**
     * Copies a file within the same directory with a new name.
     *
     * @param directory The directory where the file resides.
     * @param fileName The name of the file to copy.
     * @throws IOException If an error occurs during file copying.
     */
    public static void copyFile(String directory, String fileName) throws IOException {
        Path sourcePath = Paths.get(directory, fileName);

        // Check if source file exists
        if (!Files.exists(sourcePath)) {
            logger.log(Level.WARNING, "Source file does not exist: " + sourcePath);
            return;
        }

        // Generate a new name for the copied file
        String newFileName = generateCopyFileName(directory, fileName);
        Path destinationPath = Paths.get(directory, newFileName);

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            logger.log(Level.INFO, "File copied successfully from " + sourcePath + " to " + destinationPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to copy file", e);
            throw e;
        }
    }

    /**
     * Generates a new name for the copied file by appending "_copy" or a number to the original name.
     *
     * @param directory The directory where the file resides.
     * @param fileName The original file name.
     * @return The new file name for the copied file.
     */
    private static String generateCopyFileName(String directory, String fileName) {
        String baseName = fileName;
        String extension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            baseName = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        }

        String newFileName = baseName + "_copy" + extension;
        Path newFilePath = Paths.get(directory, newFileName);
        int copyCount = 1;

        while (Files.exists(newFilePath)) {
            newFileName = baseName + "_copy" + copyCount + extension;
            newFilePath = Paths.get(directory, newFileName);
            copyCount++;
        }

        return newFileName;
    }

    /**
     * Moves a file from one directory to another.
     *
     * @param currentDirectory The current directory.
     * @param sourceFileName The name of the file to move.
     * @param destinationDirName The destination directory.
     * @throws IOException If an error occurs during file moving.
     */
    public static void moveFile(String currentDirectory, String sourceFileName, String destinationDirName) throws IOException {
        Path sourcePath = Paths.get(currentDirectory, sourceFileName);

        if (!Files.exists(sourcePath)) {
            logger.log(Level.WARNING, "Source file does not exist: " + sourcePath);
            return;
        }

        Path destinationDir = resolveDestinationDirectory(currentDirectory, destinationDirName);
        if (destinationDir == null) {
            logger.log(Level.WARNING, "Invalid destination directory: " + destinationDirName);
            return;
        }

        Path destinationPath = destinationDir.resolve(sourcePath.getFileName());
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            logger.log(Level.INFO, "File moved successfully to " + destinationDir);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to move file", e);
            throw e;
        }
    }

    /**
     * Deletes a file within the current directory.
     *
     * @param directory The directory containing the file.
     * @param fileName The name of the file to delete.
     * @throws IOException If an error occurs during file deletion.
     */
    public static void deleteFile(String directory, String fileName) throws IOException {
        Path filePath = Paths.get(directory, fileName);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
            logger.log(Level.INFO, "File deleted successfully: " + filePath);
        } else {
            logger.log(Level.WARNING, "File not found: " + filePath);
        }
    }

    /**
     * Resolves the destination directory based on the provided name.
     *
     * @param currentDirectory The current working directory.
     * @param destinationDirName The destination directory name.
     * @return The resolved destination directory path, or null if invalid.
     */
    private static Path resolveDestinationDirectory(String currentDirectory, String destinationDirName) {
        Path parentDirectory = Paths.get(currentDirectory).getParent();
        Path destinationDir = null;

        if ("up".equalsIgnoreCase(destinationDirName)) {
            destinationDir = parentDirectory;
        } else if (Files.isDirectory(Paths.get(currentDirectory, destinationDirName))) {
            destinationDir = Paths.get(currentDirectory, destinationDirName);
        } else if (parentDirectory != null && Files.isDirectory(parentDirectory.resolve(destinationDirName))) {
            destinationDir = parentDirectory.resolve(destinationDirName);
        }

        return destinationDir;
    }
}
