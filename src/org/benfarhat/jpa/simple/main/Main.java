package org.benfarhat.jpa.simple.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.benfarhat.jpa.simple.model.Car;


public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "cars";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("SELECT c FROM Car c ORDER BY c.price DESC");
        List<Car> carList = q.getResultList();
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println("Number of Cars: " + carList.size());

        // create new car
        em.getTransaction().begin();
        Car car = new Car();
        car.setName(Util.generateName());
        car.setPrice(Util.generatePrice(10000, 100000));
        em.persist(car);
        em.getTransaction().commit();

        em.close();
    }
}