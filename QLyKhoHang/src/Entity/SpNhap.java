/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MRSTHAO
 */
@Entity
@Table(name = "sp_nhap")
@NamedQueries({
    @NamedQuery(name = "SpNhap.findAll", query = "SELECT s FROM SpNhap s"),
    @NamedQuery(name = "SpNhap.findById", query = "SELECT s FROM SpNhap s WHERE s.id = :id"),
    @NamedQuery(name = "SpNhap.findByQuantityIn", query = "SELECT s FROM SpNhap s WHERE s.quantityIn = :quantityIn"),
    @NamedQuery(name = "SpNhap.findByPrice", query = "SELECT s FROM SpNhap s WHERE s.price = :price")})
public class SpNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity_in")
    private Integer quantityIn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private int price;
    /*@JoinColumn(name = "maPhieuNhap", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PhieuNhap phieuNhap;
    @JoinColumn(name = "maSP", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SanPham sanPham;*/
    private int maSP;
    private int maPhieuNhap;

    public SpNhap(Integer id, Integer quantityIn, int price, int maSP, int maPhieuNhap) {
        this.id = id;
        this.quantityIn = quantityIn;
        this.price = price;
        this.maSP = maSP;
        this.maPhieuNhap = maPhieuNhap;
    }
    
    public SpNhap() {
    }

    public SpNhap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityIn() {
        return quantityIn;
    }

    public void setQuantityIn(Integer quantityIn) {
        this.quantityIn = quantityIn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    
/*
    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
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
        if (!(object instanceof SpNhap)) {
            return false;
        }
        SpNhap other = (SpNhap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SpNhap[ id=" + id + " ]";
    }
    
}
