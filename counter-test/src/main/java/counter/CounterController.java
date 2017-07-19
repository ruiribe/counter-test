package counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CounterController {

	@Autowired
	private CounterRepository repository;
	@Autowired
	private CounterRepositoryCustom customRepository;

	@MessageMapping("/counterincrement")
	@SendTo("/topic/greetings")
	public long updateCounterValue() throws Exception {
		return customRepository.updateOrCreate("counter");
	}

	@MessageMapping("/countervalue")
	@SendTo("/topic/greetings")
	public long getCounterValue() throws Exception {
		return repository.findByCounterName("counter").getCounterValue();
	}
}
