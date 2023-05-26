package cn.maodun.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BeforeAdvice implements MethodInterceptor {
	//为什么需要穿这个对象MethodInvocation
	//为了执行链上的下一个增强器
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return invocation.proceed();
	}
}
