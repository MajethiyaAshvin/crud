package com.crud.crud.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.exception.AlreadyStoreException;
import com.crud.crud.model.CollectionModel;
import com.crud.crud.model.CollectionRequestModel;
import com.crud.crud.model.ResponseComponent;
import com.crud.crud.model.UnifiedResponse;
import com.crud.crud.service.CollectionSevice;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/employee")
@Api(value="Employee Storage", description = "This is Employeee Crud Opration API")
public class CollectionController {
	@Autowired
	CollectionSevice collectionSevice;
	
	private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);
	 
	

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UnifiedResponse<CollectionModel> add(@RequestBody CollectionModel collectionmodel) {
		CollectionModel cc=new CollectionModel();
	    cc=collectionSevice.findByFirstName(collectionmodel.getFirstName());
		if(cc!=null)
		{
			logger.error("name already storr");
		throw new AlreadyStoreException("name is already exist");
		
		}
	

		collectionSevice.save(collectionmodel);				
		logger.info("save data seccusee");
		return new UnifiedResponse<CollectionModel>(new ResponseComponent<CollectionModel>("save successes",HttpStatus.OK.value(),collectionmodel,"ok"));
	
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody CollectionRequestModel collectionrequestmodel) {
		CollectionModel account = new CollectionModel();
		account=collectionSevice.findByFirstNameAndPassword(collectionrequestmodel.getFirstName(), collectionrequestmodel.getPassword());
		if (account!=null) {
			return "Login Successefully.....!";
		} else {
			return "invalid username and password";
		}
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String edit(@RequestBody CollectionRequestModel collectionrequestmodel, @PathVariable("id") String id) {
		CollectionModel cm = collectionSevice.findById(id);
		if (cm == null) {
			return " Id not found";
		}
		cm.setFirstName(collectionrequestmodel.getFirstName());
		cm.setLastName(collectionrequestmodel.getLastName());
		collectionSevice.save(cm);
		return "Employee Update Successe fully...!";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<CollectionModel>>listData() {
		   return ResponseEntity.ok(collectionSevice.findAll());
	}
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public CollectionModel view(@PathVariable("id") String id) {
		CollectionModel li = collectionSevice.findById(id);
		return li;
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id")String id) {
		CollectionModel li = collectionSevice.findById(id);
		if (li == null) {
			return "Id Not found";
		}
		collectionSevice.delete(li);
		return "Recored Deleted......!";
	}
	
}
