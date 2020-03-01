package com.example.aula06;

import com.example.aula06.entity.Cliente;
import com.example.aula06.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.BeforeAll;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ClienteServiceTest {

    Cliente cliente = new Cliente();

    @BeforeAll
    public void setup(){
        cliente.setNome("Jackeline");
        cliente.setCpf("1234567890");
    }

    @Autowired
    ClienteService clienteServiceTeste;

    @Test
    void addClienteComSucesso(){

        //when
        Cliente clienteSalvo = clienteServiceTeste.add(cliente);

        //then
        assertThat(clienteSalvo).isNotNull();

     }

     void testarMetodoGetId(){

        Cliente found = clienteServiceTeste.get(cliente.getId());


     }

}
