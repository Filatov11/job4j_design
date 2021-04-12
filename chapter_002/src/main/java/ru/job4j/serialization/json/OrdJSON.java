package ru.job4j.serialization.json;

import org.json.JSONObject;
import org.json.JSONPropertyIgnore;

public class OrdJSON {
    private CustJSON customer;
    private int orderNumber;
    private String[] purchasedProducts;

    public CustJSON getCustomer() {
        return customer;
    }

    public void setCustomer(CustJSON customer) {
        this.customer = customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String[] getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(String[] purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    private String invoice;
    private boolean payed;


    public OrdJSON(CustJSON customer, int orderNumber, String[] purchasedProducts, String invoice, boolean payed) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.purchasedProducts = purchasedProducts;
        this.invoice = invoice;
        this.payed = payed;
    }

    public static void main(String[] args) {
        OrdJSON orderJSON = new OrdJSON(new CustJSON(111, "Nik", "Smith"),
                123, new String[]{"milk", "butter", "bread"}, "12344", true);

        System.out.println(new JSONObject(orderJSON));
    }


}


class CustJSON {

    private int number;
    private String firstname;


    private String lastname;

    public CustJSON(int CustomerNumber, String firstname, String lastname) {

        this.number = CustomerNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @JSONPropertyIgnore
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}


