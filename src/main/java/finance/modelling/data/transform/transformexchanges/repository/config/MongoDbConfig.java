package finance.modelling.data.transform.transformexchanges.repository.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import static finance.modelling.fmcommons.data.logging.LogDb.buildDbUri;

@Configuration
@Getter
public class MongoDbConfig extends AbstractReactiveMongoConfiguration {

    private final String envName;
    private final String dbUri;

    public MongoDbConfig(
            @Value("${context.envName}") String envName,
            @Value("${spring.data.mongodb.host}") String dbHost,
            @Value("${spring.data.mongodb.port}") String dbPort) {
        this.envName = envName;
        this.dbUri = buildDbUri(dbHost, dbPort);
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return envName;
    }
}
