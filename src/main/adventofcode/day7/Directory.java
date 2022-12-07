package main.adventofcode.day7;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Directory {

    private Set<Directory> subdirectories;

    private final Directory parentDirectory;

    private final String name;

    private long size;

    private Set<File> files;

    public Directory(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
    }

    public Set<Directory> getSubdirectories() {
        return subdirectories;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public void addSize(long fileSize) {
        this.size += fileSize;
        if (this.parentDirectory != null) this.parentDirectory.addSize(fileSize);
    }

    public void addSubdirectory(Directory subdirectory) {
        if (this.subdirectories == null) this.subdirectories = new HashSet<>();
        this.subdirectories.add(subdirectory);
    }

    public boolean hasSubDirectories() {
        return this.subdirectories != null && !this.subdirectories.isEmpty();
    }

    public void addFile(File file) {
        if (this.files == null) this.files = new HashSet<>();
        this.files.add(file);
        this.addSize(file.size());
    }

    public Directory getSubDirectoryByName(String name) {
        return this.subdirectories.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(name, directory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "subdirectories=" + subdirectories.size() +
                ", parentDirectory=" + parentDirectory +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", files=" + files +
                '}';
    }
}
