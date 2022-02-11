package indi.com.chain.p1;

import indi.com.chain.CheckData;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class FirstStepHandler extends Handler {

    @Override
    protected boolean doProcess(CheckData checkData) {
        logger.info("this class package:{}", this.getClass().getPackage());
        logger.info("this class name:{}", this.getClass().getSimpleName());
        return true;
    }
}
