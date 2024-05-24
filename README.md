# Visão geral

O projeto é uma aplicação back-end com objetivo que os estabelecimentos comerciais tenham a possibilidade de demonstrar aos seus clientes, promoções de produtos respecitvos a qual localização eles se encontrem dentro do estabelecimento, quais produtos com promoção estão próximos do cliente. A API foi focada na facilidade tanto na adição desses produtos ao Banco de Dados e como também na exportação para o frot-end. Utilizando [Spring Boot](https://projects.spring.io/spring-boot), [PostgreSQL-16](https://www.postgresql.org/) e [Swagger](https://swagger.io/) em conjunto.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [PostgreSQL](https://www.postgresql.org/) é um sistema de gerênciamento de banco de dados relacional, seguindo coneitos de otímo desempeno, robustez, alta capacidade de expansividade e adesão aos padrões SQL.

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 21
PostgreSQL 16
Spring Boot 3.2.4
Maven 3.9.6 
```

## Preparando ambiente

Primeiramente é fudamental a instalação do Java 21 (JDK).

```
Em seguida é precciso instalar o Apache Maven.
```

É necessário a criação da base de dados relacional no Postgres.

```
CREATE DATABASE "DbCencosudAPISquad8";
```

## Variáveis de ambiente

Esses são os comandos que definem as variáveis de ambiente DATABASE URL, DATABASE USERNAME e DATABASE PASSWORD com os valores fornecidos. Após executar
esses comandos, as variáveis de ambiente estarão disponíveis para permitir que o projeto [Squad8_Cencosud_API](https://github.com/joaovictorlinhares/Squad8_Cencosud_API) seja executado com êxito.

- Apenas certifique-se de substituir seu_username e sua_senha com seu nome de usuário e senha reais do PostgreSQL.

**Windows**
```
setx DATABASE_URL jdbc:postgresql://localhost:5432/DbCencosudAPISquad8
setx DATABASE_USERNAME seu_username
setx DATABASE_PASSWORD sua_senha
```
**Linux**
```
export DATABASE_URL=jdbc:postgresql://localhost:5432/DbCencosudAPISquad8
export DATABASE_USERNAME=seu_username
export DATABASE_PASSWORD=sua_senha
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
git clone https://github.com/joaovictorlinhares/Squad8_Cencosud_API
```
Feito isso, acesse o projeto:
```
cd Squad8_Cencosud_API
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```

Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
- Se ocorrer algum erro, reinicie o terminal e execute o comando novamente.


Pronto. A aplicação está disponível em http://localhost:8080/swagger-ui/index.html