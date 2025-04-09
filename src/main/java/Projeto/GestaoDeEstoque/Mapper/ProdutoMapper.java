package Projeto.GestaoDeEstoque.Mapper;

import Projeto.GestaoDeEstoque.Controller.Produto;
import Projeto.GestaoDeEstoque.Controller.ProdutoDto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto produtorDto(Produto produto) {

        if(produto == null) {
            return null;
        }
        return new ProdutoDto(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getPreco());
    }

    public Produto toEntity(ProdutoDto produtoDto) {
        if(produtoDto == null) {
            return null;
        }

        Produto produto = new Produto();

        if(produtoDto.id() != null) {
            produto.setId(produtoDto.id());
        }

        produto.setNome(produtoDto.nome());
        produto.setQuantidade(produtoDto.quantidade());
        produto.setPreco(produtoDto.preco());

        return produto;
    }
}