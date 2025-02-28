package com.sonu.springaddressbookapp.controller;

import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address-book")
public class AddressBookController {

    @Autowired
    private AddressService addressService;

    // get all address
    @GetMapping
    public List<AddressEntity> getAllEntries() {
        return addressService.getAllEntries();
    }

    // get address entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressEntity> getEntryById(@PathVariable Long id) {
        Optional<AddressEntity> addressEntity = addressService.getEntryById(id);
        if (addressEntity.isPresent()) {
            return new ResponseEntity<>(addressEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AddressEntity> createOrUpdateEntry(@RequestBody AddressEntity entry) {
        AddressEntity savedEntity = addressService.createOrUpdateEntry(entry);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        try {
            addressService.deleteEntry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
