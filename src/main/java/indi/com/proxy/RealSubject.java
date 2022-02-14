package indi.com.proxy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * * 真实主题（Real Subject）类
 */
public class RealSubject implements Subject {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void method() {
        logger.info("真实主题类{}...", this.getClass().getSimpleName());
    }
}
