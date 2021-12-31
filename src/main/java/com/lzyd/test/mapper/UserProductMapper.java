package com.lzyd.test.mapper;

import com.lzyd.test.pojo.UserProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserProduct record);

    int insertSelective(UserProduct record);

    UserProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserProduct record);

    void updateByPrimaryKey(UserProduct record);
}