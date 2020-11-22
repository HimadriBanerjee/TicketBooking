import db.PostgresManager;
import java.sql.*;
public class PostgreSQLJDBC{
    public static void main(String args[]) {
        Connection c = null;
        try {
          c = PostgresManager.getConnection();
            c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "Shivaji@16");
            String queryCheck = "select * from Passenger where passengerid=?",passengerid;
            ResultSet resultSet;
            PreparedStatement ps = c.prepareStatement(queryCheck);
            ps.setLong(1,1);
                resultSet = ps.executeQuery();
            // Statement statement = c.createStatement();
        //    ResultSet resultSet = statemente.executeQuery("select * from Passenger" );
            while (resultSet.next()) {
                System.out.println("passengerid: " + resultSet.getLong("passengerid"));
                System.out.println("name: " + resultSet.getString("name"));
               // System.out.println("age: " + resultSet.getInt("age"));
             //   System.out.println("address: " + resultSet.getString("address"));
              //  System.out.println("contact: " + resultSet.getLong("contact"));
                System.out.println("==========================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}