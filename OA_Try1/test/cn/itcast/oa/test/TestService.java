package cn.itcast.oa.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.User;

//Service测试类
@Service
public class TestService {
	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void addUsers() {
		sessionFactory.getCurrentSession().save(new User());
		// int i = 1/0;//用来测试事务是否管理好，报错时前一行代码已提交，报错后应回滚。
		sessionFactory.getCurrentSession().save(new User());
	}

}
