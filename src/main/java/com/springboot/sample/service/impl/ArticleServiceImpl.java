package com.springboot.sample.service.impl;

import com.springboot.sample.bean.Article;
import com.springboot.sample.mapper.ArticleMapper;
import com.springboot.sample.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;

    private int count = 0;

    @Override
    public String detail(Long id) {
        count++;
        Article article = articleMapper.findById(count, id);
//        Article article = articleMapper.selectById(id);
        if (null != article) {
            return article.getContent();
        } else {
            return "没有您要找的文章";
        }
    }
}
