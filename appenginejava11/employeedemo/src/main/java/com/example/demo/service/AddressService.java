package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.exceptionhandle.BadRequestException;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}
	
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent())
			return address.get();
		else
			throw new BadRequestException("Something went wrong");
	}

	public Address saveAddress(Address adr) {
		// TODO Auto-generated method stub
		return addressRepository.save(adr);
	}

	public void deleteAddress(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			addressRepository.deleteById(id);
		}
		catch(Exception e)
		{
			throw new Exception("some thing went wrong while deleting address");
		}
	}	

}
