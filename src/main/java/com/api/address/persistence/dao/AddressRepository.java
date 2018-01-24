package com.api.address.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.address.persistence.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByZipOrCityOrStateAllIgnoreCase(String zip,String city, String state);

}
