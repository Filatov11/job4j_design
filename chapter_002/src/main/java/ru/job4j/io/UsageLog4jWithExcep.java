package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jWithExcep {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4jWithExcep.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Error", e);
            throw e;
        }
    }
}
