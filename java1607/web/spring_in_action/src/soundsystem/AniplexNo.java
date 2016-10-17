package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class AniplexNo implements CompactDisc {

	@Override
	public void play() {
		System.out.println("ANIPLEX OH MY GOD IT\"S ANIPLEX");
	}

}
