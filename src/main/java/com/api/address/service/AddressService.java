package com.api.address.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.address.exception.BadRequestException;
import com.api.address.persistence.Address;
import com.api.address.persistence.dao.AddressRepository;

@Transactional
@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAddress() {
		return  addressRepository.findAll();
	}
	

	public Object getAddressByZipOrCityOrState(String zipCode, String city, String state) {
		return addressRepository.findByZipOrCityOrStateAllIgnoreCase(zipCode,city,state);
	}

	public void deleteAddressById(Long id) {
		addressRepository.delete(id);
		return;
	}


	public void createAddress(Address addressRequestList) {
		addressRepository.saveAndFlush(addressRequestList);
	}


	public void updateAddress(Address addressRequest) throws BadRequestException {
		Address address = addressRepository.findOne(addressRequest.getId());
		if(address == null)
			throw new BadRequestException();
		addressRepository.saveAndFlush(addressRequest);
	}
}
