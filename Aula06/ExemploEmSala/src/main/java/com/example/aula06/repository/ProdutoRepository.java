package com.example.aula06.repository;

import com.example.aula06.entity.Cliente;
import com.example.aula06.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id);

}
