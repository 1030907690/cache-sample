package com.springboot.sample.bean;

import lombok.Data;

@Data
public class Article {
    /** id **/
    private Long id;
    /** 文章内容 **/
    private String content;
}
