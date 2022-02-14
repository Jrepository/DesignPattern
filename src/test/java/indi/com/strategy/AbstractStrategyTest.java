package indi.com.strategy;

import indi.com.base.BaseTest;
import indi.com.strategy.p1.ConcreteStrategyA;
import indi.com.strategy.p1.ConcreteStrategyB;
import indi.com.strategy.p1.Context;
import indi.com.strategy.p2.StrategyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbstractStrategyTest extends BaseTest {


    @Test
    @DisplayName("p1 策略模式测试")
    void processChainTest(){
        Context contextA = new Context(new ConcreteStrategyA());
        contextA.method();
        System.out.println("*********************************");
        Context contextB = new Context(new ConcreteStrategyB());
        contextB.method();
    }

    @Test
    @DisplayName("p2 策略模式测试")
    void checkChainTest(){
        StrategyFactory.getStrategy("C").method();
        System.out.println("*********************************");
        StrategyFactory.getStrategy("D").method();

    }

}
