package com.heroes.api.heroesapi.persistence;
import com.jcraft.jsch.*;

import java.sql.*;
import java.util.Properties;

public class DataSource {
        public static void main(String[] args) throws SQLException {
            int lport = 5432;
            String rhost = "starbug.cs.rit.edu";
            int rport = 5432;
            String user = "amk1881"; //change to your username
            String password = "$Icecream11230"; //change to your password
            String databaseName = "p320_09"; //change to your database name

            String driverName = "org.postgresql.Driver";
            Connection conn = null;
            Session session = null;
            try {
                java.util.Properties config = new java.util.Properties();
                config.put("StrictHostKeyChecking", "no");
                JSch jsch = new JSch();
                session = jsch.getSession(user, rhost, 22);
                session.setPassword(password);
                session.setConfig(config);
                session.setConfig("PreferredAuthentications","publickey,keyboard-interactive,password");
                session.connect();
                System.out.println("Connected");
                int assigned_port = session.setPortForwardingL(lport, "localhost", rport);
                System.out.println("Port Forwarded");

                // Assigned port could be different from 5432 but rarely happens
                String url = "jdbc:postgresql://localhost:"+ assigned_port + "/" + databaseName;

                System.out.println("database Url: " + url);
                Properties props = new Properties();
                props.put("user", user);
                props.put("password", password);

                Class.forName(driverName);
                conn = DriverManager.getConnection(url, props);
                System.out.println("Database connection established");

                // Do something with the database....
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM p320_09.song");
                ResultSet set = stmt.executeQuery();
                System.out.println(set);

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("caught");
            } finally {
                if (conn != null && !conn.isClosed()) {
                    System.out.println("Closing Database Connection");
                    conn.close();
                }
                if (session != null && session.isConnected()) {
                    System.out.println("Closing SSH Connection");
                    session.disconnect();
                }
            }
        }

    }
