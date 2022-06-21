package service;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;



public class StationDataCollector extends BaseService {

        private final String id;

        private static final String BROKER_URL = "tcp://localhost:6616";
        private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/semesterdb?user=swe1user&password=swe1pw";

        public StationDataCollector(String inDestination, String outDestination, String brokerUrl) {
            super(inDestination, outDestination, brokerUrl);

            this.id = UUID.randomUUID().toString();

            System.out.println("Collection of Data for ... (" + this.id + ") started...");
        }


        public void writeDataForCustomer() throws SQLException {
            List<> chargingsList = new ArrayList<>();

            try (Connection conn = connect()) {
                String sql = "SELECT * FROM chargings WHERE customerId = " + this.id;
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Charging charging = new Charging();

                    charging.date = resultSet.getString("charging_date");
                    charging.amount = resultSet.getFloat("charging_amount");
                    charging.stationId = resultSet.getInt("station_id");

                    chargingList.add(charging);
                }

            } catch (SQLException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }




        }






        /* --Hier fängt der Food-Worker an

        @Override
        protected String executeInternal(String input) {
            String jobId = UUID.randomUUID().toString();

            try (Connection conn = connect()) {
                String sql = "INSERT INTO orders (type, name, status, job_id, worker_id) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, "FOOD");
                preparedStatement.setString(2, input);
                preparedStatement.setString(3, "working...");
                preparedStatement.setString(4, jobId);
                preparedStatement.setString(5, this.id);
                preparedStatement.execute();
            } catch (SQLException e) {
                return "error";
            }

            try {
                Random r = new Random();
                int low = 30000;
                int high = 60000;
                int result = r.nextInt(high-low) + low;
                Thread.sleep(result);
            } catch (InterruptedException e) {
                return "error";
            }

            try (Connection conn = connect()) {
                String sql = "UPDATE orders SET status = ?, last_updated = ? WHERE job_id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, "done!");
                preparedStatement.setObject(2, LocalDateTime.now());
                preparedStatement.setString(3, jobId);

                preparedStatement.execute();
            } catch (SQLException e) {
                return "error";
            }
            return "ok";
        }

        */

        private Connection connect() throws SQLException {
            return DriverManager.getConnection(DB_CONNECTION);
        }


}
