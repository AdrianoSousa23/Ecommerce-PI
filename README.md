# E-commerce Inimigos do Código

## Descrição
Este é um projeto de e-commerce desenvolvido como parte do Projeto Integrador (PI) da faculdade de TADS no 4º semestre. O sistema permite o gerenciamento de produtos e usuários, incluindo funcionalidades de cadastro, edição e visualização dos produtos e dos usuarios cadastrados.

## Funcionalidades
- **Cadastro de Produtos**: Adicione novos produtos com nome, preço, quantidade, descrição, imagem e avaliação.
- **Edição de Produtos**: Edite informações dos produtos já cadastrados.
- **Visualização de Produtos**: Liste todos os produtos cadastrados com detalhes.
- **Cadastro de Usuários**: Adicione novos usuários ao sistema.
- **Edição de Usuários**: Edite informações dos usuários cadastrados.
- **Visualização de Usuários**: Liste todos os usuários cadastrados com detalhes.

## Páginas
### 1. Página Principal da Loja
![Loja](./images/cadastro_produtos.png)
- Tem o botão de **Login** para que seja feito o login na pagina.
- O botão de **Cadastro** para que seja feito um novo cadastro de usuario.
- O botão de **Sair** redireciona para a pagina de login.
- temos os produtos listados, com uma barra de pesquisa que busca um produto pelo nome.

### 2. Página de Cadastro de Usuários
![Cadastro de Usuários](./images/cadastro_usuarios.png)
- **Nome do Usuário**: Campo para inserir o nome do usuário.
- **Email do Usuário**: Campo para inserir o email do usuário.
- **CPF do Usuário**: Campo para inserir a senha do usuário.
- **Senha do Usuário**: Campo para inserir a senha do usuário.
- **Confirmação de senha do Usuário**: Campo para inserir a senha do usuário.

### 3. Página de Login Administrativo.
![Cadastro de Usuários](./images/cadastro_usuarios.png)
- **Email do Usuário**: Campo para inserir o email do usuário.
- **Senha do Usuário**: Campo para inserir o senha do usuário.

### 3. Página Principal do ADM.
![Cadastro de Usuários](./images/cadastro_usuarios.png)
- **Listar Produtos**: Redireciona para a pagina de Listagem dos Produtos, onde pode ser feita e edição ou exclusão de um produto ja cadastrado.
- **Listar Usuarios**: Redireciona para a pagina de Listagem de usuarios, onde pode ser visualizado os usuarios cadastrados e tambem onde pode ser feita a edição e exlusão dos mesmos.
- **Cadastrar Produtos**: Redireciona para a pagina de Cadastro dos produtos.

### 4. Página de Listagem de Produtos
- Exibe todos os produtos cadastrados com opções para editar ou deletar cada produto. Ao clicar em Editar sera redirecionado para uma pagina de edição.

### 5. Página de Edição de Produtos
- Permite editar as informações dos produtos já cadastrados.

### 6. Página de Listagem de Usuários
- Exibe todos os usuários cadastrados com opções para editar ou deletar cada usuário. Ao clicar em editar caracteristicas, será aberto um modal permitindo a edição do usuario.

### 7. Página de Cadastro de Produtos
![Cadastro de Produtos](./images/cadastro_produtos.png)
- **Nome do Produto**: Campo para inserir o nome do produto.
- **Preço do Produto (R$)**: Campo para inserir o preço do produto.
- **Quantidade**: Campo para inserir a quantidade disponível do produto.
- **Descrição do Produto**: Campo para inserir uma descrição do produto.
- **Imagem do Produto**: Campo para upload de uma imagem do produto.
- **Avaliação do Produto**: Campo para selecionar a avaliação do produto.









## Tecnologias Utilizadas
- **Java 16**: Linguagem de programação utilizada para desenvolver a lógica do aplicativo.
- **Spring Boot 2.6.3**: Framework utilizado para simplificar o desenvolvimento e a configuração da aplicação.
- **Thymeleaf**: Motor de templates utilizado para renderizar as páginas HTML.
- **MySQL**: Banco de dados utilizado para armazenar os dados do aplicativo.
- **Hibernate**: Framework de mapeamento objeto-relacional utilizado para gerenciar o banco de dados.
- **Bootstrap**: Framework de CSS utilizado para estilizar as páginas HTML.

## Configuração do Banco de Dados
O arquivo `application.properties` contém a configuração do banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/consulta
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

server.port=9090

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
