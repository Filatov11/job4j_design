package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OrderJSON {
    private Customer customer;
    private int orderNumber;
    private String [] purchasedProducts;
    private String  invoice;
    private boolean payed;



    public OrderJSON(Customer customer, int orderNumber, String[] purchasedProducts, String invoice, boolean payed ) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.purchasedProducts = purchasedProducts;
        this.invoice = invoice;
        this.payed = payed;
    }

    public static void main(String[] args) {
        OrderJSON orderJSON = new OrderJSON(new Customer(111, "Nik", "Smith"),
                123, new String[]{"milk","butter", "bread"}, "12344" , true);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        final String orderJsonString = gson.toJson(orderJSON);
        System.out.println(orderJsonString);

        OrderJSON orderJSONReverse = gson.fromJson(orderJsonString, OrderJSON.class);

        System.out.println( "Firstname "+ orderJSONReverse.customer.getFirstname() +
                        " lastname "+ orderJSONReverse.customer.getLastname() +
                        " number  "+ orderJSONReverse.customer.getNumber() +
                        " payed "+ orderJSONReverse.payed +
                    " products : " );
        for (String products: orderJSONReverse.purchasedProducts) {
            System.out.println(products);
        }
        System.out.println("invoice " + orderJSONReverse.invoice);


             //   ) ;

    }


}



 class Customer {

     private  int number ;
     private String firstname;


     private String lastname;

     public Customer( int CustomerNumber, String firstname, String lastname) {

         this.number = CustomerNumber;
         this.firstname = firstname;
         this.lastname = lastname;
     }
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