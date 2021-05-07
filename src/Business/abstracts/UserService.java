package Business.abstracts;

import Entities.concretes.User;

public interface UserService {
	
	public boolean CheckEmailIfCorrect(User user);
	
	public boolean CheckEmailIfCorrectStep2(User user);
	
	public boolean CheckPasswordLength(User user);
	
	public boolean CheckFirstNameLength(User user);
	
	public boolean CheckLastNameLength(User user);
	
	public void login(User user);
	
	public boolean Register(User user);
	
	public boolean SendVerificationMessage(User user);
	
	public boolean RegisterWithGoogleMailAccount(User user);
	


}
