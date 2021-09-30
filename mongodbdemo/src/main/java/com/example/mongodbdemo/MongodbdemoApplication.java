package com.example.mongodbdemo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping
public class MongodbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbdemoApplication.class, args);
	}
	
   @Autowired
   PersonRepository personRepository;
	
	@PostMapping("/save")
	public String save(@RequestBody Person p)
	{
		personRepository.save(p);
		return "saved!!";
	}
	@PutMapping("{id}")
	public String update(@PathVariable String id, @RequestBody Person person)
	{
		if(personRepository.findById(id).isPresent())
		{
			Person p = personRepository.findById(id).get();
		    p.setFirstname(person.getFirstname());
		    p.setLastname(person.getLastname());
		    p.setAddress(person.getAddress());
		    p.setPhno(person.getPhno());
		    personRepository.save(p);
		    return "updated!!!";
		}
		else
			return "Person not Fount with ID "+id;
	}
		
	
	@GetMapping("/get")
	public List<Person> getDetails()
	{
		List<Person> persons = personRepository.findAll();
		return persons;
		//return persons.stream().map(Person::getFirstname).collect(Collectors.toList());
	}
	@GetMapping("/getNames")
	public List<String> getNames()
	{
		List<Person> persons = personRepository.findAll();
		return persons.stream().map(Person::getFirstname).collect(Collectors.toList());
	}
	@GetMapping("get/{id}")
	public Person getByID(@PathVariable("id") String id)
	{
		return personRepository.findById(id).isPresent()?personRepository.findById(id).get():null;
	}
	@DeleteMapping("{id}")
	public void deleteByID(@PathVariable("id") String id)
	{
		personRepository.deleteById(id);
	}
	

}
