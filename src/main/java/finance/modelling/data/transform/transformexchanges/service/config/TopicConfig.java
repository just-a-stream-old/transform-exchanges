package finance.modelling.data.transform.transformexchanges.service.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class TopicConfig {

    private final String traceIdHeaderName;
    private final String ingestEodExchangesTopic;

    public TopicConfig(
            @Value("${spring.cloud.stream.kafka.streams.header.traceId}") String traceIdHeaderName,
            @Value("${spring.cloud.stream.bindings.generateExchangeDataModel-in-0.destination}") String ingestEodExchangesTopic) {
        this.traceIdHeaderName = traceIdHeaderName;
        this.ingestEodExchangesTopic = ingestEodExchangesTopic;
    }
}
