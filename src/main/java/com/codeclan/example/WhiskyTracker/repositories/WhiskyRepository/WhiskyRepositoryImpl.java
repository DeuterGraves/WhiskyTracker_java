package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    TODO: Queries here

    //    get all the whiskies for a particular year
    @Transactional
    public List<Whisky> findAllWhiskiesForYear(int year){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }



    //get all the whisky from a particular region
    @Transactional
    public List<Whisky> findAllWhiskiesFrom(String region){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.region", region));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> findAllWhiskiesFromDistilleryOfAge(Long distilleryId, int age){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.add(Restrictions.eq("distillery.id", distilleryId));
//        now in disilleries look for the age of the whiskies
        cr.createAlias("whiskies", "whisky");
        cr.add(Restrictions.eq("whisky.age", age));
        results = cr.list();
        return results;
    }

}
