package com.domor.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @desc: 发布消息类
 * @auther: liyuyang
 * @date: 2019/12/19
 **/
@Data
public class PubMessage {

    /**
     * clear,清空各种累计时间
     */
    private String c;

    /**
     * PublishTick,设置发送间隔，单位是秒，默认10秒
     */
    private Integer pt;

    /**
     * time,设置设备时间
     */
    @JSONField(format = "yyMMdd HHmmss")
    private Date t;

}
