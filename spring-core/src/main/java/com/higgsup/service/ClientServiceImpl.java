package com.higgsup.service;

public class ClientServiceImpl implements ClientService {
    private static ClientService clientService = new ClientServiceImpl();

    public ClientServiceImpl() {
    }

    public static ClientService createInstance() {
        return clientService;
    }
}
