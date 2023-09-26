package com.halowing.lib.event;

public abstract class AbstractLocalMessageEventSubscriber implements EventSubscriber<String> {
	
	private final String topic;

	public AbstractLocalMessageEventSubscriber(String topic) {
		this.topic = topic.trim();
	}

	@Override
	public abstract void process(String message);

	@Override
	public String getTopic() {
		return topic;
	}

}
