package com.orange.Dao;

import com.orange.domain.Node;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
@Repository("nodeDao")
public class NodeDao {
     
    @PersistenceContext
    EntityManager entityManager ;
    
    public Node insert(Node node)
    {
        System.out.println("in insert fun : ");
        System.out.println(entityManager.getProperties().toString());
        if (entityManager == null)
            System.out.println("em is null");
        entityManager.persist(node);
        return node ;
    }

    public List<Node> getAll() {
       List<Node> result = entityManager.createQuery("from Node ").getResultList();
       return result ;
    }
    
    
}
