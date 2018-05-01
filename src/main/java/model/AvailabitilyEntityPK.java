package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AvailabitilyEntityPK implements Serializable {
    private int idProd;
    private int idStore;

    @Column(name = "idProd", nullable = false)
    @Id
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    @Column(name = "idStore", nullable = false)
    @Id
    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailabitilyEntityPK that = (AvailabitilyEntityPK) o;

        if (idProd != that.idProd) return false;
        if (idStore != that.idStore) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProd;
        result = 31 * result + idStore;
        return result;
    }
}
