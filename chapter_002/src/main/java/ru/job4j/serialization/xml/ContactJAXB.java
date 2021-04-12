package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class ContactJAXB {
    @XmlAttribute
    private String phone;

    public ContactJAXB() {

    }

    public ContactJAXB(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }

}
