package com.github.zjjfly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author z00405ze
 */
public class TryWithResource {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection postgres = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/epa_master_db", "postgres", "123456");
        try (postgres; ResultSet rs = postgres.createStatement().executeQuery("select * from sensors")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
