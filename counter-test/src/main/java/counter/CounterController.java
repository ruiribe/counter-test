package counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CounterController {

	@Autowired
	private CounterRepository repository;

	@MessageMapping("/counterincrement")
	@SendTo("/topic/greetings")
	public CounterValue greeting() throws Exception {
		Counter counter = repository.findByCounterName("counter");
		counter.setCounterValue(counter.counterValue + 1);
		repository.save(counter);
		return new CounterValue(counter.counterValue);
	}
	
	@MessageMapping("/countervalue")
	@SendTo("/topic/greetings")
	public CounterValue getCounterValue() throws Exception {
		return new CounterValue(repository.findByCounterName("counter").counterValue);
	}
}
