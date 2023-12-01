package ar.com.laboratory.openapirestexample.services.impl;

import ar.com.laboratory.openapirestexample.repository.HealthFakeRepository;
import ar.com.laboratory.openapirestexample.services.HealthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class HealthServiceImpl implements HealthService {

    private HealthFakeRepository healthFakeRepository;
    public String getHealth(){
        var msg = healthFakeRepository.getMessage();
        log.info("Message: {}",msg);
        return msg;
    }
}
