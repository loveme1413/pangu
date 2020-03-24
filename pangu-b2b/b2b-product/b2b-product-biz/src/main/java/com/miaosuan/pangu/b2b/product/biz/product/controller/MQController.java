package com.miaosuan.pangu.b2b.product.biz.product.controller;

import com.miaosuan.pangu.b2b.product.biz.product.mq.MQProduceService;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-07-14
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/product/mq")
public class MQController {

    @Autowired
    private MQProduceService mqProduceService;

    @GetMapping("/send")
    public Result createAndSendMq() {

        //for test
        mqProduceService.send();

        return Result.success();
    }

}
