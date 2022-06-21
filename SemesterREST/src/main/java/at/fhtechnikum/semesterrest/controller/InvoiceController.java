package at.fhtechnikum.semesterrest.controller;

import at.fhtechnikum.semesterrest.dto.Charging;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    private final static String BROKER_URL = "tcp://localhost:6616";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/semesterdb?user=swe1user&password=swe1pw";

    @GetMapping("/customers/{id}")
    public List<Charging> readAll(@PathVariable int id) {
        List<Charging> chargings = new ArrayList<>();


        try (Connection conn = connect()) {
            String sql = "SELECT * FROM processes WHERE customer_id == id";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Charging charging = new Charging();

                charging.date = resultSet.getString("charging_date");
                charging.amount = resultSet.getFloat("charging_amount");
                //charging.station_id = resultSet.getInt("station_id");

                chargings.add(charging);
            }
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return chargings;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_CONNECTION);
    }




    //localhost:8080/customers/456
   /* @GetMapping("/customers/{id}")
    public Charging getCharging(@PathVariable int id) {
        //suche in der Datenbank nach customer id
        Charging chargingElement = new Charging();
        //nun muss die Datenbank die Charging-Elemente in einem Json speichern
        return chargingElement;
    }

    */



}
