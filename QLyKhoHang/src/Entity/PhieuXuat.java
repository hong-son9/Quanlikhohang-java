/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MRSTHAO
 */
@Entity
@Table(name = "phieuxuat")
@NamedQueries({
    @NamedQuery(name = "PhieuXuat.findAll", query = "SELECT p FROM PhieuXuat p"),
    @NamedQuery(name = "PhieuXuat.findById", query = "SELECT p FROM PhieuXuat p WHERE p.id = :id"),
    @NamedQuery(name = "PhieuXuat.findByDateOut", query = "SELECT p FROM PhieuXuat p WHERE p.dateOut = :dateOut"),
    @NamedQuery(name = "PhieuXuat.findBySumPayment", query = "SELECT p FROM PhieuXuat p WHERE p.sumPayment = :sumPayment")})
public class PhieuXuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateOut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sumPayment")
    private Float sumPayment;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private int userId;

    public PhieuXuat() {
    }

    public PhieuXuat(Integer id) {
        this.id = id;
    }

    public PhieuXuat(int aInt, Date date, float aInt0, int aInt1) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.id = aInt;
        this.dateOut = date;
        this.sumPayment = aInt0;
        this.userId = aInt1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
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

    public void setUserId(int userid) {
        this.userId = userid;
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
        if (!(object instanceof PhieuXuat)) {
            return false;
        }
        PhieuXuat other = (PhieuXuat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PhieuXuat[ id=" + id + " ]";
    }
    
}
