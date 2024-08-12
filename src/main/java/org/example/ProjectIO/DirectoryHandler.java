package org.example.ProjectIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectoryHandler {
    private static final Logger logger = Logger.getLogger(DirectoryHandler.class.getName());

    /**
     * Creates a new directory within the specified root directory.
     *
     * @param directory The path of the directory to create.
     * @throws IOException If an error occurs during directory creation.
     */
    public static void createDirectory(String directory) throws IOException {
        Path path = Paths.get(directory);
        if (Files.notExists(path)) {
            Files.createDirectories(path);
            logger.log(Level.INFO, "Directory created successfully: " + path);
        } else {
            logger.log(Level.WARNING, "Directory already exists: " + path);
        }
    }

    /**
     * Deletes a directory and all its contents within the specified root directory.
     *
     * @param directory The path of the directory to delete.
     * @throws IOException If an error occurs during directory deletion.
     */
    public static void deleteDirectory(String directory) throws IOException {
        Path path = Paths.get(directory);
        if (Files.exists(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    logger.log(Level.INFO, "File deleted: " + file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    logger.log(Level.INFO, "Directory deleted: " + dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            logger.log(Level.WARNING, "Directory does not exist: " + path);
        }
    }

    /**
     * Displays the contents of a directory within the specified root directory.
     *
     * @param directory The path of the directory to display.
     * @throws IOException If an error occurs during directory access.
     */
    public static void displayDirectoryContents(String directory) throws IOException {
        Path dirPath = Paths.get(directory);
        if (Files.isDirectory(dirPath)) {
            logger.log(Level.INFO, "Contents of directory: " + dirPath.toAbsolutePath());
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)) {
                for (Path path : stream) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.printf("%s %d bytes %s\n",
                            path.getFileName(),
                            attrs.size(),
                            attrs.lastModifiedTime());
                }
            }
        } else {
            logger.log(Level.WARNING, "Not a directory: " + dirPath);
        }
    }

    /**
     * Searches for files within a directory based on a name or extension within the specified root directory.
     *
     * @param directory The path of the directory to search.
     * @param query The search query (file name or extension).
     * @throws IOException If an error occurs during directory access.
     */
    public static void searchFiles(String directory, String query) throws IOException {
        Path dirPath = Paths.get(directory);
        if (Files.isDirectory(dirPath)) {
            Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.getFileName().toString().contains(query)) {
                        System.out.println(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            logger.log(Level.WARNING, "Not a directory: " + dirPath);
        }
    }
}
