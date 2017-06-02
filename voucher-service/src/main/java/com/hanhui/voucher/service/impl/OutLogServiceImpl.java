package com.hanhui.voucher.service.impl;

import com.hanhui.voucher.dao.OutLogDao;
import com.hanhui.voucher.entity.OutVoucherLog;
import com.hanhui.voucher.service.OutLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/6/1
 * @版本: 1.0
 */
@Service("outLogService")
public class OutLogServiceImpl implements OutLogService {
    @Autowired
    OutLogDao outLogDao;

    public void insert(OutVoucherLog outVoucherLog) {
        outLogDao.insert(outVoucherLog);
    }
}
