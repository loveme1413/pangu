package com.miaosuan.pangu.core.common.event;

import com.google.common.eventbus.Subscribe;
import com.miaosuan.pangu.core.common.AbstractCommonTest;
import com.miaosuan.pangu.core.common.event.util.EventUtil;
import com.miaosuan.pangu.core.common.util.RandomUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
public class EventUtilTest extends AbstractCommonTest {


    @Before
    public void init() {
        EventUtil.BUS.register(this);
    }

    @Subscribe
    public void handleEvent(EventDTO dto) {
        log.info("handleEvent eventDTO={}", dto);

        log.info("handleEvent end.");
    }

    @Test
    public void run17() throws Exception {
        log.info("send event");

        EventDTO dto = new EventDTO();

        dto.setId(RandomUtil.uuid());


        EventUtil.BUS.post(dto);

        TimeUnit.SECONDS.sleep(3);
    }


    @Data
    class EventDTO {
        private String id;
    }
}
