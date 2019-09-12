package com.test.multiDataSource.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuhp on 2016/12/24.
 */
public class SuccessKilledBean implements Serializable {

    private static final long serialVersionUID = -1L;

    private long seckillId;

    private long userPhoe;

    private short state;

    private Date createTime;

    //变通，多对一
    private SeckillBean seckill;

    public long getSeckillId() {

        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhoe() {
        return userPhoe;
    }

    public void setUserPhoe(long userPhoe) {
        this.userPhoe = userPhoe;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SeckillBean getSeckill() {

        return seckill;
    }

    public void setSeckill(SeckillBean seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilledBean{" +
                "seckillId=" + seckillId +
                ", userPhoe=" + userPhoe +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }


}
