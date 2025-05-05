package com.github.lzpdark.elasticsearchdemo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.CharEncoding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lzp
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    // refer to: https://github.com/infinilabs/analysis-ik
    private final String lastModified = "" + System.currentTimeMillis();
    private final String lastModifiedKey = "Last-Modified";
    private final String tag = "hot-reload-01";
    private final String tagKey = "ETag";


    @GetMapping("/ext_dict")
    public Object extDict(HttpServletResponse response) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader(tagKey, tag);
        response.setHeader(lastModifiedKey, lastModified);
        List<String> words = new ArrayList<>();
        words.add("大但");
        words.add("嗷纷");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(word);
            res.append("\n");
        }
        return res.toString();
    }


    @GetMapping("/ext_stopwords")
    public Object extStopwords(HttpServletResponse response) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader(tagKey, tag);
        response.setHeader(lastModifiedKey, lastModified);
        List<String> words = new ArrayList<>();
        words.add("令牌");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(word);
            res.append("\n");
        }
        return res.toString();
    }
}
