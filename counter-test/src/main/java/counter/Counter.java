package counter;

import org.springframework.data.annotation.Id;

public class Counter {

	@Id
	String id;

	private String counterName;
	private long counterValue;

	public Counter() {
	}

	public Counter(String counterName, long counterValue) {
		this.counterName = counterName;
		this.counterValue = counterValue;
	}

	public void setCounterValue(long counterValue) {
		this.counterValue = counterValue;
	}

	public long getCounterValue() {
		return counterValue;
	}

	@Override
	public String toString() {
		return "Counter [id=" + id + ", counterName=" + counterName + ", counterValue=" + counterValue + "]";
	}

}
