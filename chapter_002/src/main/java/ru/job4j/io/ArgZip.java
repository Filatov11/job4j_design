package ru.job4j.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    // java -jar pack.jar -d=/home/aster/IdeaProjects/job4j -e=class -o=project.zip
    private final String[] args;
    private final Map<String, String> values = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }


    public void parse(String[] args) {
        String key;
        String value;
        String[] mapArg;
        for (String ar : args) {
            System.out.println("ar  =" + ar);
            if ((ar.contains("="))) {
                mapArg = ar.split("=");
                values.put(mapArg[0].substring(1, 2), mapArg[1]);
            }
        }
    }


    public boolean valid() {
        if (args.length < 3) {
            throw new IllegalArgumentException("Invalid count of args. java -jar pack.jar -d '/home/aster/IdeaProjects/job4j' -e *.java -o project.zip ");
        }


        if (values.get("d") == null) {
            throw new IllegalArgumentException("Key d is null!");
        }

        if (values.get("o") == null) {
            throw new IllegalArgumentException("Key ootput -o is null!");
        }
        if (values.get("e") == null) {
            throw new IllegalArgumentException("Key exclude -e is null!");
        }

        File file = new File(args[1]);
        if (!file.exists()) {
            throw new IllegalArgumentException("Directory is not exists!");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("File is not directory!");
        }
        return true;

    }

    public String directory() {
        return values.get("d");
    }

    public String exclude() {
        return values.get("e");
    }

    public String output() {
        return values.get("o");
    }

}