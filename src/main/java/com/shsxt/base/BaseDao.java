package com.shsxt.base;

import java.util.List;

/**
 * 
 * @author lp
 * baseDao 简单封装
 */
public interface BaseDao<T> {
	/**
	 * 添加记录
	 * @param entity
	 * @return
	 */
	public Integer insert(T entity);
	
	
	/**
	 * 批量添加
	 * @param entities
	 * @return
	 */
	public Integer insertBatch(List<T> entities);
	
	
	/**
	 * 查询记录根据id
	 * @param id
	 * @return
	 */
	public T queryById(Integer id);
	
	
	/**
	 * 多参数分页查询记录
	 * @param baseQuery
	 * @return
	 */
	public List<T> queryForPage(BaseQuery baseQuery);
	
	
	/**
	 * 更新记录
	 * @param entity
	 * @return
	 */
	public Integer update(T entity);
	
	/**
	 * 批量更新记录
	 * @param entities
	 * @return
	 */
	public Integer updateBatch(List<T> entities);
	
	
	/**
	 * 删除单条记录
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public Integer deleteBatch(Integer[] ids);
	
	
	
	

}
