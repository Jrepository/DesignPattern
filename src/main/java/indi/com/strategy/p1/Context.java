package indi.com.strategy.p1;

import indi.com.strategy.AbstractStrategy;

/**
 * 环境(Context)角色
 */
public class Context {

    /**
     * 持有策略抽象类
     */
    private AbstractStrategy abstractStrategy;

    // 通过构造方法注入，也可以通过其他方式注入
    public Context(AbstractStrategy abstractStrategy) {
        this.abstractStrategy = abstractStrategy;
    }

    public void method() {
        abstractStrategy.method();
    }

}