package com.coche.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticsearchTestService {

    private final ElasticsearchClient client;


    public ElasticsearchTestService(ElasticsearchClient client) {

        this.client = client;


    }


    public void probarConexion() throws IOException {

        boolean existe = client.indices()
                .exists(e -> e.index("coches"))
                .value();

        System.out.println("=================================");
        System.out.println("Conexión Elasticsearch OK");
        System.out.println("¿Existe índice coches?: " + existe);
        System.out.println("=================================");
    }


}
