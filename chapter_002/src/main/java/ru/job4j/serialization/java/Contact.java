package ru.job4j.serialization.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable, Externalizable {
    private static Logger LOG = LoggerFactory.getLogger(Contact.class.getName());
    private static final long serialVersionUID = 1L;
    private int zipCode;
    private String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public Contact() {
    }



    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(zipCode);
        out.writeObject(phone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        zipCode = in.readInt();
        phone = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }

        try {
            Contact contact1 = new Contact(999999, "+7 (323) 322-223-322");
            FileOutputStream fos = new FileOutputStream("/home/aster/IdeaProjects/job4j_design/testfile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact1);
            oos.flush();
            oos.close();
            Contact contact2;
            FileInputStream fis = new FileInputStream("/home/aster/IdeaProjects/job4j_design/testfile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contact2 = (Contact) ois.readObject();
            ois.close();
            System.out.println("ZipCode: " + contact2.getZipCode() + ", Phone: " + contact2.getPhone());
        } catch (Exception e) {
            LOG.debug("Debug info " + e);
        }
    }
}
