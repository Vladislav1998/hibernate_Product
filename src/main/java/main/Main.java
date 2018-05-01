package main;

import dao.HibernateSessionFactory;
import model.ProductEntity;
import org.hibernate.Session;

public class Main {
    public static void main(String... args){
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ProductEntity prod = new ProductEntity();
        prod.setDescription("Hibernate");
        prod.setTitle("h");

        session.save(prod);
        session.getTransaction().commit();

        session.close();
    }
}
