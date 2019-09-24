package com.crud.crud.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.crud.model.CollectionModel;

public interface  CollectionRepository extends MongoRepository<CollectionModel,Integer>{
	public CollectionModel findById(String id);
	public CollectionModel findByFirstNameAndPassword(String name,String password);
	public CollectionModel findByFirstName(String name);
	
}
    