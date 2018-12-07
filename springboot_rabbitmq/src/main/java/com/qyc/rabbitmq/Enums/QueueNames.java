package com.qyc.rabbitmq.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueueNames {
    ONETOMANY_NAME(1,"oneToMany","一对一"),
    MANYTOMANY_NAME(2,"manyToMany","多对多");

    private Integer code;
    private String val;
    private String msg;
}
