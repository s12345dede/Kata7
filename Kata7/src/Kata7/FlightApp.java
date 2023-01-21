package Kata7;

import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Flight;

/**
 * 
 * @author Louka Vanhoucke
 */
public class FlightApp {
    static String database = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata7\\flights.db";
    
    public String getAll() {
        String sql = "SELECT * FROM flights";
        return this.getDataFromSql(sql);
    }
    
    public String getDay(String day) {
        String sql = "SELECT * FROM flights WHERE DAY_OF_WEEK=" + this.getNumberOfDay(day);
        return this.getDataFromSql(sql);
    }
    public String  getBiggerDistance(String distance) {
        String sql = "SELECT * FROM flights WHERE DISTANCE >=" + distance;
        return this.getDataFromSql(sql);
    }

    public String  getLowerDistance(String distance) {
        String sql = "SELECT * FROM flights WHERE DISTANCE <=" + distance;
        return this.getDataFromSql(sql);
    }
    
    public String getCancelled() {
        String sql = "SELECT * FROM flights WHERE CANCELLED =1";
        return this.getDataFromSql(sql);
    }

    public String getDiverted() {
        String sql = "SELECT * FROM flights WHERE DIVERTED=1";
        return this.getDataFromSql(sql);
    
    }
    
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private String serializeList(List<Flight> flights) {
        return new Gson().toJson(flights);
    }
    
    private List<Flight> resultSetToList(ResultSet rs) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        while (rs.next()) {
            flights.add(new Flight(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getInt(9))
            );
        } return flights;
    }

    private String getNumberOfDay(String day) {
        switch(day) {
            case "monday" -> {
                return "1";
            }
            case "tuesday" -> {
                return "2";
            }
            case "wednesday" -> {
                return "3";
            }
            case "thusrday" -> {
                return "4";
            }
            case "friday" -> {
                return "5";
            }
            case "saturday" -> {
                return "6";
            }
            case "sunday" -> {
                return "7";
            }
        } return "-1";  //Ocurre un error
    }

    private String getDataFromSql(String sql) {
        List<Flight> flights = null;
        try (Connection conn = this.connect(); java.sql.Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            flights = this.resultSetToList(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return this.serializeList(flights);
    }
}
