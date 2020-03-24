package com.miaosuan.pangu.b2b.product.biz.product.mq;

import com.miaosuan.pangu.b2b.common.core.ModuleConst;
import com.miaosuan.pangu.b2b.product.api.product.mq.MqConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
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
@RocketMQMessageListener(
        topic = MqConst.TOPIC_PRODUCT,
        consumerGroup = ModuleConst.PRODUCT_SERVICE)
public class MQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info(" receive mq message={} ", message);

        log.info("do something");

        log.info("mq suc");
    }
}
