package cn.maodun.proxy;

import cn.maodun.anno.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author DELL
 * @date 2023/5/17
 */
public class MySqlSession {
    public static Object getMapper(Class clazz) {
        ClassLoader classLoader = MySqlSession.class.getClassLoader();
        Class[] classes = new Class[]{clazz};
        Object proxy = Proxy.newProxyInstance(classLoader,
                classes, new
                        MyTestInvocationHandler());
        return proxy;
    }

    static class MyTestInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            //处理toString、hashcode等Object方法
            if (method.getDeclaringClass().equals(Object.class)) {
                method.invoke(this, args);
            }
            Select select = method.getAnnotation(Select.class);
            String sql = select.value()[0];
            System.out.println("假装执行select语句");
            return null;
        }
    }
}
