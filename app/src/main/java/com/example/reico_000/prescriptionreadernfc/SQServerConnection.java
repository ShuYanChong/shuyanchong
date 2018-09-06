package com.example.reico_000.prescriptionreadernfc;


import java.sql.*; //* add all related imports

public class SQServerConnection {

    public static Connection dbConnector(){
        try
        {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String userName = "Test";//"PatientLogin";
            String password = "123456";//"159Test159";
            String url = "jdbc:jtds:sqlserver://192.168.2.3/NFCMedFeedback";
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("test");

            return conn;

        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
