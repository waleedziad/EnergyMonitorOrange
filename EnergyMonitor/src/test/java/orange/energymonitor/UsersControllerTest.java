package orange.energymonitor;

import com.orange.domain.User;
import java.util.List;
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
public class UsersControllerTest {
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
    public void getAllUsersTest()throws Exception
    {
        MvcResult result =mockMvc.perform( get("/Users/getUsers.htm") ).andExpect(status().isOk())
                .andExpect(view().name("users")).andExpect(model().attributeExists("users"))
                .andReturn();
        MockHttpServletRequest httpServletRequest = result.getRequest();
        Assert.isInstanceOf(List.class , httpServletRequest.getAttribute("users"));
    }
}
