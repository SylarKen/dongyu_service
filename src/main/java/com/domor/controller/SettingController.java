package com.domor.controller;

import com.domor.domain.PubMessage;
import com.domor.domain.Result;
import com.domor.mqtt.MqServer;
import com.domor.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @desc: 对外接口类，设置硬件参数
 * @auther: liyuyang
 * @date: 2019/12/14
 **/
@Slf4j
@RestController
public class SettingController {

    @Autowired
    private QuartzService quartzService;

    /**
     * 设置数据发送间隔
     * @param interval 间隔（秒）
     * @return Result
     */
    @RequestMapping("/setSendInterval")
    public Result setSendInterval(int interval){
        try {
            log.info(">>>>>>>>>>>>>>>>>>>>设置数据发送间隔");
            List<Map<String, Object>> devices = quartzService.getAllDevices();
            MqServer mqServer = new MqServer();
            for (Map<String, Object> device : devices) {
                String topic = MapUtils.getString(device, "topic");
                if (topic != null && !topic.isEmpty()) {
                    PubMessage pm = new PubMessage();
                    pm.setPt(interval);
                    mqServer.publish(topic, pm);
                }
            }
            mqServer.stop();
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

}
