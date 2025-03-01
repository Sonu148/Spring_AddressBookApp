package com.sonu.springaddressbookapp.controller;
import com.sonu.springaddressbookapp.entity.AddressEntity;
import com.sonu.springaddressbookapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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
    public ResponseEntity<AddressEntity> getEntryById(@PathVariable Long id) {
        try {
            Optional<AddressEntity> addressEntity = addressService.getEntryById(id);
            if (addressEntity.isPresent()) {
                return new ResponseEntity<>(addressEntity.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        try {
            addressService.deleteEntry(id);
            return new ResponseEntity<>("Entry successfully deleted.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while processing the request: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
