package com.hcl.spring.boot.training.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.spring.boot.training.service.UserService;
import com.hcl.spring.model.User;

@RestController
@RequestMapping("/")
public class UsersController {
	private static final Logger logger = LogManager.getLogger(UsersController.class.getName());
	ObjectMapper objectMapper= new ObjectMapper(); 
	@Autowired
	private UserService userService;
	   
	@RequestMapping(value = "customer/create", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody User user) throws JsonProcessingException {
		long start = System.currentTimeMillis();  
		logger.info("Operation:New Customer"+",RequestData:"+objectMapper.writeValueAsString(user));
		try{
			 user=userService.createUser(user);
			 logger.info("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,Operation:New Customer"+",Response:"+objectMapper.writeValueAsString(user));
			return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception ex) {
			 logger.error("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,Operation:New Customer"+",Exception:"+ex);
		      return new ResponseEntity<String>("Error create the user: " + ex.toString(),HttpStatus.BAD_REQUEST);
		    }
		
	}
	
	@RequestMapping(value ="customer/delete/{userId}", method = RequestMethod.DELETE)
	  public ResponseEntity<?> delete( @PathVariable("userId") String id) {
		long start = System.currentTimeMillis(); 
	    try {
	    	logger.info("Operation:Delete"+",RequestData:"+id);
	      User user = new User(Long.parseLong(id));
	      userService.delete(user);
	    }
	    catch (Exception ex) {
	      return new ResponseEntity<String>("Error deleting the user: " + ex.toString(),HttpStatus.BAD_REQUEST);
	    }
	    logger.info("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,Operation:Delete"+",Response:"+"User succesfully updated!");
	    return new ResponseEntity<String>("User succesfully deleted!",HttpStatus.OK);
	  }
	@RequestMapping(value ="customer/{id}",method = RequestMethod.GET)
	  
	  public ResponseEntity<?> getById(@PathVariable("id") String id) {
	    String userId;
	    long start = System.currentTimeMillis(); 
	    try {
	    	logger.info("Operation:Fetch"+",RequestData:"+id);
	      User user = userService.findOne(Long.parseLong(id));
	      userId = String.valueOf(user.getId());
	     
	    }
	    catch (Exception ex) {
	    	logger.error("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,operation:Fetch"+",Exception:"+ex);
	      return new ResponseEntity<String>("User not found"+ ex.toString(),HttpStatus.BAD_REQUEST);
	    }
	    logger.info("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,operation:Fetch"+",Response:"+userId);
	    return new ResponseEntity<String>("The user id is: " + userId,HttpStatus.OK);
	  }
	@RequestMapping(value="customer/update" ,method = RequestMethod.POST)
	  
	  public ResponseEntity<?> updateUser(@RequestBody User updateUser) {
		long start = System.currentTimeMillis(); 
	    try {
	    	logger.info("Operation:Update"+",RequestData:"+objectMapper.writeValueAsString(updateUser));
	      User user = userService.findOne(updateUser.getId());
	      user.setEmail(updateUser.getEmail());
	      userService.save(user);
	    }
	    catch (Exception ex) {
	    	logger.error("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,operation:Update"+",Exception:"+ex);
	    	return new ResponseEntity<String>("Error updating the user: " + ex.toString(),HttpStatus.BAD_REQUEST);
	     
	    }
	    logger.info("ResponseTime:"+(System.currentTimeMillis() - start)+"ms,,operation:update-customer"+",Response:"+"User succesfully updated!");
	    return new ResponseEntity<String>( "User succesfully updated!",HttpStatus.OK);
	    
	  }
}
