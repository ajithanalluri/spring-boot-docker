package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exceptionhandle.BadRequestException;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value="EmployeeApplication")
public class EmployeeController {
	
    private static final Logger log = Logger.getLogger(EmployeeController.class.getName());
    
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
    @ApiOperation(value = "View list of employees")
	public ResponseEntity<?> getEmployees()
	{
		
		try {
			  log.info("Employee Controller :: get Employees");
		      List<Employee> empList = employeeService.getEmployees();
		      return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
		}
		catch (Exception e) {
				// TODO: handle exception
			log.info("Employee Controller :: get Employees :: Exception");
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping(name = "/saveEmployee",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "save the employee", response = Employee.class)
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee emp)
	{
		try {
			log.info("Employee Controller :: save Employee");
		     Employee employee =  employeeService.saveEmployee(emp);
		     log.info("Employee Controller :: employee saved");
		     return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		catch (BadRequestException badRequestException) {
			// TODO: handle exception
	        log.info("Employee Controller :: save Employee :: BadRequestException");
			return new ResponseEntity<String>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
		}
	   catch (Exception e) {
				// TODO: handle exception
		   log.info("Employee Controller :: save Employee :: Exception");
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/employee")
    @ApiOperation(value = "View an employee", response = Employee.class)
	public ResponseEntity<?> getEmployee( @RequestParam("id") int id)
	{
		
	  try {
		  log.info("Employee Controller :: get Employee ");
		   Employee emp = employeeService.getEmployee(id);
		   if(emp != null)
	     	  return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		   else
			   log.info("Employee Controller :: get Employee :: employee id not present");
			  return new ResponseEntity<String>("Employee ID "+ id +" not found", HttpStatus.BAD_REQUEST);
	  }
	  catch (Exception e) {
			// TODO: handle exception
		  log.info("Employee Controller :: get Employee :: Exception");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "Delete an employee")
	public ResponseEntity<String> deleteEmployee(@RequestParam("id") int id)
	{
		try {
			log.info("Employee Controller :: delete Employee");
		      String response = employeeService.deleteEmployee(id);
		      return new ResponseEntity<String>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			// TODO: handle exception
			log.info("Employee Controller :: delete Employee :: Exception");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update")
	@ApiOperation(value = "Update an employee")
	public ResponseEntity<?> updateEmployee(@RequestParam("id") int id, @RequestBody Employee emp )
	{
		try {
			  log.info("Employee Controller :: update Employee");
		       Employee employee = employeeService.updateEmployee(id, emp);
		       return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		    }
		
		catch (Exception e) {
			// TODO: handle exception
			log.info("Employee Controller :: update Employee  :: Exception " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
