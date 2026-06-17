package com.exercise.itsreadydemo.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class StoreApplicationInstanceSupplier implements ServiceInstanceListSupplier {
    private final String serviceId;

    public StoreApplicationInstanceSupplier() {
        this.serviceId = "StoreApplication";
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get(){
        return Flux.just(Arrays.asList(new DefaultServiceInstance(
                serviceId + "1",
                serviceId,
                "localhost",
                8081,
                false
        ), new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8083,false)));
    }
}
