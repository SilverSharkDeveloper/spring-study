package com.example.mybatis.mapper;

import com.example.mybatis.domain.OrderDTO;
import com.example.mybatis.domain.PayDTO;
import com.example.mybatis.domain.ProductOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductOrderMapper productOrderMapper;
    @Autowired
    private PayMapper payMapper;

    @Test
    public void test(){
        List<OrderDTO> orderDTOS = orderMapper.selectAll();
        orderDTOS.stream().forEach(orderDTO -> {
            productOrderMapper.selectProducts(orderDTO.getId()).stream().map(ProductOrder::getProductId)
                    .forEach(productId ->  orderDTO.getProducts().add(productMapper.select(productId)));
        });

        List<PayDTO> payDTOs = payMapper.selectAll(3L);
        payDTOs.stream().forEach(payDTO -> {

            orderDTOS.stream().filter(orderDTO -> orderDTO.getId() == payDTO.getOrderId()).forEach(orderDTO ->payDTO.getOrders().add(orderDTO));
        });


        log.info(orderDTOS.toString());
        log.info(payDTOs.toString());
    }
}





















