package com.springboot.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.sample.bean.Article;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("SELECT id,content FROM t_article  WHERE #{count}=#{count} and id = #{id}")
    Article findById(@Param("count") Integer count, @Param("id") Long id);

}