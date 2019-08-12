/**
 * Create Date:2019年8月12日
 */
package com.chenguanghua.cms;

import java.io.Serializable;
import java.util.HashMap;

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
 * Description:TODO hashjson类功能描述 <br>
 * Author:陈广华(823865618@qq.com) <br>
 * Date:2019年8月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans2.xml")
public class Hashjson {
	// 调用user
	@Resource
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void Hashtext() {
		HashMap<String, Serializable> map = new HashMap<>();
		// 使用RedisTemplate保存上述模拟的十万个user对象到Redis。
		for (int i = 0; i < 100000; i++) {
			map.put("" + i,
					new User(i, StringUtil.generateChineseName(), (RandomUitl.random(1, 2)) == 1 ? "男" : "女" + "",
							"13" + RandomUitl.randomString(9), RandomUitl.random(3, 20) + "@qq.com",
							RandomUitl.random(18, 70) + ""));
		}
		// 开始执行时间
		long startTime = System.currentTimeMillis();
		// 得到值
		redisTemplate.opsForHash().putAll("map", map);
		// 结束执行时间
		long endTime = System.currentTimeMillis();
		// 显示执行的时间
		System.out.println("hashjson执行的时间是" + (endTime - startTime));
	}

}
