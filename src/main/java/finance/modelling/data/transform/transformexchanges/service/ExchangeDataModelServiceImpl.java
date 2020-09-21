package finance.modelling.data.transform.transformexchanges.service;

import finance.modelling.data.transform.transformexchanges.repository.ExchangeRepository;
import finance.modelling.data.transform.transformexchanges.repository.mapper.ExchangeMapper;
import finance.modelling.fmcommons.data.logging.kstream.LogMessageConsumed;
import finance.modelling.fmcommons.data.schema.eod.dto.EodExchangeDTO;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ExchangeDataModelServiceImpl implements ExchangeDataModelService {

    private final ExchangeRepository exchangeRepository;

    public ExchangeDataModelServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Bean
    public Consumer<KStream<String, EodExchangeDTO>> generateExchangeDataModel() {

        return eodExchanges -> eodExchanges
//                .transformValues(() -> new LogMessageConsumed<>("x-trace-id"))
                .mapValues(ExchangeMapper.INSTANCE::exchangeEodDTOToExchange)
                .peek((key, value) -> System.out.println(value.toString()));
    }
}
