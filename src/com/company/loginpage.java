package com.company;

import javax.swing.*;
import java.awt.*;
import java.beans.Visibility;
import java.sql.*;

public class loginpage extends Thread {
        JFrame mainframe = new JFrame("loginpage");
        JPanel mainpanel = new JPanel(new GridLayout(3,1));
        JButton btn_login = new JButton("Log In");
        JTextField username = new JTextField();
        JTextField password = new JTextField();
        public loginpage(){ }
        public void run(){
            Visiblity();

        }

        public void Visiblity(){
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.setLocationRelativeTo(null);
            mainframe.setVisible(true);
            mainframe.setSize(800,600);
            mainframe.add(mainpanel);
            mainpanel.add(username);
            username.setBorder(BorderFactory.createTitledBorder("username"));
            password.setBorder(BorderFactory.createTitledBorder("password"));
            mainpanel.add(password);
            mainpanel.add(btn_login);
            btn_login.addActionListener(e -> getinfo());

    }
        public void getinfo(){
            String info ;
            info= username.getText();
            info=info+password.getText();
            System.out.println(info);
            try {
                saver(info);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void saver(String info) throws ClassNotFoundException, SQLException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Dashtikh","dashti1565");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into inform (informe) values (?)");
            preparedStatement.setString(1,info);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        }
}
