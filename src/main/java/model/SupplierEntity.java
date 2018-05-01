package model;

import javax.persistence.*;

@Entity
@Table(name = "supplier", schema = "DB_labs")
public class SupplierEntity {
    private int idSupplier;
    private String name;

    @Id
    @Column(name = "idSupplier", nullable = false)
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierEntity that = (SupplierEntity) o;

        if (idSupplier != that.idSupplier) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSupplier;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
