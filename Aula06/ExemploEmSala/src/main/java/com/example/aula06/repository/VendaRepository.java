package com.example.aula06.repository;

import com.example.aula06.entity.Cliente;
import com.example.aula06.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    Venda findById(long id);

}
