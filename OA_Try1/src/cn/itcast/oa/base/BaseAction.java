package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.UserService;


public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	// =======================================
	@Resource
	protected UserService userService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;

	// ====================================

	protected T model;

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

}
