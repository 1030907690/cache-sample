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

    @Override
    public String detail(Long id) {
        int random = (int) Math.random() * 1000;
        Article article = articleMapper.findById(random, id);
        if (null != article) {
            return article.getContent();
        } else {
            return "没有您要找的文章";
        }
    }
}
