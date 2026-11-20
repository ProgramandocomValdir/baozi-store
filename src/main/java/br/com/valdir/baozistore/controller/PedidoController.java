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

import br.com.valdir.baozistore.model.Pedido;
import br.com.valdir.baozistore.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar pedido
    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    // Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return repository.findAll();
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(
            @PathVariable Long id,
            @RequestBody Pedido pedidoAtualizado) {

        return repository.findById(id)
                .map(pedido -> {
                    pedido.setClienteId(pedidoAtualizado.getClienteId());
                    pedido.setProdutoId(pedidoAtualizado.getProdutoId());
                    pedido.setQuantidade(pedidoAtualizado.getQuantidade());

                    Pedido atualizado = repository.save(pedido);

                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}