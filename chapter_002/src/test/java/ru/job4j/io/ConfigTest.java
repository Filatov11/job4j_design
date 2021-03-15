package ru.job4j.io;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "app.properties";
        Config config = new Config("app.properties");
        config.load();
        String l = config.value("hibernate.dialect");
        System.out.println("L = " + l);
      //  assertThat(
      //          config.value("hibernate.dialect"),
       //         is("org.hibernate.dialect.PostgreSQLDialect")
     //   );
    }
}