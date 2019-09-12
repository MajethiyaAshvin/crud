package com.crud.crud.model;

public class CollectionRequestModel {
	
	private String firstName;
	private String lastName;
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public CollectionModel insert(CollectionModel collectionModel)
	{
		collectionModel.setFirstName(firstName);
		collectionModel.setLastName(lastName);
		collectionModel.setPassword(password);
		return collectionModel;
	}

	
	

}
