package com.jd.jdd.jrs.mp.base.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface BaseRepository<T,V> extends IService<T> {

    V getEntityById(String id);

    List<V> search(V v);

    List<V> search(Map<String,Object> queryParams);

    V saveUpdateEntity(V v);

    boolean SaveUpdateBatchEntity(List<V> v);

    Page page(V v);

}
