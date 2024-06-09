package org.example.tpo5_ka_s28228.service;

import org.example.tpo5_ka_s28228.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class DataLoader {
    public void loadData(InputStream input) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Car car = new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                    DatabaseManager.insertCar(car);
                }
            }
        }
    }
}
