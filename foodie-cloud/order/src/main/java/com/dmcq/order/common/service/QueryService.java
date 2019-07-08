package com.dmcq.order.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;


public interface QueryService<T> {

	int countByExample(Object example);

	List<T> selectByExample(Object example);

	T selectOne(T record);

	List<T> select(T record);

	List<T> selectAll();

	T selectOneByExample(Object example);

	PageInfo<T> selectByExample(Object example, RowBounds rowBounds);

	PageInfo<T> selectByRowBounds(T record, RowBounds rowBounds);

	T selectByPrimaryKey(Object id);
}
