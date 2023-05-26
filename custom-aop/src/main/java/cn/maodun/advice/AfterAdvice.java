package cn.maodun.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AfterAdvice implements org.springframework.aop.AfterAdvice,MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		try {
			return invocation.proceed();
		}finally {
			System.out.println("=========after custom=========");
		}

	}
	//为什么需要穿这个对象MethodInvocation
	//为了执行链上的下一个增强器

}
