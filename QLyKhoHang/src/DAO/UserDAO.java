/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.*;
import ConnectDatabase.Connect;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MRSTHAO
 */
public abstract class UserDAO implements DAOInterface<Object> {

    public static int insert(int id, String username, String password, int role, String fullname,String address, String phone) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query="INSERT INTO users VALUES ("+id+",N'"+username+"',N'"+password+"',"+role+",N'"+fullname+"',N'"+address+"',N'"+phone+"')"; 
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static int update(int id, String username, String password, int role, String fullname, String address, String phone) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query ="UPDATE users SET "
                + "username = '"+username+"'"
                + " , password = '"+password+"'"
                + " , role = "+role
                + " , fullname = '"+fullname+"'"
                + " , address = '"+address+"'"
                + " , phone = '"+phone+"'"
                + " WHERE id = "+id+";";
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static int deleteById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "DELETE FROM users WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            return 1;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static Users getUserById(int id) {
        Users user = null;
        String query = "SELECT * FROM users WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                user = new Users(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getString("fullname"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            };
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return user;
    }
    
    public static Users getUserByUserName(String username) {
        Users user = null;
        String query = "SELECT * FROM users WHERE username = N'"+username+"'";
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                user = new Users(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getString("fullname"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            };
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return user;
    }
    //For login
    public static Users getUser(String userName, String password) {
        Users user = null;
        String query = "SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + password + "'";
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                user = new Users(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getString("fullname"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return user;
    }
     @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
