package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.model.Client;

import java.util.List;


public interface ClientService {

    Client addClient(Client client);
    Client updateClient(Client client);
    boolean removeClient(long id);
    Client getClientById(long id);
    List<Client> getAllClient();

}
