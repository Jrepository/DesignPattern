package indi.com.chain.p1;

import indi.com.chain.CheckData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Configuration
public class ChainFactory {

    @Autowired
    List<Handler> chains;

    /**
     * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的初始化方法)
     */
    @PostConstruct
    private void initChain() {
        Collections.sort(chains, AnnotationAwareOrderComparator.INSTANCE);
        int size = chains.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                chains.get(i).setNextHandler(null);
            } else {
                chains.get(i).setNextHandler(chains.get(i + 1));
            }
        }
    }


    /**
     * 责任链
     * @param index 执行的起始节点
     * @param checkData
     */
    public void processChain(int index, CheckData checkData) {
        chains.get(index - 1).process(checkData);
    }
}
