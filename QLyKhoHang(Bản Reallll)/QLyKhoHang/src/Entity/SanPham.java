/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MRSTHAO
 */
@Entity
@Table(name = "sanpham")
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s"),
    @NamedQuery(name = "SanPham.findById", query = "SELECT s FROM SanPham s WHERE s.id = :id"),
    @NamedQuery(name = "SanPham.findByName", query = "SELECT s FROM SanPham s WHERE s.name = :name"),
    @NamedQuery(name = "SanPham.findByQuantityHas", query = "SELECT s FROM SanPham s WHERE s.quantityHas = :quantityHas"),
    @NamedQuery(name = "SanPham.findByQuantityPay", query = "SELECT s FROM SanPham s WHERE s.quantityPay = :quantityPay"),
    @NamedQuery(name = "SanPham.findByPrice", query = "SELECT s FROM SanPham s WHERE s.price = :price")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity_has")
    private int quantityHas;
    @Column(name = "quantity_pay")
    private int quantityPay;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "categoty_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DanhMuc danhMuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private List<SpNhap> spNhapList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private List<SpXuat> spXuatList;

    public SanPham() {
    }

    public SanPham(Integer id) {
        this.id = id;
    }

    /*public SanPham(int aInt, String string, int aInt0, int aInt1, float aFloat, int aInt2) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.id = aInt;
        this.name = string;
        this.quantityHas = aInt0;
        this.quantityPay = aInt1;
        this.price = aFloat;
        this.
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityHas() {
        return quantityHas;
    }

    public void setQuantityHas(int quantityHas) {
        this.quantityHas = quantityHas;
    }

    public int getQuantityPay() {
        return quantityPay;
    }

    public void setQuantityPay(int quantityPay) {
        this.quantityPay = quantityPay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

     public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(int danhMuc) {
        this.danhMuc = new DanhMuc(danhMuc, null);
    }

    public List<SpNhap> getSpNhapList() {
        return spNhapList;
    }

    public void setSpNhapList(List<SpNhap> spNhapList) {
        this.spNhapList = spNhapList;
    }

    public List<SpXuat> getSpXuatList() {
        return spXuatList;
    }

    public void setSpXuatList(List<SpXuat> spXuatList) {
        this.spXuatList = spXuatList;
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
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SanPham[ id=" + id + " ]";
    }
    
}
