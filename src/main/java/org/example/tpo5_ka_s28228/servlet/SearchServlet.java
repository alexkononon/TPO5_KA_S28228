package org.example.tpo5_ka_s28228.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tpo5_ka_s28228.model.Car;
import org.example.tpo5_ka_s28228.service.DataLoader;
import org.example.tpo5_ka_s28228.service.DatabaseManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    private static final DataLoader dataLoader = new DataLoader();
    private static final Connection conn;

    static {
        try {
            conn = DatabaseManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        try( InputStream input = getClass().getClassLoader().getResourceAsStream("cars.txt");){
            dataLoader.loadData(input);
        } catch (IOException e) {
            throw new ServletException("Failed to load car data - IO problem", e);
        } catch (SQLException e) {
            throw new ServletException("Failed to load car data - SQL connection problem", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Cars WHERE type = ?")) {
            ps.setString(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cars.add(new Car(rs.getString("type"), rs.getString("brand"), rs.getInt("year"), rs.getDouble("fuelConsumption")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("cars", cars);
        response.sendRedirect("html-servlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


