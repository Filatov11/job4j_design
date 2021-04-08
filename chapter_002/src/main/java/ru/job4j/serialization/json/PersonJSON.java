package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.java.Contact;

import java.util.Arrays;

public class PersonJSON {
    private final boolean sex;
    private final int age;
    private final ContactJSON contact;
    private final String[] statuses;

    public PersonJSON(boolean sex, int age, ContactJSON contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }
    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }



    public static void main(String[] args) {
        final PersonJSON person = new PersonJSON(false, 30, new ContactJSON("11-111"), "Worker", "Married");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final PersonJSON personMod = gson.fromJson(personJson, PersonJSON.class);
        System.out.println(personMod);

    }
}
