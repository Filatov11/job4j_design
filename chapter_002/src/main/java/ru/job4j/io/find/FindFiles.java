package ru.job4j.io.find;

import ru.job4j.io.find.Flist;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FindFiles {


    public static List<Path> getLog() {
        return log;
    }

    public static void setLog(List<Path> log) {
        FindFiles.log = log;
    }

    private static List<Path> log = new LinkedList<>();
    private final Map<String, String> values = new HashMap<>();
    private  String[] argsArr;

    public FindFiles() {

    }

    public String get(String key) {
        return values.get(key);
    }
    public static FindFiles of(String[] args) {
        FindFiles names = new FindFiles();
        names.parse(args);
        return names;
    }


    public void parse(String[] args) {
        String key;
        String value;
        String[] mapArg;
        for (String ar : args) {
            if ((ar.contains("="))) {
                mapArg = ar.split("=");
                values.put(mapArg[0].substring(1), mapArg[1]);
            }
        }
    }





    public FindFiles(String[] args) {
        this.argsArr = args;
    }

    public static void usage() {

           System.out.println("Example usage:  java -jar find.jar -d=/tmp -n=*.txt -t=mask -o=log.txt");




    }



    public static void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (Path Pathnane  : log) {
                out.println(Pathnane.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public static void main(String args[]) throws IOException {
        FindFiles findFiles = FindFiles.of(args);
        System.out.println(findFiles.get("d"));
        Path start = Paths.get("d");
        if ( findFiles.get("n") == null || findFiles.get("n") == null)  { usage();  };
       // ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
       // System.out.println(zip.get("out"));
        //  Flist flist = new Flist(start);
       // Path start = Paths.get("d");
        searchf(start, findFiles.get("n"));

    }



    public static void searchf(Path root, String ext) throws IOException {
        Flist flist = new Flist(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, flist);
        save(flist.getPaths(), "search.log");

    }

    }




