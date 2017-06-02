package com.hanhui.voucher.dao.impl;

import com.hanhui.voucher.dao.InstOrderDao;
import com.hanhui.voucher.dao.common.BaseDaoImpl;
import com.hanhui.voucher.entity.InstOrder;
import org.springframework.stereotype.Repository;

/**
 * @描述: 基础实体类，包含各实体公用属性 .
 * @作者: aizen.stark
 * @创建时间: 2017/5/23
 * @版本: 1.0
 */
@Repository("instOrderDao")
public class InstOrderDaoImpl extends BaseDaoImpl<InstOrder> implements InstOrderDao {
}
