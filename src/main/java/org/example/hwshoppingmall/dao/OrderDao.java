package org.example.hwshoppingmall.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.example.hwshoppingmall.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
}
