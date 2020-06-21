package com.jd.jdd.jrs.mp.base.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BaseRepository<T,V> extends IService<T> {

    V getEntityById(String id);

    List<V> search(V v);

    V saveUpdateEntity(V v);

    boolean SaveUpdateBatchEntity(List<V> v);

}
