package com.halowing.lib.event;

public interface EventPublisher<T> {

	void publish(T message);
	
	String getTopic();
	
}
