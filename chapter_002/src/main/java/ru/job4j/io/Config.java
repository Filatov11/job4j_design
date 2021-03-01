package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        //String[] line;
        String line = null;
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while ((line = read.readLine()) != null) {
                fillHash(line);
            }

        } catch (Exception e) {
            System.err.println("Error: Target File Cannot Be Read");
        }
    }

    public String value(String key) {
        String res = this.values.get(key);
        return res;
    }

    public void fillHash(String val) {
        String key;
        String value;
        if (!val.startsWith("#") && (val.contains("="))) {
            int posA = val.indexOf('=');
            key = val.substring(0, posA);
            value = val.substring(posA + 1);
            this.values.put(key, value);
        }

    }

    public void writeToFile(String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {

            for (Map.Entry<String, String> entry : this.values.entrySet()) {
                out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {

        Config config = new Config("app.properties");
        config.load();
        config.writeToFile("./data/app.properties");
        config.value("hibernate.dialect");
    }
}
