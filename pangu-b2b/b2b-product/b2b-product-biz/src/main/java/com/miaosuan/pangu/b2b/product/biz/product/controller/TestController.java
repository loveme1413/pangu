package com.miaosuan.pangu.b2b.product.biz.product.controller;

import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 模块名
 *
 * @author spy
 * @version 1.0 2019-06-06
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {


    @PostMapping("/hello")
    public Result hello(@RequestParam String name) {
        log.info("name=[{}]", name);
        return Result.success();
    }

    @PostMapping("/hello2")
    public Result hell2(@RequestBody String str) {
        log.info("str=[{}]", str);
        return Result.success();
    }
}
