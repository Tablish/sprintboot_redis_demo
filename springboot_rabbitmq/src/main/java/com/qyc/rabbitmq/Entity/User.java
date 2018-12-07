package com.qyc.rabbitmq.Entity;

import lombok.*;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 17:59
 * @Modified By
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String password;
}
