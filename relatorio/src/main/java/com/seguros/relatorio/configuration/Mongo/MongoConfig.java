package com.seguros.relatorio.configuration.Mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @criado 03/12/2020 - 14:56
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.seguros.relatorio.relatorio.domain.repository")
public class MongoConfig extends AbstractMongoClientConfiguration  {

    @Override
    protected String getDatabaseName() {
        return "impressaodba";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/impressaodba");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
