package indi.com.proxy.p3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理,代理的对象可以没有接口
 */
public class CglibDynamicProxyFactory implements MethodInterceptor {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Object target;//维护一个目标对象

    public CglibDynamicProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        preMethod();
        Object result = method.invoke(this.target,args);
        postMethod();
        return result;
    }

    private void preMethod() {
        logger.info("代理类预处理：{}...", this.getClass().getSimpleName());
    }

    private void postMethod() {
        logger.info("代理类后续处理：{}...", this.getClass().getSimpleName());
    }


}
