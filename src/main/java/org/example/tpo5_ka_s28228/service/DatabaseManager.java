package org.example.tpo5_ka_s28228.service;

import com.mysql.cj.jdbc.Driver;
import org.example.tpo5_ka_s28228.model.Car;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DatabaseManager {
    private static final String URL= "jdbc:mysql://localhost:3306/tpo_five";
    private static final String USERNAME= "root";
    private static final String PASSWORD= "1234";
    private static final Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertCar(Car car) throws SQLException {
        String insertSQL = "INSERT INTO Cars (type, brand, year, fuelConsumption) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(insertSQL)) {
            ps.setString(1, car.getType());
            ps.setString(2, car.getBrand());
            ps.setInt(3, car.getYear());
            ps.setDouble(4, car.getFuelConsumption());
            ps.executeUpdate();
        }
    }

    public static Connection getConnection() throws SQLException {
        return connection;
    }

}
