package finance.modelling.data.transform.transformexchanges.repository.mapper;

import finance.modelling.fmcommons.data.schema.eod.dto.EodExchangeDTO;
import finance.modelling.fmcommons.data.schema.model.Exchange;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {
    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    @Mappings ({
        @Mapping(source = "code", target = "exchangeCode"),
        @Mapping(source = "operatingMICs", target = "marketIdCode")
    })
    Exchange exchangeEodDTOToExchange(EodExchangeDTO dto);
}
