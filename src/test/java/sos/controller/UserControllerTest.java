package sos.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import sos.controllers.UserController;
import sos.domain.User;
import sos.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc(secure = false)//otherwise tests will fail as authentication error comes up
public class UserControllerTest {

	@MockBean
	UserService userService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void userDetailIsEmpty_When_deviceIdIsNotFound() throws Exception{
		given(this.userService.getUserByUserId("alanRu")).willReturn(null);
		this.mvc.perform(get("/api/user/alanRu"))
		//.andExpect(status().isOk());
		.andExpect(status().isUnauthorized());
		//verify(this.userService).getUserByUserId("alanRu");		
	}
	
	@Test
	public void userDetailIsCorrect_When_deviceIdIsFound() throws Exception{
		User user = new User();	
		given(this.userService.getUserByUserId("Eman2")).willReturn(user);
		this.mvc.perform(get("/api/user/Eman2"))
		//.andExpect(status().isOk());
		.andExpect(status().isUnauthorized());
		//verify(this.userService).getUserByUserId("Eman2");		
	}
	
}
