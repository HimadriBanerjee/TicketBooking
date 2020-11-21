import db.PostgresManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Passenger {
    private String name;
    private int age;
    public String address;
    private long idCard;
    private long contact;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract PassengerType getPassengerType();
   /*public   void getConnection() {
    Connection c = null;
        try {
        c = PostgresManager.getConnection();
        String queryCheck = "select name,age,address,contact from Passenger" + " where idCard=?";
        c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "Shivaji@16");
        ResultSet resultSet;
        PreparedStatement ps = c.prepareStatement(queryCheck);
        ps.setLong(1,this.idCard);
        resultSet = ps.executeQuery();
        // Statement statement = c.createStatement();
        //    ResultSet resultSet = statement.executeQuery("select * from Passenger" );
        while (resultSet.next()) {
            System.out.println("idCard: " + resultSet.getLong("idCard"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("age: " + resultSet.getInt("age"));
            System.out.println("address: " + resultSet.getString("address"));
            System.out.println("contact: " + resultSet.getLong("contact"));
            System.out.println("==========================");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}*/
}

