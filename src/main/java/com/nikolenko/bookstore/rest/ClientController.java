package com.nikolenko.bookstore.rest;

import com.nikolenko.bookstore.model.Client;
import com.nikolenko.bookstore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
@Service
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setService(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/client/add")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("/client/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @PostMapping("/client/remove")
    public boolean removeClient(@RequestBody Client client){
        return clientService.removeClient(client.getId());
    }

    @PostMapping("/client/getbyid")
    public Client getClientById(@RequestBody Client client){
        return clientService.getClientById(client.getId());
    }

    @PostMapping(value = "/client/getall")
    public List<Client> getall() {
        return clientService.getAllClient();
    }
}
