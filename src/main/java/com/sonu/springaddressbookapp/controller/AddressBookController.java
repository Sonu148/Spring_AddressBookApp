package com.sonu.springaddressbookapp.controller;

import com.sonu.springaddressbookapp.dto.AddressDto;
import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressBookController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> createOrUpdateEntry(@RequestBody AddressEntity entry) {
        addressService.createOrUpdateEntry(entry);
        return new ResponseEntity<>("Entry successfully created/updated.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getEntryById(@PathVariable Long id) {
        return addressService.getEntryById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        addressService.deleteEntry(id);
        return new ResponseEntity<>("Entry successfully deleted.", HttpStatus.NO_CONTENT);
    }
}
