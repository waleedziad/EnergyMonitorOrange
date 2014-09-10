package com.orange.energymonitor;

import com.orange.Dao.NodeDao;
import com.orange.domain.Node;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/DashBoard")
public class DashBoardController {
    @Autowired
    NodeDao nodeDao ;
    
    @RequestMapping("/board.htm")
    public String goToView(Model model)
    {
        
        List<Node> nodes = nodeDao.getAll();
        String current = "" ;
        String voltage = "";
        String power = "";
        for(int i =0 ;i  < nodes.size() ; i++)
        {
            current+=nodes.get(i).getCurrentAmp();
            if (i!=nodes.size()-1)current+=",";
            voltage+=nodes.get(i).getVoltage();
            if (i!=nodes.size()-1)voltage+=",";
            power+=nodes.get(i).getPower();
            if (i!=nodes.size()-1)power+=",";
        }
        
        model.addAttribute("voltage",voltage);
        model.addAttribute("current",current);
        model.addAttribute("power",power);
        return "/DashBoard/index.jsp";
    }
    
    

    
    
}
