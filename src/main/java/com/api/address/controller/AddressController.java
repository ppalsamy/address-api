package com.api.address.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.address.exception.BadRequestException;
import com.api.address.persistence.Address;
import com.api.address.service.AddressService;
import com.api.address.utils.Urls;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping(Urls.ADDRESS)
	@ResponseBody
	public ResponseEntity<Object> getAddresses() {
		
		return ResponseEntity.ok().body(addressService.getAddress());
	}
	
	@GetMapping(value=Urls.ADDRESS_SEARCH_ZIP_CITY_STATE, produces="application/json")
	@ResponseBody
	public ResponseEntity<Object> getAddressByZipCode(
			@PathVariable String zipOrCityOrState) {
		
		return ResponseEntity.ok().body(addressService.getAddressByZipOrCityOrState(zipOrCityOrState,zipOrCityOrState,zipOrCityOrState));
	}
	
	@PostMapping(value=Urls.ADDRESS, produces="application/json")	
	public ResponseEntity<Void> createAddress(@RequestBody(required = true) Address addressRequest) {
		addressService.createAddress(addressRequest);
		URI location = URI.create("/address");
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(Urls.ADDRESS_BY_ID)
	public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
		addressService.deleteAddressById(addressId);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(Urls.ADDRESS)
	public ResponseEntity<Void> updateAddress(@RequestBody(required=true)Address addressRequest) {
		try {
		addressService.updateAddress(addressRequest);
		}catch(BadRequestException e){
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
}
