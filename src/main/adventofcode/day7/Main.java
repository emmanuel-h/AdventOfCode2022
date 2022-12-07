package main.adventofcode.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final long DEVICE_MEMORY = 70000000L;
    private static final long NEEDED_MEMORY = 30000000L;
    private static Directory choosenDirectory;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day7"))) {
            String line;
            Directory root = new Directory("/", null);
            Directory currentDirectory = root;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (line.equals("$ ls")) continue;
                if (line.equals("$ cd ..")) {
                    currentDirectory = currentDirectory.getParentDirectory();
                    continue;
                }
                if (line.startsWith("$ cd ")) {
                    currentDirectory = currentDirectory.getSubDirectoryByName(line.substring(5));
                    continue;
                }
                if (line.startsWith("dir ")) {
                    currentDirectory.addSubdirectory(new Directory(line.substring(4), currentDirectory));
                    continue;
                }
                String[] s = line.split(" ");
                currentDirectory.addFile(new File(currentDirectory, Long.parseLong(s[0]), s[1]));
            }

            long freeMemory = DEVICE_MEMORY - root.getSize();
            long memoryNeeded = NEEDED_MEMORY - freeMemory;
            findDirectoriesBelowLimit(root, memoryNeeded);
            System.out.println(choosenDirectory.getSize());
        }
    }


    public static void findDirectoriesBelowLimit(Directory directory, long memoryNeeded) {
        if (directory.hasSubDirectories()) {
            for (Directory subDirectory : directory.getSubdirectories()) {
                findDirectoriesBelowLimit(subDirectory, memoryNeeded);
            }
        }
        if (directory.getSize() > memoryNeeded
                && (choosenDirectory == null || choosenDirectory.getSize() > directory.getSize()))
            choosenDirectory = directory;
    }
}
