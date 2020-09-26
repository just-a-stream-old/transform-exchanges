package finance.modelling.data.transform.transformexchanges.repository;

import finance.modelling.fmcommons.data.schema.model.Exchange;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeRepository extends ReactiveMongoRepository<Exchange, UUID> {
}
