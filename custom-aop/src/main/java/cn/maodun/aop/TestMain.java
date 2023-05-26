package cn.maodun.aop;

import cn.maodun.advice.AfterAdvice;
import cn.maodun.advice.BeforeAdvice;
import cn.maodun.service.AopService;
import cn.maodun.service.BAopServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author DELL
 * @date 2023/5/26
 */
public class TestMain {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setInterfaces(AopService.class);
        pf.addAdvice(new AfterAdvice());
        pf.setTarget(new BAopServiceImpl());
        //pf.setProxyTargetClass(true);
        // createAopProxy()  jdk  cglib
        AopService service = (AopService) pf.getProxy();
        //通知是怎么执行的
        //目标对象的m方法怎么调用的？
        service.m1(9);
    }
}
