package org.example.hwshoppingmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.hwshoppingmall.model.Order;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
