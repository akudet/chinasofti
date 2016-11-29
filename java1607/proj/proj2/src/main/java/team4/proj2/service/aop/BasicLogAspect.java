package team4.proj2.service.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicLogAspect {

	@Before("target(team4.proj2.control.BasicController) && execution(public * *(..))")
	public void log(JoinPoint jp) throws Throwable {
		for (Object obj : jp.getArgs()) {
			if (obj instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest) obj;
				System.out.println(jp.getSignature().getName() + " -> "
						+ req.getMethod() + " : "
						+ req.getRequestURI());
			}
		}
	};

}
