package com.qyc.Bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/11/27
 * @Modified By
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;

    private String id;
    private String username;
    private String password;

}
