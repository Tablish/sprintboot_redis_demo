package com.Entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/15
 * @Modified By
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial implements Serializable{

    private Long id;
    private String name;//教程名称

    //setters and getters
    //toString
}
