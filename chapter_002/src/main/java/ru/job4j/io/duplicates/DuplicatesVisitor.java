package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.security.*;
import java.util.*;
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashMap<String, FileProperty>  fList = new HashMap<>();


    @Override
    public FileVisitResult visitFile(Path visitedFile,BasicFileAttributes fileAttributes)
            throws IOException {
          fList.put(fileAttributes.fileKey().toString(),new FileProperty(fileAttributes.size(),visitedFile.getFileName().toString()));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException exc) throws IOException {

     printDuplicates();
        return FileVisitResult.CONTINUE;
    }


    public void printDuplicates () {

        Collection<FileProperty> list = fList.values();
        for(Iterator<FileProperty> itr = list.iterator(); itr.hasNext();)
        { FileProperty fp = new FileProperty(0,"");
            if(Collections.frequency(list, fp = itr.next())>1)
            {
               System.out.println(fp.getName() + " " + fp.getSize());
            }
        }

    }

}
