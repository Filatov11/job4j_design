package ru.job4j.serialization.json;

public class ContactJSON {
    private final String phone;
    public ContactJSON(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
