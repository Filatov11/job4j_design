package ru.job4j.io;
import java.util.HashMap;
import java.util.Map;
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.containsKey(key) ? values.get(key): null;
    }

    private void parse(String[] args) {
        String key;
        String value;
        if ((args.length == 0 ) || (args == null)) { values.put(null, null);}
     for (String ar : args) {
         if ((ar.contains("="))) {
             int posA = ar.indexOf('=');
             key = ar.substring(1, posA);
             value = ar.substring(posA + 1);
             values.put(key, value);
         }
     }
    }

    public static ArgsName of(String[] args) {
ArgsName names = new ArgsName();
names.parse(args);
return names;
    }

    public static void main(String args[]) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
