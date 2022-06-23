
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
        
        //dummy Data
        
        preparedStatement.setInt(1, 1239 );
        preparedStatement.setString(2, "John Doe" );
        preparedStatement.setString(3, "Derybasivska 3" );
        preparedStatement.setString(4, "Odessa" );
        preparedStatement.setInt(5, 1100 );

        preparedStatement.setInt(1, 1537 );
        preparedStatement.setString(2, "Julia Fisher" );
        preparedStatement.setString(3, "vul.Vilna 68" );
        preparedStatement.setString(4, "Kyiv" );
        preparedStatement.setInt(5, 03164 );

        preparedStatement.setInt(1, 1722 );
        preparedStatement.setString(2, "Rza Gurbanov" );
        preparedStatement.setString(3, "Johannesgasse 4a" );
        preparedStatement.setString(4, "Wien" );
        preparedStatement.setInt(5, 1060 );

        preparedStatement.setInt(1, 1352 );
        preparedStatement.setString(2, "Michi Att" );
        preparedStatement.setString(3, "Rotenhoffgasse 11" );
        preparedStatement.setString(4, "Wien" );
        preparedStatement.setInt(5, 1020 );

        preparedStatement.setInt(1, 2643 );
        preparedStatement.setString(2, "Olga Andrienko" );
        preparedStatement.setString(3, "vul.Sichovych striltziv 124" );
        preparedStatement.setString(4, "Vinnytsia" );
        preparedStatement.setInt(5, 03352 );

        preparedStatement.setInt(1, 3622 );
        preparedStatement.setString(2, "Viktoria Moll" );
        preparedStatement.setString(3, "prov.Tchervonozavodsky 2/13" );
        preparedStatement.setString(4, "Kyiv" );
        preparedStatement.setInt(5, 03162 );


        preparedStatement.execute();

        query = "SELECT * FROM customers";
        preparedStatement = conn.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("customer_name"));
        }

    }





}
