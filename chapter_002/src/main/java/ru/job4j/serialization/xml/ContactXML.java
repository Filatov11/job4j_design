package ru.job4j.serialization.xml;

public class ContactXML {
    private final String phone;

    public ContactXML(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
