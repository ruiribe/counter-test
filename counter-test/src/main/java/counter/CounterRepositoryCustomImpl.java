package counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CounterRepositoryCustomImpl implements CounterRepositoryCustom {

	@Autowired
	CounterRepository repository;

	@Override
	public long updateOrCreate(String counterName) {
		Counter counter = repository.findByCounterName("counter");
		long value = 0;
		if (counter == null) {
			return repository.save(new Counter("counter", value)).getCounterValue();
		} else {
			counter.setCounterValue(counter.getCounterValue() + 1);
			repository.save(counter);
			return counter.getCounterValue();
		}
	}
}
