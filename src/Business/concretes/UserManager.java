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
		System.out.println("Email do�rulanmas� sona erdi.");
		return matcher.find();
	}


	@Override
	public boolean CheckEmailIfCorrectStep2(User user) {
		if(user.getEmail().isEmpty()) {
			System.out.println("Email bulunamad�.");
			return false;
		}
		System.out.println("Email sistemde bulundu."+user.getEmail());
		return true;
	}

	@Override
	public boolean CheckPasswordLength(User user) {
		if (user.getPassword().length()<6 || user.getPassword().isEmpty()) {
			System.out.println("�ifreniz 6 karakterden olu�mal�d�r.");
			return false;
		}else {
			System.out.println("�ifre kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckFirstNameLength(User user) {
		if(user.getFirstName().length()<2 || user.getFirstName().isEmpty()) {
			System.out.println("�sminiz 2 karakterten k���k olamaz.");
			return false;
		}else {
			System.out.println("�sminiz kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckLastNameLength(User user) {
		if(user.getLastName().length()<2 || user.getLastName().isEmpty()) {
			System.out.println("Soyad�n�z 2 karakterten k���k olamaz.");
			return false;
		}else {
			System.out.println("Soyad�n�z kaydedildi.");
			return true;
		}
		
	}


	@Override
	public void login(User user) {
		System.out.println("Giri� i�lemi daha �nceden do�rulanm�� olan email ve �ifre �zerinden otomatik olarak ger�ekle�tirilmektedir.");
		System.out.println("email: "+user.getEmail());
		System.out.println("�ifre: "+user.getPassword());
		
		
	}


	@Override
	public boolean Register(User user) {
		
		if(	CheckEmailIfCorrect(user) &&
		CheckEmailIfCorrectStep2(user) &&
		CheckFirstNameLength(user) &&
		CheckLastNameLength(user) &&
		CheckPasswordLength(user)) {
			System.out.println("Kay�t i�lemi ba�ar�l�...");
			return true;		
			
		}else
		{
			System.out.println("Kay�t i�lemi ba�ar�s�z.");
			return false;
		}

		
	}


	@Override
	public boolean SendVerificationMessage(User user) {
		if (CheckEmailIfCorrect(user)&& CheckEmailIfCorrectStep2(user)) {
			System.out.println("Email adresiniz do�ruland�: "+user.getEmail());
			return true;
		}else {
			System.out.println("Email adresiniz do�rulama a�amas�n� ge�emedi, kurallara uydu�unuza dikkat edin.");
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




