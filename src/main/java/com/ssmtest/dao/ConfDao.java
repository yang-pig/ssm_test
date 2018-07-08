package com.ssmtest.dao;


import com.ssmtest.entity.Conf;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfDao {


    Conf getConfById(long id);

    int update(Conf conf);

}