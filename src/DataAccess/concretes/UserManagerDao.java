package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManagerDao implements UserDao{
	static List<User> users= new ArrayList<User>(Arrays.asList(new User("yakup","�zt�rk","abc@email.com","1234556786")));

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� sisteme eklendi: ");
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� sistemden silindi: ");
		user=null;
	}

	@Override
	public void uptade(User user) {
		System.out.println("Kullan�c� bilgileri g�ncellendi: ");
		
	}

	@Override
	public void readInf(User user) {
		System.out.println("Kullan�c�n�n ismi:"+user.getFirstName()+System.lineSeparator()
		+"Kullan�c�n�n soyad�: "+user.getLastName()+System.lineSeparator()+
		"Kullan�c�n�n email adresi: "+user.getEmail()+System.lineSeparator()+
		"Kullan�c�n�n �ifresi: "+user.getPassword());
		
		
	}
		
		
		
}
