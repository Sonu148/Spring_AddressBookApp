package com.sonu.springaddressbookapp.service;

import com.sonu.springaddressbookapp.dto.AddressDto;
import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    // Autowiring the AddressRepository to interact with the database
    @Autowired
    private AddressRepository addressBookRepository;

    /**
     * Save or update an address entry.
     *
     * @param addressEntity The entity to save or update.
     */
    public void createOrUpdateEntry(AddressEntity addressEntity) {
        // This method will either insert a new entry or update an existing one based on the ID.
        addressBookRepository.save(addressEntity);
    }

    /**
     * Fetch an address entry by ID and map it to an AddressDto.
     *
     * @param id The ID of the address entry to retrieve.
     * @return Optional<AddressDto> The DTO of the address entry, or empty if not found.
     */
    public Optional<AddressDto> getEntryById(Long id) {
        // Find the entry by ID and map the AddressEntity to an AddressDto
        return addressBookRepository.findById(id)
                .map(entity -> new AddressDto(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmailId(),
                        entity.getAddress(),
                        entity.getMobileNumber()
                ));
    }

    /**
     * Delete an address entry by ID.
     *
     * @param id The ID of the address entry to delete.
     */
    public void deleteEntry(Long id) {
        // Delete the address entry by ID
        addressBookRepository.deleteById(id);
    }
}
