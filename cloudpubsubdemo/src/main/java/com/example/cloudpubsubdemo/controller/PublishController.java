package com.example.cloudpubsubdemo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;

@RestController
@RequestMapping()
public class PublishController {
  
	private static final Logger LOG = Logger.getLogger(PublishController.class.getName());
	
	//private final Publisher publisher;
	@Autowired
	PubSubTemplate pubSubTemplate;

	/*
	 * @Autowired public PublishController(Publisher publish) { // TODO
	 * Auto-generated constructor stub publisher = publish; }
	 */
	@PostMapping("/publish")
	public String publish(@RequestBody String msg, @RequestParam("topic") String topic)
	{
		try {
		if(topic.isEmpty() || msg.isEmpty())
			throw new Exception("Please specify non empty values");
		LOG.info("MESSAGE TO PUBLISH is " + msg);
		pubSubTemplate.publish(topic,msg);
		return null;
		}
		catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
		
	}
}
