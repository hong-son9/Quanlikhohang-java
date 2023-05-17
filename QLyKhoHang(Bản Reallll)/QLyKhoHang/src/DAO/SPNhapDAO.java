/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.Connect;
import Entity.SpNhap;
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
public abstract class SPNhapDAO implements DAOInterface<Object>{

    public static int insert(int id, int quantity_in,float price, int maSP, int maPhieuNhap) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String queryInsert="INSERT INTO SP_Nhap VALUES ("+id+","+quantity_in+","+price+","+maSP+","+maPhieuNhap+")"; 
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has + "+quantity_in+" "
                + "WHERE id = "+maSP;
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(queryInsert);
            stm.executeUpdate(queryUpdateSP);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static int update(int id, int quantity_in,float price, int maSP , int maPhieuNhap) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query ="UPDATE SP_Nhap "
                + "SET quantity_in = "+quantity_in+", "
                + "price = "+price+" "
                + "WHERE id = "+id;
        SpNhap SPNhapOld = getById(id);
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has - "+SPNhapOld.getQuantityIn()+" + "+quantity_in+" "
                + "WHERE id = "+maSP+";";
        String queryUpdatePhieuNhap="Update phieunhap " +
            "SET sumPayment = (SELECT SUM(price) FROM SP_Nhap WHERE maPhieuNhap = "+maPhieuNhap+") " +
            "WHERE id = "+maPhieuNhap;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(queryUpdateSP);
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdatePhieuNhap);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static int deleteById(int id, int maPhieuNhap) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        SpNhap delSP_Nhap = getById(id);
        int quantity_in = delSP_Nhap.getQuantityIn();
        int maSP = delSP_Nhap.getMaSP();
        String query = "DELETE FROM SP_Nhap WHERE id = "+id;
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has - "+quantity_in+" "
                + "WHERE id = "+maSP+";";
        String queryUpdatePhieuNhap="Update phieunhap " +
            "SET sumPayment = (SELECT SUM(price) FROM SP_Nhap WHERE maPhieuNhap = "+maPhieuNhap+") " +
            "WHERE id = "+maPhieuNhap;
                
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdateSP);
            stm.executeUpdate(queryUpdatePhieuNhap);
            return 1;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    public static int deleteByMaPhieuNhap(int maPhieuNhap) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "DELETE FROM sp_nhap WHERE maPhieuNhap = "+maPhieuNhap;
        String queryUpdatePhieuNhap="UPDATE phieunhap "
                + "SET sumPayment = 0 "
                + "WHERE id = "+maPhieuNhap+";";
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdatePhieuNhap);
            return 1;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Object> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static SpNhap getById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        SpNhap sp_pn = null;
        String query = "SELECT * FROM sp_nhap WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                sp_pn = new SpNhap(
                        rs.getInt("id"),
                        rs.getInt("quantity_in"),
                        rs.getInt("price"),
                        rs.getInt("maSP"),
                        rs.getInt("maPhieuNhap")
                );
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return sp_pn;
    }

    @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static int getQuantity_inById(int id){
        int quantity_in = 0;
        String query = "SELECT quantity_in  from sp_nhap WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                quantity_in = rs.getInt("quantity_in");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return quantity_in;
    }
    
}
