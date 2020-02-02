package com.example.repository;

import com.example.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List findAll() {
        String jql = "SELECT u FROM Customer u";
        return entityManager.createQuery(jql, Customer.class).getResultList();
    }

    public int removeCustomerById(Customer customer) {
        entityManager.remove(customer);
        return customer.getId();
    }

    public Customer findCustomerById(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List findCustomerByName(String name) {
        String jql = "SELECT u FROM Customer u WHERE u.name = :name ";
        Query query = entityManager.createQuery(jql, Customer.class);
        return query.setParameter("name", name).getResultList();
    }

    public Customer findNameAndAddress(String name, String address) {
        String jql = "SELECT u FROM Customer u WHERE u.name = :name AND u.address = :address";
        Query query = entityManager.createQuery(jql, Customer.class);
        query.setParameter("name", name);
        query.setParameter("address", address);
        return (Customer) query.getSingleResult();
    }
}
