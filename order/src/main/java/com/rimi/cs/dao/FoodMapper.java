package com.rimi.cs.dao;

import com.rimi.cs.pojo.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodid);

    int insert(Food record);

    Food selectByPrimaryKey(Integer foodid);

    List<Food> selectAll();

    int updateByPrimaryKey(Food record);

    List<Food> selectCount();

    List<Food> selectFood(@Param("foodname") String foodname);

}