package indi.com.proxy;

import indi.com.base.BaseTest;
import indi.com.proxy.p1.AbstractSubject;
import indi.com.proxy.p1.RealSubjectP1;
import indi.com.proxy.p1.StaticProxy;
import indi.com.proxy.p2.JdkDynamicProxyFactory;
import indi.com.proxy.p3.CglibDynamicProxyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 *
 * Cglib和jdk动态代理？
 * 1、是否提供子类代理：Cglib（是），jdk（否）
 * 2、是否提供接口代理：Cglib（是），jdk（是）
 * 3、Cglib：必须依赖于CGLib的类库，但是它需要类来实现任何接口代理的是指定的类生成一个子类，覆盖其中的方法
 * 4、jdk：实现InvocationHandler，使用Proxy.newProxyInstance产生代理对象，被代理的对象必须要实现接口
 *
 * Cglib和jdk动态代理的区别？
 * 1、Jdk动态代理：利用拦截器（必须实现InvocationHandler）加上反射机制生成一个代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理
 * 2、Cglib动态代理：利用ASM框架，对代理对象类生成的class文件加载进来，通过修改其字节码生成子类来处理
 *
 * 什么时候用cglib什么时候用jdk动态代理？
 * 1、目标对象生成了接口 默认用JDK动态代理
 * 2、如果目标对象使用了接口，可以强制使用cglib
 * 3、如果目标对象没有实现接口，必须采用cglib库，Spring会自动在JDK动态代理和cglib之间转换
 *
 * JDK动态代理和cglib字节码生成的区别？
 * 1、JDK动态代理只能对实现了接口的类生成代理，而不能针对类
 * 2、Cglib是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，并覆盖其中方法的增强，但是因为采用的是继承，所以该类或方法最好不要生成final，对于final类或方法，是无法继承的
 *
 * Cglib比JDK快？
 * 1、cglib底层是ASM字节码生成框架，但是字节码技术生成代理类，在JDL1.6之前比使用java反射的效率要高
 * 2、在jdk6之后逐步对JDK动态代理进行了优化，在调用次数比较少时效率高于cglib代理效率
 * 3、只有在大量调用的时候cglib的效率高，但是在1.8的时候JDK的效率已高于cglib
 * 4、Cglib不能对声明final的方法进行代理，因为cglib是动态生成代理对象，final关键字修饰的类不可变只能被引用不能被修改
 *
 * Spring如何选择是用JDK还是cglib？
 * 1、当bean实现接口时，会用JDK代理模式
 * 2、当bean没有实现接口，用cglib实现
 * 3、可以强制使用cglib（在spring配置中加入<aop:aspectj-autoproxy proxyt-target-class=”true”/>
 *
 */
public class ProxyTest extends BaseTest {

    @Test
    @DisplayName("p1 代理模式-静态代理测试")
    void staticProxyTest() {
        new StaticProxy(new RealSubjectP1()).method();
    }


    @Test
    @DisplayName("p2 代理模式-动态代理测试")
    void jdkDynamicProxyFactoryTest() {
        jdkDynamicProxyWithInterface();
        jdkDynamicProxyNoInterface();
    }

    @Test
    @DisplayName("p3 代理模式-cglib测试")
    void cglibProxyFactoryTest() {
        cglibDynamicProxyFactoryWithInterface();
        cglibDynamicProxyFactoryNoInterface();
    }

    private void jdkDynamicProxyWithInterface() {
        JdkDynamicProxyFactory proxyFactory = new JdkDynamicProxyFactory(new RealSubject());
        Subject instance = (Subject) proxyFactory.getProxyInstance();
        instance.method();
    }

    /**
     * java.lang.ClassCastException: com.sun.proxy.$Proxy74 cannot be cast to indi.com.proxy.p1.AbstractSubject
     * 原因：Subject为抽象类
     * 解决：Subject改为接口
     */
    private void jdkDynamicProxyNoInterface() {
        JdkDynamicProxyFactory proxyFactory = new JdkDynamicProxyFactory(new RealSubjectP1());
        AbstractSubject instance = (AbstractSubject) proxyFactory.getProxyInstance();
        instance.method();
    }

    private void cglibDynamicProxyFactoryWithInterface() {
        CglibDynamicProxyFactory proxyFactory = new CglibDynamicProxyFactory(new RealSubject());
        RealSubject proxyInstance = (RealSubject) proxyFactory.getProxyInstance();
        proxyInstance.method();
    }

    private void cglibDynamicProxyFactoryNoInterface() {
        CglibDynamicProxyFactory proxyFactory = new CglibDynamicProxyFactory(new RealSubjectP1());
        AbstractSubject proxyInstance = (AbstractSubject) proxyFactory.getProxyInstance();
        proxyInstance.method();
    }
}
