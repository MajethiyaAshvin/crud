package com.crud.crud.service;

import java.util.List;

import com.crud.crud.model.CollectionModel;

public interface CollectionSevice {
	public void save(CollectionModel collectionModel);
	public List<CollectionModel> findAll(); 
	public CollectionModel findById(String id);
	public void delete(CollectionModel collectionModel);
	public CollectionModel findByFirstNameAndPassword(String name,String password);
	public CollectionModel findByFirstName(String name);
}
