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
public class Author implements Serializable{
        /**
         * 作者id
         */
        private Long id;
        /**
         * 作者姓名
         */
        private String name;
        /**
         * 作者简介
         */
        private String remark;

        //setters and getters
        //toString


}
