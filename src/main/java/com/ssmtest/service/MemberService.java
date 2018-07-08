package com.ssmtest.service;


import com.ssmtest.entity.Member;


public interface MemberService {
    Member doLogin(Member member);

    int update(Member member);
}