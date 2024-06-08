package org.example.hwshoppingmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.hwshoppingmall.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {
}
