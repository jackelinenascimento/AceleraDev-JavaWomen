package com.example.aula06.component;

import com.example.aula06.entity.Cliente;
import com.example.aula06.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineappStartupRunner implements CommandLineRunner {

    @Autowired
    ClienteService clienteService;

    @Override
    public void run(String... args){
        this.criarCliente();
    }

    private void criarCliente(){

        Cliente cliente = new Cliente();

        cliente.setCpf("12345678910");
        cliente.setNome("Eveline");

        clienteService.add(cliente);

    }
}
