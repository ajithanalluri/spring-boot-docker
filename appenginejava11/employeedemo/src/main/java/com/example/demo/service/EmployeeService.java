package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionhandle.BadRequestException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
    private static final Logger log = Logger.getLogger(EmployeeService.class.getName());

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		log.info("Employee service :: get all employees");
		return employeeRepository.findAll();
	}

	public Employee getEmployee(int  id) {
		// TODO Auto-generated method stub
		log.info("Employee service :: get employee");
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent())
			return emp.get();
		else 
		  throw new BadRequestException("Something went wrong while fetching the Employee with ID "+id);		 
		
	}

	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		log.info("Employee service :: save employee");
		return employeeRepository.save(emp);
	}

	public String deleteEmployee(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			log.info("Employee service :: delete employee");
		    employeeRepository.deleteById(id);
		    return "Employee deleted successfully";
		}
		catch(Exception e)
		{
			log.info("Employee service :: delete employee :: exception");
			throw new Exception("some thing went wrong while deleting employee");
			//return e.getMessage();
		}
	}
	
	@Autowired
	AddressService addressService;

	public Employee updateEmployee(int id, Employee emp) {
		// TODO Auto-generated method stub

		     log.info("Employee service :: update employee");
		    Employee employeeOptional = getEmployee(id);
        	Address a1 = emp.getAddress().iterator().next();

	    	if(employeeOptional != null)
		    {	
			    employeeOptional.setId(emp.getId());
			    employeeOptional.setName(emp.getName());
			    employeeOptional.setSalary(emp.getSalary());
			    employeeOptional.setPhno(emp.getPhno());
		        if(emp.getAddress().iterator().next().getId() == 0)
		        {	
				
	     			Address addressSave = new Address();
	     			//addressSave.setId(a1.getId());
	     			addressSave.setStreet(a1.getStreet());
	     			addressSave.setType(a1.getType());
	     			addressSave.setCity(a1.getCity());
	     			addressSave.setZipcode(a1.getZipcode());
	     			Address updateAddress = addressService.saveAddress(addressSave);
	     			Set<Address> addressSet = employeeOptional.getAddress();
	     			addressSet.add(updateAddress);
	     			employeeOptional.setAddress(addressSet);
		        }
		        else
		        {
		        
			       Address address = addressService.getAddress(a1.getId());
			       address.setId(a1.getId());
			       address.setStreet(a1.getStreet());
			       address.setType(a1.getType());
			       address.setCity(a1.getCity());
			       address.setZipcode(a1.getZipcode());
	     		   Set<Address> addressSet = employeeOptional.getAddress();
			       addressSet.add(address);
			       employeeOptional.setAddress(addressSet);

		        }
		    	
		    }
	    	
	    	return employeeRepository.saveAndFlush(employeeOptional);	
	}

}
