package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.dao.ClientRepository;
import com.nikolenko.bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Autowired
    public void setRepo(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        clientRepository.deleteById(client.getId());
        return clientRepository.save(client);

    }

    @Override
    public boolean removeClient(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    @Override
    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();
    }
}
