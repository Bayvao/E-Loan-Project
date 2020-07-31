package com.elaon.dao;

import org.springframework.data.repository.CrudRepository;

import com.elaon.entity.Property;

public interface PropertyRepository extends CrudRepository<Property, Long> {

}
