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
		System.out.println("Email doğrulanması sona erdi.");
		return matcher.find();
	}


	@Override
	public boolean CheckEmailIfCorrectStep2(User user) {
		if(user.getEmail().isEmpty()) {
			System.out.println("Email bulunamadı.");
			return false;
		}
		System.out.println("Email sistemde bulundu."+user.getEmail());
		return true;
	}

	@Override
	public boolean CheckPasswordLength(User user) {
		if (user.getPassword().length()<6 || user.getPassword().isEmpty()) {
			System.out.println("Şifreniz 6 karakterden oluşmalıdır.");
			return false;
		}else {
			System.out.println("Şifre kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckFirstNameLength(User user) {
		if(user.getFirstName().length()<2 || user.getFirstName().isEmpty()) {
			System.out.println("İsminiz 2 karakterten küçük olamaz.");
			return false;
		}else {
			System.out.println("İsminiz kaydedildi.");
			return true;
		}
		
	}

	@Override
	public boolean CheckLastNameLength(User user) {
		if(user.getLastName().length()<2 || user.getLastName().isEmpty()) {
			System.out.println("Soyadınız 2 karakterten küçük olamaz.");
			return false;
		}else {
			System.out.println("Soyadınız kaydedildi.");
			return true;
		}
		
	}


	@Override
	public void login(User user) {
		System.out.println("Giriş işlemi daha önceden doğrulanmış olan email ve şifre üzerinden otomatik olarak gerçekleştirilmektedir.");
		System.out.println("email: "+user.getEmail());
		System.out.println("şifre: "+user.getPassword());
		
		
	}


	@Override
	public boolean Register(User user) {
		
		if(	CheckEmailIfCorrect(user) &&
		CheckEmailIfCorrectStep2(user) &&
		CheckFirstNameLength(user) &&
		CheckLastNameLength(user) &&
		CheckPasswordLength(user)) {
			System.out.println("Kayıt işlemi başarılı...");
			return true;		
			
		}else
		{
			System.out.println("Kayıt işlemi başarısız.");
			return false;
		}

		
	}


	@Override
	public boolean SendVerificationMessage(User user) {
		if (CheckEmailIfCorrect(user)&& CheckEmailIfCorrectStep2(user)) {
			System.out.println("Email adresiniz doğrulandı: "+user.getEmail());
			return true;
		}else {
			System.out.println("Email adresiniz doğrulama aşamasını geçemedi, kurallara uyduğunuza dikkat edin.");
			return false;
		}
		
	}


	@Override
	public boolean RegisterWithGoogleMailAccount(User user) {
		GoogleAdaptManager googleadapt= new GoogleAdaptManager();
		if(googleadapt.connectGoogle(user)) {
			return true;
		}else {
		return false;	
		}
		
		
	}




}




