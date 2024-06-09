package org.example.tpo5_ka_s28228.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tpo5_ka_s28228.model.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HtmlServlet", value = "/html-servlet")
public class HtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Car> cars = (List<Car>) request.getSession().getAttribute("cars");
        out.println("<html><body>");
        out.println("<h1>Results</h1>");
        if(cars.isEmpty()){
            out.println("<h3>There is no transport of this type</h3>");
        } else {
            out.println("<table border='1'>");
            out.println("<tr><th>Type</th><th>Brand</th><th>Year</th><th>Fuel Consumption</th></tr>");
            for (Car car : cars) {
                out.println("<tr>");
                out.println("<td>" + car.getType() + "</td>");
                out.println("<td>" + car.getBrand() + "</td>");
                out.println("<td>" + car.getYear() + "</td>");
                out.println("<td>" + car.getFuelConsumption() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        out.println("<form action='index.jsp' method='get'>");
        out.println("<button type='submit'>Return to Search</button>");
        out.println("</form>");
        out.println("</body></html>");
        request.getSession().removeAttribute("cars");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
