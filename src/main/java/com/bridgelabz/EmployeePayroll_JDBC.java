package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll_JDBC {

    public Connection con;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
    String dbUsername = "root";
    String dbPassword = "";

    ArrayList<EmployeeData> employeeDataArrayList = new ArrayList<>();

    public static void main(String[] args) {
        EmployeePayroll_JDBC employeePayroll_jdbc = new EmployeePayroll_JDBC();
        employeePayroll_jdbc.accessEmployeeData();
        employeePayroll_jdbc.showEmployeeDataList();
        employeePayroll_jdbc.updateEmployeeData();
    }

    public void connectDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (ClassNotFoundException e) {
            throw new UserException(UserException.ExceptionType.ClassNotFound,"The Class for MYSQL Driver Not Found.");
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"SQL Query Not Excuted Properly.");
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"The Database Connection Not Closed Properly.");
        }
    }

    public void accessEmployeeData() {
        connectDatabase();
        try {
            pstmt = con.prepareStatement("select * from employee_payroll");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                employeeDataArrayList.add(new EmployeeData(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"The SQL Query is Not Properly Executed");
        } finally {
            closeConnection();
        }
    }

    public void updateEmployeeData() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Salary : ");
            long salary = sc.nextLong();
            System.out.println("Enter the Employee Name : ");
            String employeeName = sc.next();

            connectDatabase();
            pstmt = con.prepareStatement("update employee_payroll set salary=? where name=?");
            pstmt.setLong(1,salary);
            pstmt.setString(2,employeeName);
            int rows = pstmt.executeUpdate();
            System.out.println(rows+" Rows Updated.");
            employeeDataArrayList.stream().forEach(x->{
                if ((x.getName().equalsIgnoreCase(employeeName))) {x.setSalary(salary);}
                else { x.setSalary(x.getSalary()); }
            });
            showEmployeeDataList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                    closeConnection();
        }
    }

    public void showEmployeeDataList() {
        try {
            for (EmployeeData employeeData : employeeDataArrayList) {
                System.out.println(employeeData.toString());
            }
        } catch (NullPointerException e) {
            throw new UserException(UserException.ExceptionType.NullList,"Employee Data List is Empty.");
        }
    }
}
