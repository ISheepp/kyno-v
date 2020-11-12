package com.codelin.mapper;

import com.codelin.bean.Position;
import com.codelin.bean.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPosition();

    // 批量删除操作
    Integer deletePositionByIds(@Param("ids") Integer[] ids);
}