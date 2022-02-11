package indi.com.chain.p2;

import com.sun.deploy.util.StringUtils;
import indi.com.chain.CheckData;
import indi.com.chain.CheckResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Handler {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 数据
     */
    private CheckData checkData;

    /**
     * 持有后继的责任对象
     */
    private Handler nextHandler;

    public CheckData getCheckData() {
        return checkData;
    }

    public void setCheckData(CheckData checkData) {
        this.checkData = checkData;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }


    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }


    /**
     * 执行下一链 全链错误数据收集
     *
     * @param content 链参数
     * @param result  返回值
     * @return
     */
    public List<CheckResult> doNextHandler(Map content, List<CheckResult> result) {
        if (this.nextHandler == null) {
            return result;
        }
        // 到货数据传递
        this.nextHandler.setCheckData(this.getCheckData());
        List<CheckResult> tempResult = this.nextHandler.handleRequest(content);
        if (result == null) {
            result = new ArrayList<>();
        }
        result.addAll(tempResult);
        return result;
    }

    public abstract List<CheckResult> handleRequest(Map content);


    /**
     * 该方法未验证
     * @param content
     * @throws Exception
     */
//    public void handle(Map content) throws Exception {
//        List<CheckResult> checkResult = this.handleRequest(content);
//        if (!CollectionUtils.isEmpty(checkResult)) {
//            List<String> checkDataMsg = null;
//            // 校验不通过 抛出异常
//            String errorMsg = StringUtils.join(checkDataMsg, ";");
//            throw new Exception(errorMsg);
//        }
//        if (null != this.nextHandler) {
//            this.nextHandler.handle(content);
//        }
//    }

    /**
     * 该方法未验证
     *
     * @param content
     * @return
     */
//    public List<CheckResult> doNextHandler2(Map content, List<CheckResult> result) {
//        if (this.nextHandler == null) {
//            return result;
//        }
//        // 到货数据传递
//        this.nextHandler.setCheckData(this.getCheckData());
//        List<CheckResult> tempResult = this.nextHandler.check(content);
//        if (CollectionUtils.isEmpty(tempResult)) {
//            result.addAll(tempResult);
//            this.doNextHandler2(content, result);
//        }
//        return result;
//    }
//
//    protected abstract List<CheckResult> check(Map content);


//    protected void handle(Map content) throws Exception {
//        List<CheckResult> checkResult = this.handleRequest(content);
//        // 校验数据  如果不正确 这里给出错误信息
//        if (checkResult != null && checkResult.size() > 0) {
//            List<String> checkDataMsg = null;
//            // 校验不通过 抛出异常
//            String errorMsg = StringUtils.join(checkDataMsg, ";");
//            throw new Exception(errorMsg);
//        }
//    }

}
