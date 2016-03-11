package cn.itcast.oa.test;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	private ApplicationContext ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
	//测试SessionFactory
	@Test
	public void getSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		assertNotNull(sessionFactory.openSession());
	}
	//测试事务管理
	@Test
	public void testTxManager(){
		TestService testService = (TestService) ac.getBean("testService");
		testService.addUsers();
	}
	//测试action对象的管理
	@Test
	public void testAction(){
		TestAction testAction = (TestAction) ac.getBean("testAction");
		
		System.out.println(testAction);
	}
}
