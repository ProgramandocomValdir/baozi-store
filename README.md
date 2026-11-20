# Baozi Store — API REST

Projeto acadêmico desenvolvido para a disciplina de Desenvolvimento Web Back-End da UNINTER.

## 1. Descrição do projeto

A Baozi Store é uma pequena loja fictícia especializada na venda de pão chinês.

O objetivo deste projeto é desenvolver uma API REST para realizar o gerenciamento de clientes, produtos e pedidos, utilizando Java e Spring Boot.

A API permite cadastrar, consultar, listar e excluir registros.

## 2. Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Maven
- Postman
- JSON

## 3. Arquitetura do projeto

O projeto utiliza a arquitetura MVC, organizado nos seguintes pacotes:

- `model`: representa as entidades do sistema.
- `repository`: realiza a comunicação com o banco de dados.
- `controller`: disponibiliza os endpoints da API REST.

## 4. Entidades

### Produto
- id: Long
- nome: String
- preco: BigDecimal
- estoque: Boolean

### Cliente
- id: Long
- nome: String
- clienteDesde: LocalDate

### Pedido
- id: Long
- clienteId: Long
- produtoId: Long
- quantidade: Integer

## 5. Endpoints da API

### Produtos

| Método | Endpoint | Função |
|---|---|---|
| POST | /produtos | Cadastrar produto |
| GET | /produtos | Listar produtos |
| GET | /produtos/{id} | Consultar produto por ID |
| PUT | /produtos/{id} | Atualizar produto |
| DELETE | /produtos/{id} | Excluir produto |

### Clientes

| Método | Endpoint | Função |
|---|---|---|
| POST | /clientes | Cadastrar cliente |
| GET | /clientes | Listar clientes |
| GET | /clientes/{id} | Consultar cliente por ID |
| PUT | /clientes/{id} | Atualizar cliente |
| DELETE | /clientes/{id} | Excluir cliente |

### Pedidos

| Método | Endpoint | Função |
|---|---|---|
| POST | /pedidos | Cadastrar pedido |
| GET | /pedidos | Listar pedidos |
| GET | /pedidos/{id} | Consultar pedido por ID |
| PUT | /pedidos/{id} | Atualizar pedido |
| DELETE | /pedidos/{id} | Excluir pedido |

## 6. Banco de dados

O projeto utiliza o banco de dados H2 em memória, configurado por meio do Spring Data JPA e Hibernate.

## 7. Como executar o projeto

1. Instale o Java e tenha o Maven Wrapper disponível no projeto.
2. Abra a pasta do projeto no terminal.
3. Execute:

```powershell
.\mvnw.cmd spring-boot:run
```

4. A API ficará disponível em:

```text
http://localhost:8080
```

5. O console do banco H2 poderá ser acessado em:

```text
http://localhost:8080/h2-console
```

## 8. Testes

Os endpoints foram testados utilizando o Postman, com requisições HTTP e dados no formato JSON.

## 9. Autor

**Valdir Barboza Sales**

RU: 5421217

Curso: Análise e Desenvolvimento de Sistemas — UNINTER

Disciplina: Desenvolvimento Web Back-End