package indi.com.strategy.p1;

import indi.com.strategy.AbstractStrategy;

/**
 * 具体策略(ConcreteStrategy)角色
 */
public class ConcreteStrategyB extends AbstractStrategy {
    @Override
    public void method() {
        logger.info("具体策略角色{}...", this.getClass().getSimpleName());
    }
}
