package indi.com.chain.p2;

import indi.com.chain.CheckData;

public class CheckChainBase {


    Handler firstStepHandler = new FirstStepHandler();
    Handler secondStepHandler = new SecondStepHandler();

    public Handler init(CheckData checkData) {
        firstStepHandler.setCheckData(checkData);
        firstStepHandler.setNextHandler(secondStepHandler);
        return firstStepHandler;
    }

    public void setNextHandler(Handler superHandler, Handler nHandler) {
        Handler nextHandler = superHandler.getNextHandler();
        while (null != nextHandler && null != nextHandler.getNextHandler()){
            nextHandler = nextHandler.getNextHandler();
        }
        nextHandler.setNextHandler(nHandler);
    }
}
