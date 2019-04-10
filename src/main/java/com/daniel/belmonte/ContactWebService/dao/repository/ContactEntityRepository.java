package com.daniel.belmonte.ContactWebService.dao.repository;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactEntityRepository extends CrudRepository<ContactEntity, Integer> {

}
