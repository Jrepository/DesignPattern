package indi.com.chain.p1;

import indi.com.chain.CheckData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Handler {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }


    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void process(CheckData checkData) {
        Boolean result = this.doProcess(checkData);
        if ((null == result || result) && null != this.getNextHandler()) {
            this.getNextHandler().process(checkData);
        }
    }

    protected abstract boolean doProcess(CheckData checkData);
}
