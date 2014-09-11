package orange.energymonitor;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.Assert;
import static org.hamcrest.Matchers.containsString;

@WebAppConfiguration
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class InputControllerTest {
    
    @Autowired
    MockHttpSession session;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void AcceptInputTest() throws Exception
    {
        mockMvc.perform(get("/Input/NodeInput.htm?apikey=13"
                + "&voltage=220"
                + "&current=70&power=50&apparentPower=60&"
                + "powerFactor=12"))
                .andExpect(status().isOk())
                .andExpect(content().string("ACK13 220.0 70.0 50.0 60.0 12.0"));
    }
    @Test
    public void goToViewTest() throws Exception
    {
        MvcResult result =mockMvc.perform(get("/DashBoard/board.htm")).andExpect(status().isOk())
                .andExpect(view().name("EnergyMonitor/index")).andExpect(model().attributeExists("current"))
                .andReturn();
        MockHttpServletRequest httpServletRequest = result.getRequest();
        Assert.isInstanceOf(String.class, httpServletRequest.getAttribute("current"));
        
    }
    
}
