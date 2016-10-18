package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"concert"})
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public Audience audience() {
	return new Audience();
	}

}
