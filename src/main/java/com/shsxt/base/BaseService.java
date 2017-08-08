package com.shsxt.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * baseService 简单封装
 * @author lp
 *
 */
public abstract class BaseService<T> {
	 
	@Autowired
	private BaseDao<T> baseDao;
	
	/**
	 * 添加记录
	 * @param entity
	 * @return
	 */
	public Integer insert(T entity){
		return baseDao.insert(entity);
	}
	
	
	/**
	 * 批量添加
	 * @param entities
	 * @return
	 */
	public Integer insertBatch(List<T> entities){
		return baseDao.insertBatch(entities);
	}
	
	
	/**
	 * 查询记录根据id
	 * @param id
	 * @return
	 */
	public T queryById(Integer id){
		AssertUtil.isTrue(null==id||id<=0,"id 非法!");
		return baseDao.queryById(id);
	}
	
	
	/**
	 * 多参数分页查询记录
	 * @param baseQuery
	 * @return
	 */
	public PageInfo<T> queryForPage(BaseQuery baseQuery){
		PageHelper.startPage(baseQuery.getPage(), baseQuery.getRows());
		return new PageInfo<T>(baseDao.queryForPage(baseQuery));
	}
	
	
	/**
	 * 更新记录
	 * @param entity
	 * @return
	 */
	public Integer update(T entity){
		return baseDao.update(entity);
	}
	
	/**
	 * 批量更新记录
	 * @param entities
	 * @return
	 */
	public Integer updateBatch(List<T> entities){
		AssertUtil.isTrue(null==entities||entities.size()==0, "待添加的记录不能为空!");
		return baseDao.updateBatch(entities);
	}
	
	
	/**
	 * 删除单条记录
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id){
		AssertUtil.isTrue(null==id||id<=0||null==queryById(id), "id 非法!");
		return baseDao.delete(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public Integer deleteBatch(Integer[] ids){
		AssertUtil.isTrue(null==ids||ids.length==0,"id 记录非法!");
		return baseDao.deleteBatch(ids);
	}
	
	

}
