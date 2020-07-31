package com.elaon.dao;

import org.springframework.data.repository.CrudRepository;

import com.elaon.entity.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower, Long> {

}
