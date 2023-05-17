/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.Connect;
import Entity.PhieuNhap;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MRSTHAO
 */
public abstract class PhieuNhapDAO implements DAOInterface<Object>{

    public static int insert(int id, String dateIn, float sumPayment, int userId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query="INSERT INTO phieunhap VALUES ("+id+",'"+dateIn+"',"+sumPayment+","+userId+")"; 
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

    public static int update(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query ="UPDATE phieunhap "
                + "SET sumPayment = (SELECT SUM(price) FROM SP_Nhap WHERE maPhieuNhap = "+id+") "
                + "WHERE id = "+id;
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
        int rsDelSP_Nhap = SPNhapDAO.deleteByMaPhieuNhap(id);
        if(rsDelSP_Nhap==1){
            String query = "DELETE FROM phieunhap WHERE id = "+id;
            try{
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                stm.executeUpdate(query);
                return 1;
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else 
            JOptionPane.showMessageDialog(null, "Xóa SP_Nhập ko thành công");
        return 0;
    }

    @Override
    public ArrayList<Object> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    public static PhieuNhap getById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PhieuNhap pn = null;
        String query = "SELECT * FROM phieunhap WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                pn = new PhieuNhap(
                        rs.getInt("id"),
                        rs.getDate("dateIn"),
                        rs.getFloat("sumPayment"),
                        rs.getInt("userId")
                );
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return pn;
    }

    @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
