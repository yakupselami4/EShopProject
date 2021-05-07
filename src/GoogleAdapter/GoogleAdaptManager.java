package GoogleAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Entities.concretes.User;

public class GoogleAdaptManager implements GoogleAdaptService{

	@Override
	public boolean connectGoogle(User user) {
		
		String emailRegex="^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern emailPat= Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher= emailPat.matcher(user.getEmail());
		System.out.println("Google Email hesabýnýz kontrol ediliyor. "
				+ "Cevap true ise eðer iþlemleriniz sorunsuz bir þekilde tamamlanacaktýr, "
				+ "eðer cevap false ise iþleminiz tamamlanamayacaktýr: "+matcher.find());
		return matcher.find();
		
		
	}

}
