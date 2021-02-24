package ru.job4j.contcollect;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {


    @Test
    public void someChanges() {

        List <Analize.User> current = Arrays.asList( new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert"),
                new Analize.User(6,"wert")
        });
        List <Analize.User> previous = Arrays.asList(new Analize.User[] {
                new Analize.User(1,"wert"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert")
        });

        Analize.Info result =  Analize.diff(previous, current);
        assertThat(result.added, is(2));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(1));
    }


    @Test
    public void noChanges() {

        List <Analize.User> current = Arrays.asList( new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert"),
                new Analize.User(6,"wert")
        });
        List <Analize.User> previous = Arrays.asList(new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert"),
                new Analize.User(6,"wert")
        });

        Analize.Info result =  Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }


    @Test
    public void insertChanges() {

        List <Analize.User> current = Arrays.asList( new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert"),
                new Analize.User(6,"wert")
        });
        List <Analize.User> previous = Arrays.asList(new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert")
        });

        Analize.Info result =  Analize.diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }



    @Test
    public void updateChanges() {

        List <Analize.User> current = Arrays.asList( new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert")
        });
        List <Analize.User> previous = Arrays.asList(new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert1"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert"),
                new Analize.User(5,"wert")
        });

        Analize.Info result =  Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(0));
    }


    @Test
    public void deleteChanges() {

        List <Analize.User> current = Arrays.asList( new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert") //,
               // new Analize.User(4,"wert")
              //  new Analize.User(5,"wert")
        });
        List <Analize.User> previous = Arrays.asList(new Analize.User[] {
                new Analize.User(1, "qweer"),
                new Analize.User(2,"wert"),
                new Analize.User(3,"wert"),
                new Analize.User(4,"wert")
               , new Analize.User(5,"wert")
        });

        Analize.Info result =  Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(2));
    }



}
