package DataAccess.abstracts;

import Entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	
	void delete(User user);
	
	void uptade(User user);
	
	void readInf(User user);
	
	

}
