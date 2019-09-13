package com.test.multiDataSource.dao;

import com.test.multiDataSource.bean.SeckillBean;
import com.test.multiDataSource.util.DataSourceType;
import org.apache.ibatis.annotations.Param;
import com.test.multiDataSource.bean.SeckillBean;

import java.util.Date;
import java.util.List;

/**
 * Created by zhuhp on 2016/12/24.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果返行为>1 ，表示更新成功
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *
     * @param seckillId
     * @return
     */
    @DataSourceType("slaver")
    SeckillBean queryById(long seckillId);

    /**
     *根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<SeckillBean> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
