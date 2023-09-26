package com.halowing.lib.event;

public interface EventContainer<T> {

	void subscribe(EventSubscriber<T> subscriber);
	
	EventPublisher getPublisher(String topic);
	
}
