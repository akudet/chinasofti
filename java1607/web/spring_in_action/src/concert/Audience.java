package concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	private static final String POINT_CUT = "performance()";
	private static final String POINT_CUT_EXPRESSION = "execution(** concert.Performance.perform(..))";
	
	@AfterReturning("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}


	@AfterThrowing(POINT_CUT)
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}
	
	@Pointcut(POINT_CUT_EXPRESSION)
	public void performance() {
	}


	@Before(POINT_CUT)
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}

	@Before(POINT_CUT)
	public void takeSeats() {
		System.out.println("Taking seats");
	}
}