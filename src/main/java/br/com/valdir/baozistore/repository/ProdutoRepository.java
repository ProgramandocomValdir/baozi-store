package br.com.valdir.baozistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valdir.baozistore.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}