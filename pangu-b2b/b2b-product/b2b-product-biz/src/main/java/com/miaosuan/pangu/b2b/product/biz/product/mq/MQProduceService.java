package com.miaosuan.pangu.b2b.product.biz.product.mq;

import com.alibaba.fastjson.JSON;
import com.miaosuan.pangu.b2b.product.api.product.mq.MqConst;
import com.miaosuan.pangu.b2b.product.api.product.mq.ProductCreateMqDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-07-14
 * @since 1.0
 */
@Slf4j
@Component
public class MQProduceService {

    @Autowired
    RocketMQTemplate rocketMQTemplate;


    public void send() {

        Long id = RandomUtils.nextLong();

        ProductCreateMqDTO mqDTO = ProductCreateMqDTO.builder()
                                                     .productId(id)
                                                     .productName("name" + id)
                                                     .build();

        rocketMQTemplate.send(MqConst.TOPIC_PRODUCT, MessageBuilder.withPayload(JSON.toJSONString(mqDTO)).build());
    }
}
