package com.sonu.springaddressbookapp.repository;

import com.sonu.springaddressbookapp.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> { }
