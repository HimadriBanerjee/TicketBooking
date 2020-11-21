import db.PostgresManager;
import java.sql.*;
public class PostgreSQLJDBC{
    public static void main(String args[]) {
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
    }
}