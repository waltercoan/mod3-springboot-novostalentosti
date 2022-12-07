# Projeto módulo 3 Spring Boot

## Spring Framework
Conjunto de bibliotecas escritas em Java para simplificar o desenvolvimento de aplicações WEB

## Spring Boot
Ferramenta para acelerar o início de um projeto utilizando o Spring Framework
- Documentação: https://spring.io/projects/spring-boot
- Start: https://start.spring.io/
Site que cria a estrutura de um projeto utilizando o Spring Boot

## Configuração do ambiente
- Java Development Kit (JDK)
- Maven (gerenciador de pacotes e ferramenta de build)
- VSCode
  - Extension Pack for Java (Microsoft)
  - Extension Pack for Spring Boot (Pivotal)
- Banco de dados (MariaDB)

## Passo a passo para criar um novo projeto Springboot no VSCode
- Criar uma pasta no disco do computador
- Abrir a pasta no VSCode usando a opção File (arquivo) -> Open Folder (abrir pasta)
- Ctrl + shift + P
- Digitar spring
- Selecionar Spring Initializr: Create a Maven Project
- Qual a versão do Spring Framework (a última)
- Qual a linguagem: Java ❤
- Qual o pacote base do projeto: domínio da empresa (univille.br) usar invertido (br.univille)
- Qual o nome do projeto? (não usar espaço ou caracter especial)
- Qual a forma de empacotamento: JAR
- Qual a versão do JDK: 11 (depende da versão instalada no seu computador)
- Quais são as dependências do projeto:
  - Spring Web (clicar para selecionar)
  - Spring Boot DevTools (clicar para selecionar)
  - Thymeleaf (clicar e selecionar)
- Clicar em Selected N dependencies
- Selecionar a pasta onde o projeto será criado (usar a mesma que foi utilizada no passo 1)
- Retorno que o projeto foi criado com sucesso, clicar em OPEN

## Como adicionar uma nova dependência no projeto
- Opção 1
- Ctrl + shift + P
- Spring Initializr: Add Starters
- Digito o nome da dependência: exemplo Thymeleaf
- Clicar sobre o nome da dependência desejada
- Clicar sobre Selected N dependencies
- Clicar em Proceed
- Salvar o arquivo POM
- "A build file was modified. Do you want to synchronize de java classpath?" Always (SEMPRE)

- Opção 2
- Acessar o site https://mvnrepository.com/
- Procurar pela dependência desejada: ex: bootstrap / jquery
- Listar as versões e então você seleciona a versão desejada
- O site sugere o XML necessário para incluir a dependência, então copie o XML
- Volta no projeto, abre o arquivo POM.xml
- Procura a TAG <dependencies>
- Dentro do corpo da tag, colar o XML copiado do site
- Salvar o arquivo

## Configuração para conexão no banco de dados relacional
- Adicionar dependências (Spring Data JPA, H2, MariaDB JDBC Driver)
- Configurar a conexão da aplicação com o banco de dados no arquivo application.properties


## Estrutura do projeto
- Pacote src: todo o código da aplicação (Java, HTML, CSS, JS)
- Pacote target: código compilado e gerado pelo Maven
- Arquivo pom.xml: arquivo descritor utilizado pelo Maven para download das dependências e build de aplicação
- <nomedoprojeto>Application.java - main da aplicação Java
- Pacote controller: classes que são responsáveis por tratar as requisições HTTP enviadas para as rotas definidas por anotação


## Executar a aplicação
- Encontrar o Spring Boot Dashboard
- Clicar no icone de Play do lado do nome do projeto

## Publicação da aplicação no Azure

https://learn.microsoft.com/pt-br/azure/app-service/quickstart-java?tabs=javase&pivots=platform-linux-development-environment-maven