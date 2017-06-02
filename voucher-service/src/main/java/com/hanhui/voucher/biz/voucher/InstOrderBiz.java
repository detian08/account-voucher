package com.hanhui.voucher.biz.voucher;

import com.hanhui.voucher.dao.InstOrderDao;
import com.hanhui.voucher.entity.InstOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
@Service("instOrderBiz")
public class InstOrderBiz {

    @Autowired
    InstOrderDao instOrderDao;


    /**
     * 插入订单记录
     * @param instOrder
     */
    public void insert(InstOrder instOrder) {
        instOrderDao.insert(instOrder);
    }


}
