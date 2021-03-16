package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
  private Set<FileProperty> fList = new HashSet<>();
    private ArrayList<String> dup = new ArrayList<String>();

    @Override
    public FileVisitResult visitFile(Path visitedFile, BasicFileAttributes fileAttributes)
            throws IOException {
        boolean isAdded = fList.add(
                new FileProperty(fileAttributes.size(), visitedFile.getFileName().toString()));
        if (!isAdded) {
            dup.add(visitedFile.toFile().getAbsolutePath().toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException exc) throws IOException {

        printDuplicates();
        return FileVisitResult.CONTINUE;
    }


    public void printDuplicates() {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(dup);

        List<String> listWithoutDuplicates = dup.stream().distinct().collect(Collectors.toList());

        for (String rec : listWithoutDuplicates) {
            System.out.println(rec);
        }


    }

}


