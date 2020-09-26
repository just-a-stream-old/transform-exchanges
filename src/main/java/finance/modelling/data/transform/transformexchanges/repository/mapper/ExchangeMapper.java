package finance.modelling.data.transform.transformexchanges.repository.mapper;

import finance.modelling.fmcommons.data.schema.eod.dto.EodExchangeDTO;
import finance.modelling.fmcommons.data.schema.model.Exchange;
import finance.modelling.fmcommons.data.schema.model.enums.FinanceApi;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {
    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    @Mappings ({
        @Mapping(source = "code", target = "exchangeCode"),
        @Mapping(source = "operatingMICs", target = "marketIdCode")
    })
    Exchange exchangeEodDTOToExchange(EodExchangeDTO dto);

    @AfterMapping
    default void determineFinanceApisField(EodExchangeDTO dto, @MappingTarget Exchange exchange) {
        exchange.setFinanceApis(List.of(FinanceApi.EOD_HISTORICAL_DATA));
    }
}
