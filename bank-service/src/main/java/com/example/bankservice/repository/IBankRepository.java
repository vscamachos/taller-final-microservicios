package com.example.bankservice.repository;

import com.example.bankservice.model.Bank;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IBankRepository extends ReactiveCrudRepository<Bank, Long>{
    Mono<Bank> findById(Long bankId);
}