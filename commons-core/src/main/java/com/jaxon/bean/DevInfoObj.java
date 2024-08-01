package com.jaxon.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 设备信息
 *
 * @Author:blueskyevil
 * @Date:2022/3/7
 */
@Data
public class DevInfoObj implements Serializable {
    /**
     * 路由器sn码
     */
    private String sn;
    /**
     * 路由器型号
     */
    private String model;
    /**
     * 设备类型
     */
    private String devType;
    /**
     * 厂商ID
     */
    private String manu;
    /**
     * 产品ID
     */
    private String prodId;
    /**
     * 路由器MAC地址
     */
    private String mac;
    /**
     * 硬件版本
     */
    private String hwv;
    /**
     * 软件版本
     */
    private String swv;
    /**
     * 协议类型
     * 1: WiFi
     * 2: Z-Wave
     * 3: ZigBee
     * 4: BLE
     */
    private int protType;
}
