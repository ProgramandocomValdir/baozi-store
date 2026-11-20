package br.com.valdir.baozistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.valdir.baozistore.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}