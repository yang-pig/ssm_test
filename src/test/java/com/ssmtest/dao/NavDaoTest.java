package com.ssmtest.dao;

import com.ssmtest.BaseTest;
import com.ssmtest.entity.Nav;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NavDaoTest extends BaseTest {
	@Autowired
	private NavDao navDao;


	@Ignore
	@Test
	public void queryNavResult() {

		Nav nav = new Nav();
		nav.setTid(0);

		List<Nav> navs =  navDao.queryNavResult(nav);
		System.out.println(navs.toString());

		nav.setTid(1);

		List<Nav> navs2 =  navDao.queryNavResult(nav);
		System.out.println(navs2.toString());


	}



}
