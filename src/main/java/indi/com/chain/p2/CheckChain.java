package indi.com.chain.p2;

import indi.com.chain.CheckData;

public class CheckChain {

    Handler firstStepHandler = new FirstStepHandler();
    Handler secondStepHandler = new SecondStepHandler();

    public Handler init(CheckData checkData) {
        firstStepHandler.setCheckData(checkData);
        firstStepHandler.setNextHandler(secondStepHandler);
        return firstStepHandler;
    }
}
