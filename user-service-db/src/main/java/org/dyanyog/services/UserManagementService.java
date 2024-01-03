package org.dyanyog.services;

import java.util.List;
import java.util.Optional;

import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.dyanyog.dto.User;
import org.dyanyog.dto.UserRequest;
import org.dyanyog.dto.ProductResponse;
import org.dyanyog.entity.Users;
import org.dyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserManagementService {

	@Autowired
	UserRepository userRepo;
	
	public LoginResponse validate (@RequestBody LoginRequest loginRequest)
	{
		LoginResponse response = new LoginResponse();
		Users u = new Users();
		List<User> liUser= userRepo.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
			
		
		if(liUser.size()==1) {
			
			
				u.setStatus("success");
				response.setMessage("Login successful");
				
			}else {

				response.setStatus("fail");
				response.setMessage("Login failure");
			      }
				

	

        return response;
	}
	
	
	
	public ProductResponse addUser(UserRequest userRequest)
	{
		ProductResponse responce = new ProductResponse();
		
		Users u = new Users();
		
		u.setUsername(userRequest.getUsername());
		u.setPassword(userRequest.getPassword());
		u.setEmail(userRequest.getEmail());
		u.setAge(userRequest.getAge());
		
		u =userRepo.save(u);
		
		responce.setStatus("Success");
		responce.setMessage("user added successfully");
		responce.setUser_id(u.getUser_id());
		
		return responce;
	}


    
	public User getSingleUser(long userId) {
    	
    	User userResponse = new User();
    	
    	java.util.Optional<Users> receiveData = userRepo.findById(userId);
    	
    
		if( receiveData.isEmpty()) {
    		userResponse.setStatus("Fail");
    		userResponse.setMessage("User not found");
    	}else
    	{
    		Users user = (Users) receiveData.get();
    		userResponse.setStatus("success");
    		userResponse.setMessage("user found");
    
    		userResponse.setUsername(user.getUsername());
    		userResponse.setPassword(user.getPassword());
    		userResponse.setEmail(user.getEmail());
    		userResponse.setAge(user.getAge());
    		
    		userResponse.setUser_id(user.getUser_id());
    		
    	}
    	return userResponse;
    	
    }
	public String deleteuser(Long userId) {
		userRepo.deleteById(userId);
			return "The User Id" +userId +"has been deleted";
		}

		public ProductResponse UpdateUser(Long userId, UserRequest request) {
			
			ProductResponse response = new ProductResponse();
			Optional<Users> receivedData = userRepo.findById(userId);
			if(receivedData.isPresent()) {
				
			Users usersTable = new Users();
			
			usersTable.setAge(request.getAge());
			usersTable.setEmail(request.getEmail());
			usersTable.setPassword(request.getPassword());
			usersTable.setUsername(request.getUsername());
			usersTable.setUser_id(userId);
		    usersTable = userRepo.save(usersTable);
		    
		    response.setMessage("User updated Successfully");
		    response.setStatus("Success");
		    response.setUser_id(userId);
		    response.setUsername(usersTable.getUsername());
		    response.setPassword(usersTable.getPassword());
		    response.setEmail(usersTable.getEmail());
		    response.setAge(usersTable.getAge());
		    
		
		}
			return response;
		}
	}


	


