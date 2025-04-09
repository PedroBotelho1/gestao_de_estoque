package Projeto.GestaoDeEstoque.Controller;

import java.util.UUID;

public record ProdutoDto(UUID id, String nome, int quantidade, double preco) {
}
