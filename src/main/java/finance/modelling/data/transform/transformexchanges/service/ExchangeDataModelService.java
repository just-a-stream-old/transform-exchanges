package finance.modelling.data.transform.transformexchanges.service;

import finance.modelling.fmcommons.data.schema.eod.dto.EodExchangeDTO;
import org.apache.kafka.streams.kstream.KStream;

import java.util.function.Consumer;

public interface ExchangeDataModelService {
    Consumer<KStream<String, EodExchangeDTO>> generateExchangeDataModel();
}
