package indi.com.strategy;

import indi.com.base.BaseTest;
import indi.com.strategy.p1.ConcreteStrategyA;
import indi.com.strategy.p1.ConcreteStrategyB;
import indi.com.strategy.p1.Context;
import indi.com.strategy.p2.StrategyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class AbstractStrategyTest extends BaseTest {

    @Resource
    private List<AbstractStrategy> strategyList;


    @Test
    @DisplayName("p1 策略模式测试")
    void strategyContextTest() {
        Context contextA = new Context(new ConcreteStrategyA());
        contextA.method();
        System.out.println("*********************************");
        Context contextB = new Context(new ConcreteStrategyB());
        contextB.method();
    }

    @Test
    @DisplayName("p2 策略模式测试")
    void strategyFactoryTest() {
        StrategyFactory.getStrategy("C").method();
        System.out.println("*********************************");
        StrategyFactory.getStrategy("D").method();

    }


    @Test
    @DisplayName("p2 策略模式测试-方式2")
    void strategyTest() {
        String type = "C";
        Optional<AbstractStrategy> strategyOptional = strategyList.stream()
                .filter(item -> type.equalsIgnoreCase(item.getType())).findFirst();
        // 找到策略就执行策略
        if (strategyOptional.isPresent()) {
            strategyOptional.get().method();
        }
    }
}
