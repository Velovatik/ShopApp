package com.velov.shop.shopapp.dao;

import com.velov.shop.shopapp.entity.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository //Annotation for DAO registration in Spring Container
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private EntityManager entityManager; //JPA best practice SessionFactory -> EntityManager

    @Override
    @Transactional //For managing hibernate transaction lifecycle
    public List<Item> getAllItems() { //Method completed
        Session session = entityManager.unwrap(Session.class); //Get Hibernate session with unwrap() method

        Query<Item> query = session.createQuery("from Item",
                Item.class);
        List<Item> allItems = query.getResultList();

        return allItems;
    }

    @Override
    public void saveItem(Item item) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(item);
    }

    @Override
    public Item getItem(int id) {
        Session session = entityManager.unwrap(Session.class);

        Item item = session.get(Item.class, id);
        return item;
    }

    @Override
    public void deleteItem(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Item> query = session.createQuery("delete from Item " +
//                "where id =:Id");
//        query.setParameter("Id", id);
//        query.executeUpdate();
    }
}
