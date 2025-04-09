package Projeto.GestaoDeEstoque.Service;

import Projeto.GestaoDeEstoque.Controller.Produto;
import Projeto.GestaoDeEstoque.Controller.ProdutoDto;
import Projeto.GestaoDeEstoque.Mapper.ProdutoMapper;
import Projeto.GestaoDeEstoque.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoDto create( ProdutoDto produto) {
        return produtoMapper.produtorDto(repository.save(produtoMapper.toEntity(produto)));
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId ( UUID id) {
        return repository.findById(id);
    }

    public ProdutoDto atualizarProduto(UUID id, ProdutoDto produtoDto) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();

            produtoExistente.setNome(produtoDto.nome());
            produtoExistente.setQuantidade(produtoDto.quantidade());
            produtoExistente.setPreco(produtoDto.preco());

            Produto atualizado = repository.save(produtoExistente);
            return produtoMapper.produtorDto(atualizado);
        }

        return null;
    }


    public void removerProduto( UUID id) {
        repository.deleteById(id);
    }

    public double calcularValorTotalEstoque() {
        List<Produto> produtos = repository.findAll();
        double total = 0;

        for ( Produto produto : produtos) {
            total += produto.getQuantidade() * produto.getPreco();
        }
        return total;
    }
}

