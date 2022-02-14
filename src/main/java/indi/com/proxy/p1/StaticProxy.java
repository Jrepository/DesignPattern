package indi.com.proxy.p1;

/**
 * 代理（Proxy）类
 */
public class StaticProxy extends AbstractSubject {

    private AbstractSubject subject;

    public StaticProxy(AbstractSubject subject) {
        this.subject = subject;
    }

    @Override
    public void method() {
        logger.info("代理类：{}...", this.getClass().getSimpleName());
        preMethod();
        subject.method();
        postMethod();
    }

    private void preMethod() {
        logger.info("代理类预处理：{}...", this.getClass().getSimpleName());
    }

    private void postMethod() {
        logger.info("代理类后续处理：{}...", this.getClass().getSimpleName());
    }
}
