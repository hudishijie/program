package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz = null;

	public DaoSupportImpl() {
		// 通过反射获取父类泛型的真实类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("------>clazz  " + clazz);
	}

	/**
	 * 获取当前session对象
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			return;
		}
		Object entity = getById(id);
		if (entity != null) {
			getSession().delete(entity);
		}

	}

	@Override
	public void update(T entity) {
		if (entity != null) {
			getSession().update(entity);
		}
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		return getSession()
				.createQuery(//
						"from " + clazz.getSimpleName() + " where id in (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	@Override
	public List<T> findAll() {
		return getSession()
				.createQuery(//
						// 注意空格
						"from " + clazz.getSimpleName())//
				.list();
	}

}
