package application;

import java.sql.*;

public class DbConnection {

    public static Connection con = createCon();

    public static Connection createCon() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.10.204:3306/asteroids", "mysql", "pkc4Ubu");
            System.out.println("Success");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void retrieveByString(String tableName, String columnName, String findThis) {
        try {
            String[] columns = retrieveColumns(tableName);
            for (String s : columns) {
                if (s.equals(columnName)) {
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet resultSet = stmt.executeQuery(String.format("SELECT * FROM %s WHERE %s='%s'", tableName, columnName, findThis));
                    while (resultSet.next()) {
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isUsernameTaken(String username) {
        try {
            String tableName = "users";
            String usernameColumn = "username";

            String selectQuery = String.format("SELECT * FROM %s WHERE %s=?", tableName, usernameColumn);

            try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean authenticateUser(String username, String password) {
        try {
            String tableName = "USER"; 
            String usernameColumn = "username"; 
            String passwordColumn = "password"; 

            String selectQuery = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, usernameColumn, passwordColumn);

            try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password); 

                ResultSet resultSet = preparedStatement.executeQuery();

                
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void registerUser(String username, String password) {
        try {
            String tableName = "USER"; 
            String usernameColumn = "username";
            String passwordColumn = "password"; 

            String insertQuery = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", tableName, usernameColumn, passwordColumn);

            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static String[] retrieveColumns(String tableName) {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(String.format("SELECT COLUMN_NAME "
                    + "FROM INFORMATION_SCHEMA.COLUMNS "
                    + "WHERE TABLE_NAME = '%s' "
                    + "ORDER BY ORDINAL_POSITION", tableName));

            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
            }

            rs.beforeFirst();

            String[] columns = new String[rowCount];

            int i = 0;
            while (rs.next()) {
                columns[i++] = rs.getString("COLUMN_NAME");
            }
            System.out.println(columns.toString());
            return columns;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

