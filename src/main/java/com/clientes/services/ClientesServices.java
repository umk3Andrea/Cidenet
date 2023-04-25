package com.clientes.services;

import com.clientes.model.Cliente;
import com.clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientesServices {
    @Autowired
    private ClientesRepository repo;

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return repo.findById(id);
    }
}
