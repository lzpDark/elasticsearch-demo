package com.github.lzpdark.elasticsearchdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.lang.NonNull;

/**
 * @author lzp
 */
@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @NonNull
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                // https://www.elastic.co/guide/en/elasticsearch/reference/7.17/security-minimal-setup.html
                .withBasicAuth("elastic", "123456")
                .build();
    }
}
