package org.example.hwshoppingmall.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.hwshoppingmall.model.Product;


@Mapper
public interface ProductDao extends BaseMapper<Product> {

}