package br.com.valdir.baozistore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valdir.baozistore.model.Produto;
import br.com.valdir.baozistore.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar produto
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @RequestBody Produto produtoAtualizado) {

        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setEstoque(produtoAtualizado.getEstoque());

                    Produto atualizado = repository.save(produto);

                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}