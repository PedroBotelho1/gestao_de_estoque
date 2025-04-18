package Projeto.GestaoDeEstoque.Repository;

import Projeto.GestaoDeEstoque.Controller.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
