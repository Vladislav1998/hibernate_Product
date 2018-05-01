package model;

import javax.persistence.*;

@Entity
@Table(name = "store", schema = "DB_labs")
public class StoreEntity {
    private int idStore;
    private String title;
    private String address;
    private int currentCountOfProduct;

    @Id
    @Column(name = "idStore", nullable = false)
    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 20)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "currentCountOfProduct", nullable = false)
    public int getCurrentCountOfProduct() {
        return currentCountOfProduct;
    }

    public void setCurrentCountOfProduct(int currentCountOfProduct) {
        this.currentCountOfProduct = currentCountOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (idStore != that.idStore) return false;
        if (currentCountOfProduct != that.currentCountOfProduct) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStore;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + currentCountOfProduct;
        return result;
    }
}
