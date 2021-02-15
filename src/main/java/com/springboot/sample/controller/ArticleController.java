package com.springboot.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @RequestMapping("/detail")
    public String detail(@RequestParam("id") Long id) {
        log.info("ArticleController#detail [ {} ]",id);
        return articleContainer.getOrDefault(id, "没有您要找的文章");
    }

    private final Map<Long, String> articleContainer = new HashMap<Long, String>() {{
        put(1L, "<p>\n" +
                "\tThink Different\n" +
                "</p>\n" +
                "<p>\n" +
                "\tHere’s to the crazy ones. The misfits. The rebels. The troublemakers. The round pegs in the square holes. The ones who see things differently. They’re not fond of rules. And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them. About the only thing you can’t do is ignore them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius. Because the people who are crazy enough to think they can change the world, are the ones who do.\n" +
                "</p>\n" +
                "<p>\n" +
                "\t- Apple Inc.\n" +
                "</p>");
    }};

}
