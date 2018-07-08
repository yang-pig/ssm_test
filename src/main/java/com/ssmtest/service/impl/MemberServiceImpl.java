package com.ssmtest.service.impl;

import com.ssmtest.dao.MemberDao;

import com.ssmtest.entity.Member;

import com.ssmtest.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member doLogin(Member member) {
        return memberDao.doLogin(member);
    }

    @Override
    public int update(Member member) {
        return memberDao.update(member);
    }
}