/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package orange.energymonitor;



import com.orange.Dao.NodeDao;
import com.orange.domain.Node;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sony
 */
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeDaoTest {
   
    @Autowired
    NodeDao nodeDao ;
   
   @Test
   public void testInsert()
   {
       Node node = new Node((int)(Math.random()*1000)%1000,220.1,60.3,50.4,60.1,12.1);
       nodeDao.insert(node);
   }
   @Test
    public void testGetAll()
    {
        List<Node> list = nodeDao.getAll() ;
        assert(true) : list.toString();
       
    }
    
    
}
