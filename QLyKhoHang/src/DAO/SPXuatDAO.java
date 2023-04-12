/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.Connect;
import Entity.SpXuat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MRSTHAO
 */
public abstract class SPXuatDAO implements DAOInterface<Object>{


    public static int insert(int id, int quantity_in,float price, int maSP, int maPhieuXuat) {
        //throw new UnsupportedOperationException("Not supported yet.");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String queryInsert="INSERT INTO SP_Xuat VALUES ("+id+","+quantity_in+","+price+","+maSP+","+maPhieuXuat+")"; 
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has - "+quantity_in+", "
                + "quantity_pay = quantity_pay + "+quantity_in+" "
                + "WHERE id = "+maSP+";";
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

    
    public static int update(int id, int quantity_in,float price, int maSP, int maPhieuXuat) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query ="UPDATE SP_Xuat "
                + "SET quantity_in = "+quantity_in+", "
                + "price = "+price+" "
                + "WHERE id = "+id;
        SpXuat SPXuatOld = getById(id);
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has + "+SPXuatOld.getQuantityIn()+" - "+quantity_in+", "
                + "quantity_pay = quantity_pay - "+SPXuatOld.getQuantityIn()+" + "+quantity_in+" "
                + "WHERE id = "+maSP+";";
        String queryUpdatePhieuXuat="Update phieuxuat " +
            "SET sumPayment = (SELECT SUM(price) FROM SP_Xuat WHERE maPhieuXuat = "+maPhieuXuat+") " +
            "WHERE id = "+maPhieuXuat;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(queryUpdateSP);
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdatePhieuXuat);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    
    public static int deleteById(int id,int maPhieuXuat){
        SpXuat delSP_Xuat = getById(id);
        int quantity_in = delSP_Xuat.getQuantityIn();
        int maSP = delSP_Xuat.getMaSP();
        String query = "DELETE FROM SP_Xuat WHERE id = "+id;
        String queryUpdateSP="UPDATE sanpham "
                + "SET quantity_has = quantity_has + "+quantity_in+", "
                + "quantity_pay = quantity_pay - "+quantity_in+" "
                + "WHERE id = "+maSP+";";
        String queryUpdatePhieuXuat="Update phieuxuat " +
            "SET sumPayment = (SELECT SUM(price) FROM SP_Xuat WHERE maPhieuXuat = "+maPhieuXuat+") " +
            "WHERE id = "+maPhieuXuat;
                
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdateSP);
            stm.executeUpdate(queryUpdatePhieuXuat);
            return 1;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    
    //Dùng để xóa dữ liệu Phiếu Xuất
    public static int deleteByMaPhieuXuat(int maPhieuXuat) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "DELETE FROM sp_xuat WHERE maPhieuXuat = "+maPhieuXuat;
        String queryUpdatePhieuXuat="UPDATE phieuxuat "
                + "SET sumPayment = 0 "
                + "WHERE id = "+maPhieuXuat+";";
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            stm.executeUpdate(query);
            stm.executeUpdate(queryUpdatePhieuXuat);
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

    public static SpXuat getById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        SpXuat sp_px = null;
        String query = "SELECT * FROM sp_xuat WHERE id = "+id;
        try{
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                sp_px = new SpXuat(
                        rs.getInt("id"),
                        rs.getInt("quantity_in"),
                        rs.getInt("price"),
                        rs.getInt("maSP"),
                        rs.getInt("maPhieuXuat")
                );
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return sp_px;
    }

    @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static int getQuantity_inById(int id){
        int quantity_in = 0;
        String query = "SELECT quantity_in  from sp_xuat WHERE id = "+id;
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
