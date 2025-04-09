Gestão de estoque - BackEnd

Este é um projeto de backend desenvolvido com Spring Boot, que oferece um sistema de gestão de produtos em estoque. A API implementa um CRUD completo, permitindo cadastrar, listar, buscar, atualizar e remover produtos do estoque. Além disso, há um endpoint extra para calcular o valor total do estoque com base na quantidade e no preço de cada produto.

O projeto foi estruturado com boas práticas, utilizando camadas separadas de controller, service, repository e mapper, facilitando a manutenção e a escalabilidade da aplicação.

🚀 Tecnologias Utilizadas
Java 21

Spring Boot

Spring Data JPA

Hibernate

Lombok

Maven

JPA

Banco de dados relacional (H2)

🔧 Funcionalidades da API
A API REST oferece os seguintes endpoints:

POST /api/produtos – Cadastrar um novo produto.

GET /api/produtos – Listar todos os produtos.

GET /api/produtos/{id} – Buscar um produto pelo ID.

PUT /api/produtos/{id} – Atualizar os dados de um produto existente.

DELETE /api/produtos/{id} – Remover um produto do estoque.

GET /api/produtos/valor-total – Calcular o valor total de todos os produtos em estoque.
