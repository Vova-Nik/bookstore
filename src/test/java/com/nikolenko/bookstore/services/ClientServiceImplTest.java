package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.model.Client;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    @Test
    void addClient() {
        Client client1= new Client();
        client1.setDateOfBirth(new Date(2000,12,19));
        client1.setEmail("hhh@gmail.com");
        client1.setFirstName("Vasil");
        client1.setLastName("Pupkins");

        Client client2= new Client();
        client2.setDateOfBirth(new Date(2001,12,19));
        client2.setEmail("ddd@gmail.com");
        client2.setFirstName("Vasen");
        client2.setLastName("Pupkinson");

        Client client3= new Client();
        client3.setDateOfBirth(new Date(2000,12,19));
        client3.setEmail("hhh@gmail.com");
        client3.setFirstName("Vasilias");
        client3.setLastName("Pupkinopulo");
//        ClientRepository cr = new Spring.clientRepository();
//        ClientService cs = new ClientServiceImpl();
//        cs.addClient(client1);

    }

    @Test
    void updateClient() {
    }

    @Test
    void removeClient() {
    }

    @Test
    void getClientById() {
    }

    @Test
    void getAllClient() {
    }
}