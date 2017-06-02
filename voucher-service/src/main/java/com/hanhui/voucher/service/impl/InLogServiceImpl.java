package com.hanhui.voucher.service.impl;

import com.hanhui.voucher.dao.InLogDao;
import com.hanhui.voucher.entity.InVoucherLog;
import com.hanhui.voucher.service.InLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/6/1
 * @版本: 1.0
 */
@Service("inLogService")
public class InLogServiceImpl implements InLogService {

    @Autowired
    InLogDao inLogDao;

    /**
     * 插入日志
     *
     * @param inVoucherLog
     */
    public void insert(InVoucherLog inVoucherLog) {
        inLogDao.insert(inVoucherLog);
    }
}
