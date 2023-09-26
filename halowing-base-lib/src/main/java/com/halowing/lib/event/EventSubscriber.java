package com.halowing.lib.event;

public interface EventSubscriber<T> {

	void process(T message);
	
	String getTopic();
}
