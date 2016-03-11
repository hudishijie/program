package cn.itcast.oa.base;

import java.util.List;

public interface DaoSupport<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 根据id删除实体
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 通过id查询实体
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * 通过数组ids查询查询多个实体
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();

}
