package com.sonu.springaddressbookapp.service;

import com.sonu.springaddressbookapp.dto.AddressDto;
import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressBookRepository;

    // Save or update the address entry
    public void createOrUpdateEntry(AddressEntity addressEntity) {
        addressBookRepository.save(addressEntity);
    }

    // Fetch entry by ID and map to DTO
    public Optional<AddressDto> getEntryById(Long id) {
        return addressBookRepository.findById(id).map(entity -> new AddressDto(
                entity.getId(),
                entity.getName(),
                entity.getEmailId(),
                entity.getAddress(),
                entity.getMobileNumber()
        ));
    }

    // Delete an address entry by ID
    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}
