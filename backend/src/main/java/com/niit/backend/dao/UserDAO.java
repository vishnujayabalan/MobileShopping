package com.niit.backend.dao;
import java.util.List;
import com.niit.backend.model.User;
public interface UserDAO {

	public List<User> getAllUser();
	 public boolean saveUser(User user);
	 public boolean deleteUser(User user);
	 public boolean updateUser(User user);
	 public User getUserById(String id);
	 public User getUserByName(String name);
	 public User validate(String id,String password);
	 public String getRole(String id);
}
