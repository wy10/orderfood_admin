package com.rimi.cs.dao;

import com.rimi.cs.pojo.Orderfood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderfoodMapper {
    int deleteByPrimaryKey(@Param("foodid") Integer foodid, @Param("userid") Integer userid);

    int insert(Orderfood record);

    List<Orderfood> selectByPrimaryKey( @Param("userid") Integer userid);

    List<Orderfood> selectAll();

    int updateByPrimaryKey(Orderfood record);

}