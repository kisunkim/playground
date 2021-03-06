package ch.rasc.pubsub.guava;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.eventbus.EventBus;

@Service
public class Publisher {

	private final EventBus eventBus;

	@Autowired
	public Publisher(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void publishMsgEvent(String message) {
		eventBus.post(new MsgEvent(message));
	}

	public void publishSpecialMsgEvent(String message, String user) {
		eventBus.post(new SpecialMsgEvent(message, user));
	}

	public void publishTimeEvent() {
		eventBus.post(new TimeEvent(new Date()));
	}

}
