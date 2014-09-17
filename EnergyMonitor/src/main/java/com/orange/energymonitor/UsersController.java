package com.orange.energymonitor;

import com.orange.Dao.UserDao;
import com.orange.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Users")
public class UsersController {
    
    @Autowired
    UserDao userDao ;
    @RequestMapping(value="getUsers.htm",method = RequestMethod.GET)
    public String getAllUsers(Model model)
    {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "users";
    }
    
}
