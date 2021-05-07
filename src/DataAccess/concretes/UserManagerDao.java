package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManagerDao implements UserDao{
	static List<User> users= new ArrayList<User>(Arrays.asList(new User("yakup","öztürk","abc@email.com","1234556786")));

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý sisteme eklendi: ");
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý sistemden silindi: ");
		user=null;
	}

	@Override
	public void uptade(User user) {
		System.out.println("Kullanýcý bilgileri güncellendi: ");
		
	}

	@Override
	public void readInf(User user) {
		System.out.println("Kullanýcýnýn ismi:"+user.getFirstName()+System.lineSeparator()
		+"Kullanýcýnýn soyadý: "+user.getLastName()+System.lineSeparator()+
		"Kullanýcýnýn email adresi: "+user.getEmail()+System.lineSeparator()+
		"Kullanýcýnýn þifresi: "+user.getPassword());
		
		
	}
		
		
		
}
