package indi.com.strategy.p2;

import indi.com.strategy.AbstractStrategy;
import indi.com.util.SpringUtil;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private static final Map<String, String> TypeMap = new HashMap<String, String>() {
        {
            put("C", "concreteStrategyC");
            put("D", "concreteStrategyD");
        }
    };

    public static AbstractStrategy getStrategy(String type){
        return (AbstractStrategy) SpringUtil.getBean(TypeMap.get(type));

    }

}
