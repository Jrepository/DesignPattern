package indi.com.proxy.p1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象主题（Subject）类
 */
public abstract class AbstractSubject {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract void method();
}
