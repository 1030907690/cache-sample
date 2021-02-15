package com.springboot.sample.controller;

import com.springboot.sample.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @RequestMapping("/detail")
    public String detail(@RequestParam("id") Long id) {
        log.info("ArticleController#detail [ {} ]",id);
        return articleService.detail(id);
    }


}
