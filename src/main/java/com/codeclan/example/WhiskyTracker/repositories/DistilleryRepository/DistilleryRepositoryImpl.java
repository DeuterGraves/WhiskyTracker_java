package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sun.text.normalizer.ReplaceableString;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    TODO: Write queries here:
//    get all the distilleries for a particular region
    @Transactional
    public List<Distillery> findAllDistilleriesInRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
/*
    //  get all the whisky from a particular distillery that's a specific age (if the whisky has a specific age)

    @Transactional
    public List<Whisky> findAllWhiskiesFromDistilleryOfAge(Long distilleryId, int age){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);
        cr.add(Restrictions.eq("id", distilleryId));
//        now in disilleries look for the age of the whiskies
        cr.createAlias("whiskies", "whisky");
        cr.add(Restrictions.eq("whisky.age", age));
        results = cr.list();
        return results;
    }
*/

//     Get distilleries that have whiskies that are 12 years old
}
