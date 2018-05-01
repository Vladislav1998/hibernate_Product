package model;

import javax.persistence.*;

@Entity
@Table(name = "availabitily", schema = "DB_labs")
@IdClass(AvailabitilyEntityPK.class)
public class AvailabitilyEntity {
    private int idProd;
    private int idStore;
    private Integer count;

    @Id
    @Column(name = "idProd", nullable = false)
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    @Id
    @Column(name = "idStore", nullable = false)
    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailabitilyEntity that = (AvailabitilyEntity) o;

        if (idProd != that.idProd) return false;
        if (idStore != that.idStore) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProd;
        result = 31 * result + idStore;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}
