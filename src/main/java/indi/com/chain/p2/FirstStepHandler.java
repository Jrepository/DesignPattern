package indi.com.chain.p2;

import indi.com.chain.CheckData;
import indi.com.chain.CheckResult;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FirstStepHandler extends Handler {

    @Override
    public List<CheckResult> handleRequest(Map content) {
        List<CheckResult> checkResultList = this.checkData(content, this.getCheckData());
        return CollectionUtils.isEmpty(checkResultList) ? this.doNextHandler(content, checkResultList) : checkResultList;
    }

    private List<CheckResult> checkData(Map content, CheckData checkData) {
        logger.info("this class package:{}", this.getClass().getPackage());
        logger.info("this class name:{}", this.getClass().getSimpleName());
        return Collections.emptyList();
    }
}
