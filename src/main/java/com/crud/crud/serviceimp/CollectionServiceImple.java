package com.crud.crud.serviceimp;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crud.crud.model.CollectionModel;
import com.crud.crud.repository.CollectionRepository;
import com.crud.crud.service.CollectionSevice;

@Service
public class CollectionServiceImple implements CollectionSevice
{
	@Resource
	CollectionRepository cr;

	@Override
	public void save(CollectionModel collectionModel) {
		cr.save(collectionModel);
	}
	@Override
	public List<CollectionModel> findAll() {
		return cr.findAll();
	}
	@Override
	public CollectionModel findById(String id) {
		return cr.findById(id);
	}

	@Override
	public void delete(CollectionModel collectionModel) {
		cr.delete(collectionModel);
		
	}
	@Override
	public CollectionModel findByFirstNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return cr.findByFirstNameAndPassword(name, password);
	}
	@Override
	public CollectionModel findByFirstName(String name) {
		// TODO Auto-generated method stub
		return cr.findByFirstName(name);
	}
}
