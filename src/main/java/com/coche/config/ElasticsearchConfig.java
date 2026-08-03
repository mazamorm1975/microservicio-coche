package com.coche.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    private final ElasticsearchProperties properties;

    public ElasticsearchConfig(ElasticsearchProperties properties) {
        this.properties = properties;
    }


    @Bean
    public ElasticsearchClient elasticsearchClient() {

        Header[] defaultHeaders = new Header[]{
                new BasicHeader(
                        "Authorization",
                        "ApiKey " + properties.getApiKey()
                )
        };


        RestClient restClient = RestClient.builder(
                        HttpHost.create(properties.getHost())
                )
                .setDefaultHeaders(defaultHeaders)
                .build();


        RestClientTransport transport =
                new RestClientTransport(
                        restClient,
                        new JacksonJsonpMapper()
                );


        return new ElasticsearchClient(transport);
    }
}