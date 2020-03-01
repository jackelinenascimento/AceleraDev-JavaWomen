package com.example.aula06.service;

import com.example.aula06.entity.Cliente;
import com.example.aula06.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // anotation dizendo que é service
public class ClienteService {

    @Autowired // anotation que chama variavel dentro do serviço
    private ClienteRepository clienteRepository;

    public Cliente add(Cliente object){
        return clienteRepository.save(object);
    }

    public Cliente get(long id){
        return clienteRepository.findById(id);
    }

    public Cliente update(Cliente object){
        return clienteRepository.save(object);
    }

    public long quantidadeCliente(){
        return clienteRepository.count();
    }




}
