package com.orange.energymonitor;

import com.orange.*;
import com.orange.Dao.NodeDao;
import com.orange.domain.Node;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Input")
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@Transactional
public class InputController {
    @Autowired
    NodeDao nodeDao ;
    
    
    @RequestMapping(value = "NodeInput.htm",method = RequestMethod.GET)
    public void AcceptInput (
            @RequestParam("apikey") int apikey, 
            @RequestParam("voltage") double voltage,
            @RequestParam("current") double current,
            @RequestParam("power") double Power,
            @RequestParam("apparentPower") double apparentPower,
            @RequestParam("powerFactor") double powerFactor ,
            HttpServletResponse response) throws Exception
    {
        Node node = new Node(apikey, voltage, current, Power, apparentPower, powerFactor);
        nodeDao.insert(node);
        response.getWriter().write("ACK"+apikey+" "+voltage+" "+current+" "
                +Power+" "+apparentPower+" "+powerFactor);
    }
    
}
