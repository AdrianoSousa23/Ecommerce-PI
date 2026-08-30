# PrimeTech — E-commerce (Java + Spring Boot)

> Projeto originalmente desenvolvido como Projeto Integrador (PI) da faculdade de
> TADS, em grupo. Este repositório é um **fork individual**, a partir do qual
> venho evoluindo o projeto por conta própria: migração de versão do framework,
> implementação de autenticação/autorização com Spring Security, correção de
> problemas de arquitetura herdados da versão original, e novas funcionalidades.
>
> Repositório original do grupo:
> [Nunes-Fernando/Ecommerce-PI](https://github.com/Nunes-Fernando/Ecommerce-PI)

## Descrição

Sistema web de e-commerce com gestão de estoque, com dois perfis de acesso
(**Admin** e **Estoquista**), cada um com permissões diferentes sobre o sistema.

## Funcionalidades

- **Autenticação e autorização** — login via Spring Security, com sessão,
  senha em hash (BCrypt) e controle de acesso por perfil.
- **Cadastro de usuários** — com validação de dados e confirmação de senha.
- **Gestão de usuários** *(restrito a Admin)* — listagem de todos os usuários
  cadastrados.
- **Cadastro de produtos** *(Admin ou Estoquista)* — nome, preço, quantidade,
  descrição, imagem e avaliação.
- **Edição e exclusão de produtos** *(Admin ou Estoquista)*.
- **Listagem de produtos** — visualização de todos os produtos cadastrados.

## Páginas

### Login
![Login](/Imagens/Login.png)

### Cadastro de Usuário
![Cadastro de Usuários](/Imagens/cadastro-usuarios.png)

### Menu Principal
![Menu Principal](/Imagens/adm.png)

### Listagem de Produtos
![Listagem de Produtos](/Imagens/Listagem-produtos.png)

### Cadastro e Edição de Produto
![Cadastro de Produtos](/Imagens/cadastro-produtos.png)
> A mesma tela é reaproveitada tanto para cadastrar quanto para editar um
> produto existente.

### Listagem de Usuários
![Listagem de Usuários](/Imagens/Listagem-usuarios.png)

## Perfis de acesso

| Rota | Quem acessa |
|---|---|
| `/login`, `/cadastrar-usuarios` | Público |
| `/principal` | Qualquer usuário autenticado |
| `/lista-usuarios` | Apenas **Admin** |
| `/lista-produtos`, `/cadastrar-produtos`, `/editar-produto/{id}`, `/deletar-produto/{id}` | **Admin** ou **Estoquista** |

## Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security** — autenticação baseada em sessão, `UserDetailsService`
  customizado, senha com `BCryptPasswordEncoder`, autorização declarativa por
  rota.
- **Spring Data JPA / Hibernate** — persistência e mapeamento objeto-relacional.
- **Bean Validation** — validação de formulários (`@NotBlank`, `@Email`,
  `@Positive`, etc.).
- **Thymeleaf** — renderização das páginas HTML no servidor.
- **MySQL** — banco de dados relacional.
- **Lombok** — redução de código repetitivo (getters/setters/construtores).
- **Maven** — gerenciamento de dependências e build.

## Configuração do banco de dados

O arquivo `src/main/resources/application.properties` contém a configuração de
conexão:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/consulta
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9090

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

Ajuste `username`/`password` conforme seu ambiente local. É necessário ter um
servidor **MySQL** rodando — o schema (`consulta`, no exemplo acima) precisa
existir antes de subir a aplicação:

```sql
CREATE DATABASE consulta;
```

As tabelas são criadas automaticamente pelo Hibernate (`ddl-auto=update`) na
primeira execução.

## Como executar o projeto

**1. Clone o repositório:**
```sh
git clone https://github.com/AdrianoSousa23/PrimeTech.git
cd PrimeTech
```

**2. Configure o MySQL** conforme a seção acima.

**3. Execute com Maven:**
```sh
mvn spring-boot:run
```
Ou execute a classe `EcommerceInimigosCodigoApplication` diretamente pela IDE.

**4. Acesse no navegador:**
```
http://localhost:9090/login
```

## Histórico e evolução do projeto

Este projeto começou como entrega acadêmica em grupo. A partir do fork, as
principais evoluções feitas individualmente foram:

- Migração de Spring Boot 2 → 3 (namespace `javax.*` → `jakarta.*`, dialects do
  Hibernate 6).
- Remoção de um caminho de persistência legado via JDBC puro que coexistia com
  a camada JPA (e que, inclusive, gravava em uma tabela diferente da usada pela
  entidade JPA — inconsistência corrigida).
- Implementação de Spring Security do zero: `UserDetailsService` customizado,
  `PasswordEncoder` (BCrypt), autorização por perfil via `SecurityFilterChain`.
- Introdução de um enum de perfis (`UserRole`) no lugar de comparação de string
  solta.
- Implementação completa do CRUD de produtos (não existia antes — só um
  controller incompleto e mockups de design).
- Correções de bugs de front-end (referências de CSS quebradas, rotas
  incorretas).

## Melhorias futuras (não implementadas ainda)

- **Vitrine pública de produtos** — hoje o sistema é um painel interno
  (autenticado), sem uma página inicial de loja com listagem/busca de produtos
  para um visitante não logado.
- **Edição de usuário** — a listagem de usuários ainda não tem uma tela/endpoint
  de edição funcional.
- Restringir o cadastro público de usuários para nunca permitir escolher o
  perfil Admin livremente.
- Reativar proteção CSRF (hoje desabilitada para simplificar o desenvolvimento).
- Upload real de imagem de produto (hoje é um campo de texto livre).
- Paginação nas listagens.
- Autenticação via JWT, caso o front-end venha a ser desacoplado (SPA) no
  futuro.