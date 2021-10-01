package com.example.cloudpubsubdemo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.pubsub.v1.PubsubMessage;

@RestController
@RequestMapping()
public class SubscribeController {

	private static final Logger LOG = Logger.getLogger(SubscribeController.class.getName());

	@Autowired
	PubSubTemplate pubSubTemplate;
	
	@GetMapping("subscribe")
	public void subscribe(@RequestParam String subscription)
	{
		/*
		 * PubsubMessage message = acknowledgeablePubsubMessage.getPubsubMessage();
		 * pubSubTemplate.subscribe(subscription, basicAcknowledgeablePubsubMessage -> {
		 * PubsubMessage message = acknowledgeablePubsubMessage.getPubsubMessage();
		 * LOG.info("message received: " + message.getData().toStringUtf8());
		 * acknowledgeablePubsubMessage.ack(); });
		 */
	
	}
	
}
