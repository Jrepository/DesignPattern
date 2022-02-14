package indi.com.proxy.p1;

/**
 * * 真实主题（Real Subject）类
 */
public class RealSubjectP1 extends AbstractSubject {

    @Override
    public void method() {
        logger.info("真实主题类{}...", this.getClass().getSimpleName());
    }
}
