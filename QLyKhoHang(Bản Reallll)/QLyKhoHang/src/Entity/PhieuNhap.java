/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MRSTHAO
 */
@Entity
@Table(name = "phieunhap")
@NamedQueries({
    @NamedQuery(name = "PhieuNhap.findAll", query = "SELECT p FROM PhieuNhap p"),
    @NamedQuery(name = "PhieuNhap.findById", query = "SELECT p FROM PhieuNhap p WHERE p.id = :id"),
    @NamedQuery(name = "PhieuNhap.findByDateIn", query = "SELECT p FROM PhieuNhap p WHERE p.dateIn = :dateIn"),
    @NamedQuery(name = "PhieuNhap.findBySumPayment", query = "SELECT p FROM PhieuNhap p WHERE p.sumPayment = :sumPayment")})
public class PhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sumPayment")
    private Float sumPayment;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private int userId;

    public PhieuNhap(Integer id, Date dateIn, Float sumPayment, int userId) {
        this.id = id;
        this.dateIn = dateIn;
        this.sumPayment = sumPayment;
        this.userId = userId;
    }

    public PhieuNhap() {
    }

    public PhieuNhap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Float getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(Float sumPayment) {
        this.sumPayment = sumPayment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
/*
    public List<SpNhap> getSpNhapList() {
        return spNhapList;
    }

    public void setSpNhapList(List<SpNhap> spNhapList) {
        this.spNhapList = spNhapList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<SpXuat> getSpXuatList() {
        return spXuatList;
    }

    public void setSpXuatList(List<SpXuat> spXuatList) {
        this.spXuatList = spXuatList;
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
        if (!(object instanceof PhieuNhap)) {
            return false;
        }
        PhieuNhap other = (PhieuNhap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PhieuNhap[ id=" + id + " ]";
    }
    
}
