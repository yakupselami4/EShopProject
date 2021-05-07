
import DataAccess.concretes.UserManagerDao;
import Business.concretes.UserManager;
import Entities.concretes.User;
import GoogleAdapter.GoogleAdaptManager;

public class Main {

	public static void main(String[] args) {
		User user= new User("Yakup Selami", "Öztürk", "yakupselami@email.com", "123456");
		
		User usergoogle= new User("Burak","Öztürk","burakozturk@gmail.com","234567");

		UserManager usermanager=new UserManager();
		usermanager.CheckEmailIfCorrect(user);
		System.out.println("----------");
		usermanager.CheckEmailIfCorrectStep2(user);
		System.out.println("----------");
		usermanager.CheckPasswordLength(user);
		System.out.println("----------");
		usermanager.CheckFirstNameLength(user);
		System.out.println("----------");
		usermanager.CheckLastNameLength(user);
		System.out.println("----------");
		usermanager.Register(user);
		System.out.println("----------");
		usermanager.SendVerificationMessage(user);
		System.out.println("----------");
		usermanager.login(user);
		System.out.println("----------");
		usermanager.RegisterWithGoogleMailAccount(user);
		
		UserManagerDao usermanagerdao= new UserManagerDao();
		System.out.println("----------");
		usermanagerdao.add(user);
		System.out.println("----------");
		usermanagerdao.readInf(user);
		System.out.println("----------");
		usermanagerdao.uptade(user);
		System.out.println("----------");
		usermanagerdao.delete(user);
		System.out.println("----------");
		
		GoogleAdaptManager googleadaptmanager= new GoogleAdaptManager();
		googleadaptmanager.connectGoogle(usergoogle);
		System.out.println("----------");



		

		
		
	}

}
