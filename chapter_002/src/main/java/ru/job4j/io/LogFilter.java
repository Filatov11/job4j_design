package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }

    public static List<String> filter(String file) {
        String line;
        List<String> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while ((line = in.readLine()) != null) {
                if (checkResponse(line)) {
                    log.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }

    public static boolean checkResponse(String resp) {
        return resp.contains("404");
    }
}
