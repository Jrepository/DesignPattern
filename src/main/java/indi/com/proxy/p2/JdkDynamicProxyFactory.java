package indi.com.proxy.p2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理,代理的对象必须有接口
 */
public class JdkDynamicProxyFactory {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Object target;

    public JdkDynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
            preMethod();
            Object result = method.invoke(this.target, args);
            postMethod();
            return result;
        });
    }


    private void preMethod() {
        logger.info("代理类预处理：{}...", this.getClass().getSimpleName());
    }

    private void postMethod() {
        logger.info("代理类后续处理：{}...", this.getClass().getSimpleName());
    }
}
