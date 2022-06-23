
import java.sql.*;


// Problem: driver für jdbc nicht gefunden. Driver heruntergeladen (in Benutzer) aber funktioniert trotzdem nicht
// Java Build Path in InteliJ nicht gefunden
public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/semesterdb?user=swe1user&password=swe1pw";

        Connection conn = DriverManager.getConnection(url);

        String query = "INSERT INTO customers (customer_id, customer_name,  customer_street, customer_city, customer_zip) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);

        //Ich möchte die ID automatisch generieren lassen
        //Gibt es eine Möglichkeit, die Datenbank automatisch mit ein paar dummy-Daten zu befüllen?
        preparedStatement.setInt(1, 1235 );
        preparedStatement.setString(2, "Kunde2" );
        preparedStatement.setString(3, "Adresse2" );
        preparedStatement.setString(4, "City1" );
        preparedStatement.setInt(5, 1234 );

        preparedStatement.execute();

        query = "SELECT * FROM customers";
        preparedStatement = conn.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("customer_name"));
        }

    }





}
