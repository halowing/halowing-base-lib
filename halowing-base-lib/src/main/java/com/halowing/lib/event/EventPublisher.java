package com.halowing.lib.event;

public interface EventPublisher {

	void publish(String message);
	
	String getTopic();
	
}
