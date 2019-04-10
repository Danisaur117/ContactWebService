package com.daniel.belmonte.ContactWebService.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;

@Repository
public interface ContactEntityRepository extends CrudRepository<ContactEntity, Integer> {

}
