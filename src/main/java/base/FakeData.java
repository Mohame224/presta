package base;

import com.github.javafaker.Faker;

public class FakeData {
	 Faker faker=new Faker();
	public String username=faker.name().username();
	public String fake_password=faker.princessBride().character();
	public  String fake_email=faker.internet().emailAddress();
	public  String firstname=faker.name().firstName();
	public  String lastname=faker.name().lastName();
	public  String password=faker.internet().password();
	
	
	
	
}
