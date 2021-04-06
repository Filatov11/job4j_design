package ru.job4j.io;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class UsageLog4jslf4j {
    private static final  Logger LOG = LoggerFactory.getLogger(UsageLog4jslf4j.class.getName());
    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte b = 111;
        short s = 1234;
        int i = 64536;
        long l = 2147483648L;
        float f = 31.1418f;
        double d = 4233.12;
        boolean  bl = true;
        char ch = 'A';
        LOG.debug("byte b = : {}", b);
        LOG.debug("short s = : {}", s);
        LOG.debug("int i = : {}", i);
        LOG.debug("long l = : {}", l);
        LOG.debug("float f = : {}", f);
        LOG.debug("double d = : {}", d);
        LOG.debug("boolean  bl = : {}", bl);
        LOG.debug("char ch =  : {}", ch);
    }

}
