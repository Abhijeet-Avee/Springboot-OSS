package com.bankapp.model.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("@annotation(RunTimeLogs)")
	public Object Logging(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = point.proceed();
		long end = System.currentTimeMillis();
		logger.info("time taken to execute -- Method: (" + point.getSignature().getName() + "): " + (end - start));
		return result;
	}
}
