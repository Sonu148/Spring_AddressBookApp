package com.sonu.springaddressbookapp.service;

import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressBookRepository;

    public List<AddressEntity> getAllEntries() {
        return addressBookRepository.findAll();
    }

    public Optional<AddressEntity> getEntryById(Long id) {
        return addressBookRepository.findById(id);
    }

    public AddressEntity createOrUpdateEntry(AddressEntity entry) {
        return addressBookRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}
