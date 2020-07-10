package com.myawesome.core.repository;

import com.myawesome.core.entities.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RetailerRepository extends JpaRepository<Retailer, String> {
    Retailer findOneById(String userId);
    Retailer findOneByPhoneNumber(String phoneNumber);
    List<Retailer> findAllByStoreNameStartingWith(String prefix);
    List<Retailer> findAllByStoreNameNotNull();
}