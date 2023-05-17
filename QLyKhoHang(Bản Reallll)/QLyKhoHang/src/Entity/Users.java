/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MRSTHAO
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUser", query = "SELECT u FROM Users u WHERE u.user = :user"),
    @NamedQuery(name = "Users.findByCurrentConnections", query = "SELECT u FROM Users u WHERE u.currentConnections = :currentConnections"),
    @NamedQuery(name = "Users.findByTotalConnections", query = "SELECT u FROM Users u WHERE u.totalConnections = :totalConnections"),
    @NamedQuery(name = "Users.findByMaxSessionControlledMemory", query = "SELECT u FROM Users u WHERE u.maxSessionControlledMemory = :maxSessionControlledMemory"),
    @NamedQuery(name = "Users.findByMaxSessionTotalMemory", query = "SELECT u FROM Users u WHERE u.maxSessionTotalMemory = :maxSessionTotalMemory"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role"),
    @NamedQuery(name = "Users.findByFullname", query = "SELECT u FROM Users u WHERE u.fullname = :fullname"),
    @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")})
public class Users implements Serializable {
    /*
    private static final long serialVersionUID = 1L;
    @Column(name = "USER")
    private String user;
    @Basic(optional = false)
    @Column(name = "CURRENT_CONNECTIONS")
    private long currentConnections;
    @Basic(optional = false)
    @Column(name = "TOTAL_CONNECTIONS")
    private long totalConnections;
    @Basic(optional = false)
    @Column(name = "MAX_SESSION_CONTROLLED_MEMORY")
    private long maxSessionControlledMemory;
    @Basic(optional = false)
    @Column(name = "MAX_SESSION_TOTAL_MEMORY")
    private long maxSessionTotalMemory;*/
    @Id
    //@Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Integer role;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<PhieuXuat> phieuXuatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<PhieuNhap> phieuNhapList;*/

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, Integer role, String fullname, String address, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
    }


    /*public Users(Integer id, long currentConnections, long totalConnections, long maxSessionControlledMemory, long maxSessionTotalMemory) {
        this.id = id;
        this.currentConnections = currentConnections;
        this.totalConnections = totalConnections;
        this.maxSessionControlledMemory = maxSessionControlledMemory;
        this.maxSessionTotalMemory = maxSessionTotalMemory;
    }*/
    /*
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(long currentConnections) {
        this.currentConnections = currentConnections;
    }

    public long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(long totalConnections) {
        this.totalConnections = totalConnections;
    }

    public long getMaxSessionControlledMemory() {
        return maxSessionControlledMemory;
    }

    public void setMaxSessionControlledMemory(long maxSessionControlledMemory) {
        this.maxSessionControlledMemory = maxSessionControlledMemory;
    }

    public long getMaxSessionTotalMemory() {
        return maxSessionTotalMemory;
    }

    public void setMaxSessionTotalMemory(long maxSessionTotalMemory) {
        this.maxSessionTotalMemory = maxSessionTotalMemory;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*
    public List<PhieuXuat> getPhieuXuatList() {
        return phieuXuatList;
    }

    public void setPhieuXuatList(List<PhieuXuat> phieuXuatList) {
        this.phieuXuatList = phieuXuatList;
    }

    public List<PhieuNhap> getPhieuNhapList() {
        return phieuNhapList;
    }

    public void setPhieuNhapList(List<PhieuNhap> phieuNhapList) {
        this.phieuNhapList = phieuNhapList;
    }
    */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Users[ id=" + id + " ]";
    }
    
}
