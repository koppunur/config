package com.slokam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slokam.sbi.entity.PersonaldetailsEntity;
import com.slokam.service.Ipersondetailservice;
import com.slokam.service.Persondetailservice;

@RestController
@RequestMapping("getall")
public class PersondetailsController {

	@Autowired
	private Persondetailservice service;
 
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<PersonaldetailsEntity>> getall(){
		
	   //RestTemplate re=new RestTemplate().getForEntity("http://localhost:8886/getall/all",list);
		
		List<PersonaldetailsEntity> list=service.getallpersons();
		
		RestTemplate re=(RestTemplate) new RestTemplate().getForEntity("http://localhost:8884/student/5",ABC.class);
		
		ResponseEntity<List<PersonaldetailsEntity>> res=new ResponseEntity<>(list,HttpStatus.OK);
		
		return res;
		
	}
}
