package com.sonu.springaddressbookapp.service;

import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressService {

    @Autowired
    private AddressRepository addressBookRepository;

    public void createOrUpdateEntry(AddressEntity addressEntity) {
        addressBookRepository.save(addressEntity);
    }

    public Optional<AddressEntity> getEntryById(Long id) {
        return addressBookRepository.findById(id);
    }

    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}
