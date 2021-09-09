package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.exceptionhandle.BadRequestException;
import com.example.demo.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/address")
@Api(value="Address Controller")
public class AddressController {
	
	 private static final Logger log = Logger.getLogger(AddressController.class.getName());
	    
		
		@Autowired
		AddressService addressService;
		
		@GetMapping("/addresses")
	    @ApiOperation(value = "View list of addresses")
		public ResponseEntity<?> getAddresses()
		{
			
			try {
				  log.info("Address Controller :: get All Address");
			      List<Address> adrList = addressService.getAllAddress();
			      return new ResponseEntity<List<Address>>(adrList, HttpStatus.OK);
			}
			catch (Exception e) {
					// TODO: handle exception
				log.info("Address Controller :: get All Address :: Exception");
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
		}
		
		@GetMapping("/address")
	    @ApiOperation(value = "View addresse")
		public ResponseEntity<?> getAddress(@RequestParam("id") int id)
		{
			
			try {
				  log.info("Address Controller :: get Address");
			      Address address = addressService.getAddress(id);
			        return new ResponseEntity<Address>(address, HttpStatus.OK);
			}
			catch(BadRequestException badRequestException)
			{
				log.info("Address Controller :: get Address :: BadRequestException");
				return new ResponseEntity<String>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
	
			}
			catch (Exception e) {
					// TODO: handle exception
				log.info("Address Controller :: get Address :: Exception");
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
		}


		@PostMapping(name = "/saveAddress",produces = {MediaType.APPLICATION_JSON_VALUE})
	    @ApiOperation(value = "save the employee", response = Address.class)
		public ResponseEntity<?> saveAddress(@RequestBody Address adr)
		{
			try {
				log.info("Address Controller :: save Address");
				Address address =  addressService.saveAddress(adr);
			     log.info("Address Controller :: Address saved");
			     return new ResponseEntity<Address>(address, HttpStatus.OK);
			}
		   catch (Exception e) {
					// TODO: handle exception
			   log.info("Address Controller :: save Address :: Exception");
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		@DeleteMapping("/address")
	    @ApiOperation(value = "Delete addresse")
		public ResponseEntity<?> deleteAddress(@RequestParam("id") int id)
		{
			
			try {
				  log.info("Address Controller :: delete Address");
			      addressService.deleteAddress(id);
			      return new ResponseEntity<String>("Address with ID "+id+" deleted succesfully", HttpStatus.OK);
			}
			catch (Exception e) {
					// TODO: handle exception
				log.info("Address Controller :: delete Address :: Exception");
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
		}


}
