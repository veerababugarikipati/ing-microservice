package com.hcl.spring.boot.training.controllersTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.spring.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersControllerTest {

	
	@Autowired
    private TestRestTemplate restTemplate;
	@Test
    public void createUserTest() {
        ResponseEntity<User> responseEntity =
            restTemplate.postForEntity("/customer/create", new User(1,"veera","veerababu.g@hcl.com"), User.class);
        User user = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("veera", user.getName());
    }
	@Test
    public void deleteUserTest() {
		restTemplate.delete("/customer/delete/1");
    }
	@Test
    public void getUserByIdTestFail() {
		restTemplate.getForEntity("/customer/1",User.class);
		
    }
	
	/*@Test
    public void updateUserTest() {
		restTemplate.postForEntity("/customer/update", new User(1,"veera","veerababu.g@hcl.com"), User.class);
		
    }*/
	
}
