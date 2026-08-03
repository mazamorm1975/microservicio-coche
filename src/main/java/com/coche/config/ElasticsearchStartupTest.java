package com.coche.config;

import org.springframework.stereotype.Component;
import com.coche.elasticsearch.ElasticsearchTestService;
import org.springframework.boot.CommandLineRunner;


@Component
public class ElasticsearchStartupTest implements CommandLineRunner  {


    private final ElasticsearchTestService testService;




    public ElasticsearchStartupTest(ElasticsearchTestService testService) {

        this.testService = testService;

    }


    @Override
    public void run(String... args) throws Exception {

        testService.probarConexion();

    }

}
