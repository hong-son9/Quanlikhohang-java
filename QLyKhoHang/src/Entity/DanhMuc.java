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
@Table(name = "danhmuc")
@NamedQueries({
    @NamedQuery(name = "DanhMuc.findAll", query = "SELECT d FROM DanhMuc d"),
    @NamedQuery(name = "DanhMuc.findById", query = "SELECT d FROM DanhMuc d WHERE d.id = :id"),
    @NamedQuery(name = "DanhMuc.findByCategpryName", query = "SELECT d FROM DanhMuc d WHERE d.categpryName = :categpryName")})
public class DanhMuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "categpry_name")
    private String categpryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "danhMuc")
    private List<SanPham> sanPhamList;

    public DanhMuc() {
    }

    public DanhMuc(Integer id, String categpry_name) {
        this.id = id;
        this.categpryName = categpry_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategpryName() {
        return categpryName;
    }

    public void setCategpryName(String categpryName) {
        this.categpryName = categpryName;
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhMuc)) {
            return false;
        }
        DanhMuc other = (DanhMuc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DanhMuc[ id=" + id + " ]";
    }
    
}
