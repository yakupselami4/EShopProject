package Business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.abstracts.UserService;
import Entities.concretes.User;
import GoogleAdapter.GoogleAdaptManager;

public class UserManager implements UserService{
	

	@Override
	public boolean CheckEmailIfCorrect(User user) {
		String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat= Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher= emailPat.matcher(user.getEmail());
		System.out.println("Email doðrulanmasý sona erdi.");
		return matcher.find();
	}


	@Override
	public boolean CheckEmailIfCorrectStep2(User user) {
		if(user.getEmail().isEmpty()) {
			System.out.println("Email bulunamadý.");
			return false;
		}
		System.out.println("Email sistemde bulundu."+user.getEmail());
		return true;
	}

	@Override
	public boolean CheckPasswordLength(User user) {
		if (user.getPassword().length()<6 || user.getPassword().isEmpty()) {
			System.out.println("Þifreniz 6 karakterden oluþmalýdýr.");
			return false;
		}else {
			System.out.println("Þifre kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckFirstNameLength(User user) {
		if(user.getFirstName().length()<2 || user.getFirstName().isEmpty()) {
			System.out.println("Ýsminiz 2 karakterten küçük olamaz.");
			return false;
		}else {
			System.out.println("Ýsminiz kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckLastNameLength(User user) {
		if(user.getLastName().length()<2 || user.getLastName().isEmpty()) {
			System.out.println("Soyadýnýz 2 karakterten küçük olamaz.");
			return false;
		}else {
			System.out.println("Soyadýnýz kaydedildi.");
			return true;
		}
		
	}


	@Override
	public void login(User user) {
		System.out.println("Giriþ iþlemi daha önceden doðrulanmýþ olan email ve þifre üzerinden otomatik olarak gerçekleþtirilmektedir.");
		System.out.println("email: "+user.getEmail());
		System.out.println("þifre: "+user.getPassword());
		
		
	}


	@Override
	public boolean Register(User user) {
		
		if(	CheckEmailIfCorrect(user) &&
		CheckEmailIfCorrectStep2(user) &&
		CheckFirstNameLength(user) &&
		CheckLastNameLength(user) &&
		CheckPasswordLength(user)) {
			System.out.println("Kayýt iþlemi baþarýlý...");
			return true;		
			
		}else
		{
			System.out.println("Kayýt iþlemi baþarýsýz.");
			return false;
		}

		
	}


	@Override
	public boolean SendVerificationMessage(User user) {
		if (CheckEmailIfCorrect(user)&& CheckEmailIfCorrectStep2(user)) {
			System.out.println("Email adresiniz doðrulandý: "+user.getEmail());
			return true;
		}else {
			System.out.println("Email adresiniz doðrulama aþamasýný geçemedi, kurallara uyduðunuza dikkat edin.");
			return false;
		}
		
	}


	@Override
	public boolean RegisterWithGoogleMailAccount(User user) {
		GoogleAdaptManager googleadapt= new GoogleAdaptManager();
		if(googleadapt.connectGoogle(user)) {
			return true;
		}else {
		return true;	
		}
		
		
	}




}




