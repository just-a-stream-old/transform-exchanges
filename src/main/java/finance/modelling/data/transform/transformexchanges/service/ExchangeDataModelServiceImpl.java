package finance.modelling.data.transform.transformexchanges.service;

import finance.modelling.data.transform.transformexchanges.repository.ExchangeRepository;
import finance.modelling.fmcommons.data.logging.kstream.LogMessageConsumed;
import finance.modelling.fmcommons.data.schema.eod.dto.EodExchangeDTO;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

public class ExchangeDataModelServiceImpl implements ExchangeDataModelService {

    private final String inputEodExchangesTopic;
    private final ExchangeRepository exchangeRepository;

    public ExchangeDataModelServiceImpl(
            @Value("${spring.cloud.stream.bindings.generateExchangeDataModel-in-0.destination}") String inputEodExchangesTopic,
            ExchangeRepository exchangeRepository) {
        this.inputEodExchangesTopic = inputEodExchangesTopic;
        this.exchangeRepository = exchangeRepository;
    }

    @Bean
    public Consumer<KStream<String, EodExchangeDTO>> generateExchangeDataModel() {

        return eodExchanges -> eodExchanges
                .transformValues(() -> new LogMessageConsumed<>("x-trace-id"))
                .peek((key, value) -> System.out.println(value));
    }
}
