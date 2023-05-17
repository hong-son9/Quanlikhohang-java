/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.*;
import ConnectDatabase.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MRSTHAO
 */
public abstract class DanhMucDAO implements DAOInterface<Object> {

    public int insert(int id, String username, String password, int role, String fullname,String address, String phone) {
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

   public static boolean insertSanPham(DanhMuc danhmuc) {
        String query = "INSERT INTO danhmuc (id, categpry_name) VALUES (?, ?)";
        Connection connection = Connect.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, danhmuc.getId());
            statement.setString(2, danhmuc.getCategpryName());
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
   
  public static int getIdDanhMuc(String category_name) {
    String query = "SELECT id FROM danhmuc WHERE categpry_name = ?";
    int id = 0;
    try (Connection cnt = Connect.getConnection();
         PreparedStatement stm = cnt.prepareStatement(query)) {
        stm.setString(1, category_name);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }
    } catch (SQLException e) {
        // Handle the exception appropriately
    }
    return id;
}
  
   public static String getNameDanhMuc(int id) {
    String query = "SELECT categpry_name FROM danhmuc WHERE id = ?";
    String name = null;
    try (Connection cnt = Connect.getConnection();
         PreparedStatement stm = cnt.prepareStatement(query)) {
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            name = rs.getString("categpry_name");
        }
    } catch (SQLException e) {
        // Handle the exception appropriately
    }
    return name;
}
   
    public static List<DanhMuc> getDanhMuc() {
        List<DanhMuc> danhMucList = new ArrayList<>();
        String query = "SELECT id, categpry_name FROM danhmuc";
        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                danhMucList.add(new DanhMuc(
                rs.getInt("id"),
                rs.getString("categpry_name")
                ));
            }
        } catch (SQLException e) {
        System.err.println("Error fetching danh muc: " + e.getMessage());
    }
        return danhMucList;
    }
    
    public static boolean deleteProduct(int id) {
        String query = "DELETE FROM danhmuc WHERE id = ?";
        Connection connection = Connect.getConnection();

        try {
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            
            // kiểm tra xem có xóa được sản phẩm hay không
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Xóa danh mục thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa danh mục thất bại do không tìm thấy ID", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Xóa danh mục thất bại do ID này đang được dùng cho sản phẩm ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
}
    
    public static boolean updateProduct(int id, String name) {
        String query = "UPDATE danhmuc SET categpry_name = ? WHERE id = ?";
        Connection connection = Connect.getConnection();

        try {
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1, name);
             statement.setInt(2, id);
            
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
}
