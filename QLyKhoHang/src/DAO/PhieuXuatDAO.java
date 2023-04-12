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
public abstract class PhieuXuatDAO implements DAOInterface<Object> {

    public static int insert(int id, String dateOut, float sumPayment, int userId)  {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query="INSERT INTO phieuxuat VALUES ("+id+",'"+dateOut+"',"+sumPayment+","+userId+")"; 
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
        String query ="UPDATE phieuxuat "
                + "SET sumPayment = (SELECT SUM(price) FROM SP_Xuat WHERE maPhieuXuat = "+id+") "
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
        int rsDelSP_Xuat = SPXuatDAO.deleteByMaPhieuXuat(id);
        if(rsDelSP_Xuat==1){
            String query = "DELETE FROM phieuxuat WHERE id = "+id;
            try{
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                stm.executeUpdate(query);
                return 1;
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else 
            JOptionPane.showMessageDialog(null, "Xóa SP_Xuất ko thành công");
        return 0;
    }

    @Override
    public ArrayList<Object> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static PhieuXuat getById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PhieuXuat px = null;
        String query = "SELECT * FROM phieuxuat WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                px = new PhieuXuat(
                        rs.getInt("id"),
                        rs.getDate("dateOut"),
                        rs.getFloat("sumPayment"),
                        rs.getInt("userId")
                );
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return px;
    }

    @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
