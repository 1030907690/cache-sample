package com.springboot.sample.bean;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//@TableName("t_article")
public class Article {
    /** id **/
    private Long id;
    /** 文章内容 **/
    private String content;
}
