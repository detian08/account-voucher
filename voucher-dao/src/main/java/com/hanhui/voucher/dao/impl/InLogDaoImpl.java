package com.hanhui.voucher.dao.impl;

import com.hanhui.voucher.dao.InLogDao;
import com.hanhui.voucher.dao.common.BaseDaoImpl;
import com.hanhui.voucher.entity.InVoucherLog;
import org.springframework.stereotype.Repository;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/26
 * @版本: 1.0
 */
@Repository("inLogDao")
public class InLogDaoImpl extends BaseDaoImpl<InVoucherLog> implements InLogDao {
}
