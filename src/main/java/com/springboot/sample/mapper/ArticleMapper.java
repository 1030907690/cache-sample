package com.springboot.sample.mapper;

import com.springboot.sample.bean.Article;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("SELECT id,content FROM t_article  WHERE #{random}=#{random} and id = #{id}")
    Article findById(@Param("random") Integer random, @Param("id") Long id);

}