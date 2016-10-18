package concert;

import org.springframework.stereotype.Component;

@Component
public class Performance {
	
	public void perform() {
		System.out.println(Performance.class);
		throw new RuntimeException("SDFS");
	}

	public void perform(String string) {
		System.out.println(Performance.class + " " + string);
	}

}
