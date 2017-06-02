package com.hanhui.voucher.common.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public class Extension implements Serializable {

    private static final long serialVersionUID = 8034857888313309344L;

    private List<Kvp> entryList = new ArrayList();

    public Extension() {
    }

    public void add(String key, String value) {
        this.remove(key);
        this.entryList.add(new Kvp(key, value));
    }

    public String getValue(String key) {
        if(this.entryList != null && this.entryList.size() != 0) {
            Iterator var2 = this.entryList.iterator();

            Kvp kvp;
            do {
                if(!var2.hasNext()) {
                    return null;
                }
                kvp = (Kvp)var2.next();
            } while(kvp == null || !StringUtils.equals(kvp.getKey(), key));
            return kvp.getValue();
        } else {
            return null;
        }
    }

    public void remove(String key) {
        if(this.entryList != null && this.entryList.size() != 0) {
            Iterator it = this.entryList.iterator();

            Kvp kvp;
            do {
                if(!it.hasNext()) {
                    return;
                }

                kvp = (Kvp)it.next();
            } while(kvp == null || !StringUtils.equals(kvp.getKey(), key));

            it.remove();
        }
    }

    public List<Kvp> getEntryList() {
        return this.entryList;
    }

    public void setEntryList(List<Kvp> entryList) {
        this.entryList = entryList;
    }
}
