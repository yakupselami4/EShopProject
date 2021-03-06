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
		System.out.println("Google Email hesabınız kontrol ediliyor. "
				+ "Cevap true ise eğer işlemleriniz sorunsuz bir şekilde tamamlanacaktır, "
				+ "eğer cevap false ise işleminiz tamamlanamayacaktır: "+matcher.find());
		return matcher.find();
		
		
	}

}
