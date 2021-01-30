package com.nikolenko.bookstore.dao;

import com.nikolenko.bookstore.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
