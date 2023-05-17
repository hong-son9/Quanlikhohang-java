/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.Connect;
import Entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MRSTHAO
 */
public  class SanPhamDAO implements DAOInterface<Object>{

    @Override
    public int insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object selectById(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static int getIdByName(String name){
        int Id = -1;
        String query = "SELECT * FROM sanpham WHERE name = N'"+name+"'";
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Id = rs.getInt("id");
            }return Id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return Id;
    }
    public static int getPriceById(int id){
        int price = 0;
        String query = "SELECT price FROM sanpham WHERE id = "+id;
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                price = rs.getInt("price");
            }return price;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return price;
    }
    public static int getQuantity_hasById(int id){
        int quantity_has = 0;
        String query = "SELECT quantity_has FROM sanpham WHERE id = "+id;
        try {
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                quantity_has = rs.getInt("quantity_has");
            }return quantity_has;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return quantity_has;
    }
    
    public static boolean insertSanPham(SanPham sanpham) {
        String query = "INSERT INTO sanpham (id, name, quantity_has, quantity_pay, price, categoty_id) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = Connect.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sanpham.getId());
            statement.setString(2, sanpham.getName());
            statement.setObject(3, sanpham.getQuantityHas());
            statement.setObject(4, sanpham.getQuantityPay());
            statement.setFloat(5, sanpham.getPrice());
            statement.setObject(6, sanpham.getDanhMuc().getId());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
    }
     
     public static boolean updateProduct(int id, String name, int quantity_has, int quantity_pay, int price, int categoty_id) {
        String query = "UPDATE sanpham SET name = ?, quantity_has = ?, quantity_pay = ?, price = ?, categoty_id = ? WHERE id = ?";
        Connection connection = Connect.getConnection();

        try {
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1, name);
             statement.setInt(2, quantity_has);
             statement.setInt(3, quantity_pay);
             statement.setDouble(4, price);
             statement.setInt(5, categoty_id);
             statement.setInt(6, id);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
}
     
      public static boolean deleteProduct(int id) {
        String query = "DELETE FROM sanpham WHERE id = ?";
        Connection connection = Connect.getConnection();

        try {
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            
            // kiểm tra xem có xóa được sản phẩm hay không
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại do không tìm thấy ID", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
}
    
}
