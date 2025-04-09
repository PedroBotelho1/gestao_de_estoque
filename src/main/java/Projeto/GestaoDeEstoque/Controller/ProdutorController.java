package Projeto.GestaoDeEstoque.Controller;

import Projeto.GestaoDeEstoque.Repository.ProdutoRepository;
import Projeto.GestaoDeEstoque.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/produtos")
public class ProdutorController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repotitory;

    @PostMapping
    @ResponseStatus( code = HttpStatus.CREATED)
    public ProdutoDto create(@RequestBody ProdutoDto produto) {
        return service.create(produto);
    }

    // listar todos os produto
    @GetMapping
    public List<Produto> listaProdutos() {
        return service.listarProdutos();
    }

    // BUSCAR PRODUTO POR ID
    @GetMapping("/{id}")
    public Produto buscarProdoutoPorId (@PathVariable UUID id ) {
        Optional<Produto> produto = service.buscarProdutoPorId(id);
        return produto.orElse(null);
    }

    // ATUALIZAR PRODUTO
    @PutMapping("/{id}")
    public ProdutoDto atualizarProduto(@PathVariable UUID id, @RequestBody ProdutoDto produtoDto) {
        return service.atualizarProduto(id, produtoDto);
    }


    // REMOVER PRODUTO
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduto(@PathVariable UUID id) {
        service.removerProduto(id);
    }

    // calcular valor total do estoque
    @GetMapping("/valor-total")
    public double calcularValorTotalEstoque(){
        return service.calcularValorTotalEstoque();
    }


}
