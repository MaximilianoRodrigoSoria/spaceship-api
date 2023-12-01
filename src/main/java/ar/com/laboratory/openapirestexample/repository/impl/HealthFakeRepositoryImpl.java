package ar.com.laboratory.openapirestexample.repository.impl;

import ar.com.laboratory.openapirestexample.repository.HealthFakeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HealthFakeRepositoryImpl implements HealthFakeRepository {
    @Override
    public String getMessage() {
        return "OK - Server live!!!";
    }
}
