package com.orange.Dao;

import com.orange.domain.Node;
import com.orange.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDao {
    
    @PersistenceContext
    EntityManager entityManager ;

    public List<User> getAll()
    {
         List<User> result = entityManager.createQuery("from User ").getResultList();
       return result ;
    }
    
}
