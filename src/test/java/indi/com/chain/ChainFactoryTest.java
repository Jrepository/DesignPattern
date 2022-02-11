package indi.com.chain;

import indi.com.base.BaseTest;
import indi.com.chain.p1.ChainFactory;
import indi.com.chain.p2.CheckChain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class ChainFactoryTest extends BaseTest {

    @Autowired
    ChainFactory chainFactory;

    @Test
    @DisplayName("p1 责任链测试")
    void processChainTest(){
        CheckData checkData = new CheckData<>();
        chainFactory.processChain(1,checkData);
    }

    @Test
    @DisplayName("p2 责任链测试")
    void checkChainTest(){
        CheckData checkData = new CheckData<>();
        new CheckChain().init(checkData).handleRequest(new HashMap());
    }

}
