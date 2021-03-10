package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {


        FileSystem fileSystem = FileSystems.getDefault();
        Path rootPath = fileSystem.getPath("/home/aster/Duplicates");
        try {
            Files.walkFileTree(rootPath,new DuplicatesVisitor());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    }





