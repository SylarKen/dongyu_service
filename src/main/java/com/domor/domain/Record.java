package com.domor.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @desc: 设备信息实体类
 * @auther: liyuyang
 * @date: 2019/12/12
 **/
@Data
public class Record {

    /**
     * 设备编号
     */
    private String devCode;

    /**
     * publishReason 发布原因
     * "c"=change变位，"r"=realTime实时，"p"=powerReset 上电重启
     */
    private String pr;

    /**
     * devStatus 设备状态
     * "r"=devRun、"o"=devOn、"s"=devShutDown
     */
    private String ds;

    /**
     * devStatusChange  设备状态改变
     * "r-o"=run2on 、"r-s"=run2shutDown、"o-r"=on2run 、"o-s"=on2shutDown、"s-r"=shutDown2run、"s-o"=shutDown2on;
     */
    private String dsc;

    /**
     * runTimeAcc 运行累计时间，单位：秒
     */
    private int rta;

    /**
     * onTimeAcc 设备上电时间，单位：秒
     */
    private int ota;

    /**
     * shutDownTimeAcc设备关闭时间，单位：秒
     */
    private int sta;

    /**
     * devPower 设备功率，单位：W
     */
    private float dp;

    /**
     * devCurrent 设备电流，单位 A
     */
    private float dc0;
    /**
     * devCurrent 设备电流，单位 A
     */
    private float dc1;
    /**
     * devCurrent 设备电流，单位 A
     */
    private float dc2;

    /**
     * devVoltage 设备电压，单位 V
     */
    private float dv0;
    /**
     * devVoltage 设备电压，单位 V
     */
    private float dv1;
    /**
     * devVoltage 设备电压，单位 V
     */
    private float dv2;
    /**
     * devBeat 设备节拍
     */
    private String db;

    /**
     * devFireNum 设备火枪个数
     */
    private String dfn;

    /**
     * time，时间
     */
    @JSONField(format = "yyMMdd HHmmss")
    private Date t;
    /**
     * time，变位时间
     */
    @JSONField(format = "yyMMdd HHmmss")
    private Date f;

    /**
     * time，时间
     */
    private Date createTime;

}
