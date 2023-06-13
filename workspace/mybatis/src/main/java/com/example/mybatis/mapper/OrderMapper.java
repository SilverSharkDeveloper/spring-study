package com.example.mybatis.mapper;

import com.example.mybatis.domain.Order;
import com.example.mybatis.domain.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface OrderMapper {
//    주문 내역
    public List<OrderDTO> selectAll();
}
