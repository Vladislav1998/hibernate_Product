package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "supply", schema = "DB_labs")
public class SupplyEntity {
    private int idSupply;
    private Timestamp dateOfSupply;
    private int idProd;
    private int idSupplier;
    private int idStore;
    private int count;

    @Id
    @Column(name = "idSupply", nullable = false)
    public int getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(int idSupply) {
        this.idSupply = idSupply;
    }

    @Basic
    @Column(name = "dateOfSupply", nullable = false)
    public Timestamp getDateOfSupply() {
        return dateOfSupply;
    }

    public void setDateOfSupply(Timestamp dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }

    @Basic
    @Column(name = "idProd", nullable = false)
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    @Basic
    @Column(name = "idSupplier", nullable = false)
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Basic
    @Column(name = "idStore", nullable = false)
    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplyEntity that = (SupplyEntity) o;

        if (idSupply != that.idSupply) return false;
        if (idProd != that.idProd) return false;
        if (idSupplier != that.idSupplier) return false;
        if (idStore != that.idStore) return false;
        if (count != that.count) return false;
        if (dateOfSupply != null ? !dateOfSupply.equals(that.dateOfSupply) : that.dateOfSupply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSupply;
        result = 31 * result + (dateOfSupply != null ? dateOfSupply.hashCode() : 0);
        result = 31 * result + idProd;
        result = 31 * result + idSupplier;
        result = 31 * result + idStore;
        result = 31 * result + count;
        return result;
    }
}
