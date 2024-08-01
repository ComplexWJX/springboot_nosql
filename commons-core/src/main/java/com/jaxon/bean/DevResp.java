package com.jaxon.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class DevResp extends DevInfoObj {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deviceId;

    private String vendorName;

    private String deviceIp;

    private Long reportTime;

    private String loid;

    private String netAccount;

    private String netType;

    private String onlineTime;

    private String onlineStatus;

    private Integer onlineStatusOld;

    private String cpuRate;

    private String memRate;

    private String upRealRate;

    private String downRealRate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String adaptRate;

    private Long lastTime;

    private String rmsModelName;

    private String cityName;

    private Long cpeCurrentUpdateTime;
}
