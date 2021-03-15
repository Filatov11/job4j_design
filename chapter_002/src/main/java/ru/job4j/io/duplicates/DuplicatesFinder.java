package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {


        FileSystem fileSystem = FileSystems.getDefault();
        Path rootPath = fileSystem.getPath("/home/aster/Duplicates");
        try {
            Files.walkFileTree(rootPath, new DuplicatesVisitor());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}





