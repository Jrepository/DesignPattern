package indi.com.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象策略(Strategy)角色
 */
public abstract class AbstractStrategy {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

   public abstract void method();
}
