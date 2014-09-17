package orange.energymonitor;

import com.orange.Dao.UserDao;
import com.orange.domain.User;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    
    @Autowired
    UserDao userDao ;
    
    @Test
    public void testGetAll() throws Exception
    {
       List<User> users = userDao.getAll();
       
       if (users.isEmpty())throw new Exception();//make sure the database itself is not empty
       assert(true) : users.toString();
    }
    
}
