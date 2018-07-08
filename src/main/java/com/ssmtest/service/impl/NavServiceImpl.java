
package com.ssmtest.service.impl;

import com.ssmtest.dao.NavDao;
import com.ssmtest.entity.Nav;
import com.ssmtest.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavServiceImpl implements NavService {
    @Autowired
    private NavDao navDao;

    @Override
    public List<Nav> queryNavResult(Nav nav) {
        return navDao.queryNavResult(nav);
    }

    @Override
    public int insert(Nav nav) {
        return navDao.insert(nav);
    }

    @Override
    public Nav getNavById(long id) {
        return navDao.getNavById(id);
    }

    @Override
    public int update(Nav nav) {
        return navDao.update(nav);
    }

    @Override
    public int del(long id) {
        return navDao.del(id);
    }

}