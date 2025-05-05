package com.github.lzpdark.elasticsearchdemo.controller;

import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import com.github.lzpdark.elasticsearchdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lzp
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    ElasticsearchOperations operations;

    @GetMapping("")
    public Object get(@RequestParam String value) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(builder -> builder.query(value)
                        .fields(List.of("name", "description", "brand", "category", "tags"))
                        .type(TextQueryType.BestFields)))
                .build();
        SearchHits<Product> hits = operations.search(query, Product.class);
        return hits.getSearchHits().stream().map(SearchHit::getContent).toList();
    }
}
