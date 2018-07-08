package com.ssmtest.dao;



import com.ssmtest.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {


    Member doLogin(Member member);

    int update(Member member);

}