package storage;

import task.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.*;

import java.util.ArrayList;

public class Storage {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/data/Partillay.txt";
    private static final String DIR_PATH = System.getProperty("user.dir") + "/src/data/";
    private static ArrayList<Task> tasks;

    public Storage() {
        checkAndPrepareFile();
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void checkAndPrepareFile() {
        Path dirPath = Paths.get(DIR_PATH);
        Path filePath = Paths.get(FILE_PATH);
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectories(dirPath);
                System.out.println("Directory created: " + dirPath.toString());
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        }
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
                System.out.println("File created: " + filePath.toString());
            } catch (IOException e) {
                System.err.println("Failed to create file: " + e.getMessage());
            }
        }
    }

    public void writeTasksToFile(TaskList tasks) {
        Path path = Paths.get(FILE_PATH);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            System.err.println("Error deleting or creating the file: " + e.getMessage());
        }
        ArrayList<Task> tasksToWrite = tasks.getTasks();
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            for (int i = 0; i < tasksToWrite.size(); i++) {
                writer.write(tasksToWrite.get(i).getTxtFormat());
                if (i < tasks.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }

    public void loadTasksFromFile() {
        Path path = Paths.get(FILE_PATH);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String type = parts[0].trim();

                // Parse based on the type (D, E, or T)
                switch (type) {
                    case "D" -> {
                        // Deadline: D | status | description | by
                        String status = parts[1].trim();
                        String description = parts[2].trim();
                        String by = parts[3].trim();
                        tasks.add(new Deadline(description, by, status));
                    }
                    case "E" -> {
                        // Event: E | status | description | from | to
                        String status = parts[1].trim();
                        String description = parts[2].trim();
                        String from = parts[3].trim();
                        String to = parts[4].trim();
                        tasks.add(new Event(description, from, to, status));
                    }
                    case "T" -> {
                        // ToDo: T | status | description
                        String status = parts[1].trim();
                        String description = parts[2].trim();
                        tasks.add(new ToDo(description, status));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load tasks: " + e.getMessage());
        }

    }
}