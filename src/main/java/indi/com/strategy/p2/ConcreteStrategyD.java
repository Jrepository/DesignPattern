package indi.com.strategy.p2;

import indi.com.strategy.AbstractStrategy;
import org.springframework.stereotype.Component;

/**
 * 具体策略(ConcreteStrategy)角色
 */
@Component
public class ConcreteStrategyD extends AbstractStrategy {
    @Override
    public void method() {
        logger.info("具体策略角色{}...", this.getClass().getSimpleName());
    }
}
