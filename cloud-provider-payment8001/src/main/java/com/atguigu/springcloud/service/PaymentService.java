package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhengHaoYun  2020/6/26 23:10
 */
public interface PaymentService {

    int create(Payment payment);
    // @Param对应xml文件中的参数，当单数>=2时，推荐使用！
    Payment getPaymentById(@Param("id") Long id);


}
