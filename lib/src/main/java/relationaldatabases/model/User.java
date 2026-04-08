package relationaldatabases.model;

import java.util.function.LongToDoubleFunction;

public class User {
	
	//fields
	
	private long id;
	private String name;
	private String password;
	private double balance;
	private String age;
	private int phonenumber;
	private boolean isActive;
	private String gender;
	private String description;
	
	
	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//constructors
	public User(long id, String name, String password, double balance, String age, int phonenumber, boolean isActive, String gender, String description) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.age = age;
		this.phonenumber = phonenumber;
		this.isActive = isActive;
		this.gender = gender;
		this.description = description;
	}
	
	
	
	
	

}
