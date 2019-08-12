/**
 * Create Date:2019年8月12日
 */
package com.chenguanghua.cms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenguanghua.common.utils.RandomUitl;
import com.chenguanghua.common.utils.StringUtil;

/**
 * <br>
 * Title:TODO 类标题 <br>
 * Description:TODO 测试jdk类功能描述 <br>
 * Author:陈广华(823865618@qq.com) <br>
 * Date:2019年8月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class TestJdk {
	// 调用user实现序列化
	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;

	@Test
	public void testjdk() {
		List<User> list = new ArrayList<>();
		// 使用RedisTemplate保存上述模拟的十万个user对象到Redis。
		for (int i = 0; i < 100000; i++) {
			list.add(new User(i, StringUtil.generateChineseName(), (RandomUitl.random(1, 2)) == 1 ? "男" : "女" + "",
					"13" + RandomUitl.randomString(9), RandomUitl.random(3, 20) + "@qq.com",
					RandomUitl.random(18, 70) + ""));
		}
		// 开始执行时间
		long startTime = System.currentTimeMillis();
		// 得到值
		for (User user : list) {
			redisTemplate.opsForValue().set("id=" + user.getId() + "name=" + user.getName() + "sex=" + user.getSex()
					+ "phone=" + user.getPhone() + "youx=" + user.getYoux() + "birthday=" + user.getBirthday(), user);
		}
		// 结束执行时间
		long endTime = System.currentTimeMillis();
		// 显示执行的时间
		System.out.println("jdk执行的时间是" + (endTime - startTime));
	}
}
