package utils;

import com.hanhui.voucher.entity.InVoucherLog;

import java.util.Date;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/6/5
 * @版本: 1.0
 */
public class LogUtils {

    /**
     * 构造插入日志
     *
     * @param activeCode
     * @param activeName
     * @param reqInfo
     * @param reqNo
     * @return
     */

    public static InVoucherLog buildInVoucherLog(String activeCode, String activeName, String reqInfo, String reqNo) {
        InVoucherLog inVoucherLog = new InVoucherLog();
        inVoucherLog.setActionCode(activeCode);
        inVoucherLog.setActionName(activeName);
        inVoucherLog.setGmtCreate(new Date());
        inVoucherLog.setReqInfo(reqInfo);
        inVoucherLog.setReqNo(reqNo);
        return inVoucherLog;
    }
}
