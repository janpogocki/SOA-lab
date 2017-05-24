package com.lab8;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 24.05.2017.
 */
public class TableSQL {
    private List<BooksEntity> listOfBooks;

    public List<BooksEntity> getTableSQL(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addClass(BooksEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        listOfBooks = new ArrayList<>();

        Query query = session.createQuery("from BooksEntity ");

        for (int i=0; i<query.list().size(); i++){
            listOfBooks.add((BooksEntity) query.list().get(i));
        }

        session.close();

        return listOfBooks;
    }

    public BooksEntity getBook(int id){
        for (int i=0; i<listOfBooks.size(); i++){
            BooksEntity temp = listOfBooks.get(i);

            if (temp.getId() == id)
                return listOfBooks.get(i);
        }

        return null;
    }

    public void deleteBook(int id){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addClass(BooksEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setId(id);
        session.delete(booksEntity);
        tx.commit();
        session.close();
    }

    public void updateBook(BooksEntity book){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addClass(BooksEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }

    public void saveBook(BooksEntity book){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addClass(BooksEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();

        session.close();
    }
}
