# Projeto ValidationRequest

## Visão Geral
O `ValidationRequest` é um projeto focado em validação de requisições. Ele utiliza arquitetura hexagonal para garantir uma separação clara entre as camadas de aplicação.

## Funcionalidades
 - Criar, atualizar e excluir QR Codes
 - Validação de campos obrigatórios em requisições
 - Integração com banco de dados para persistência de QR Codes
 - Consulta e listagem de transações via API

## Tecnologias Utilizadas
 - Kotlin
- Spring Boot
- Hibernate/JPA
- H2 Database (ou outro banco de dados)
- Maven
- JUnit para testes unitários

## Estrutura do Projeto
`src/
├─ adapter/
├─ configuration/
├─ controller/
|  ├─ handler/
|  ├─ mapper/
|  ├─ request/
|  └─ response/
├─ domain/
|  └─ enums/
├─ entity/
├─ exception/
├─ port/
├─ usecase/
|  └─ mapper/`

### Explicação

- **adapter/**: Contém os adaptadores para serviços externos (Banco de dados, APIs, filas, cache, etc.).
- **configuration/**: Configurações do framework (Spring, por exemplo) e outras configurações gerais.
- **controller/**: Ponto de entrada da aplicação, onde são recebidas as requisições via API.
    - **handler/**: Responsável por lidar com exceções específicas.
    - **mapper/**: Realiza conversão entre objetos de domínio e DTOs.
    - **request/**: Modelos de requisição para a API.
    - **response/**: Modelos de resposta para a API.
- **domain/**: Contém as regras de negócio e os objetos principais do domínio.
    - **enums/**: Enumerações relacionadas ao domínio.
- **entity/**: Representa as entidades persistidas no banco de dados.
- **exception/**: Contém exceções relacionadas ao domínio.
- **port/**: Interfaces.
- **usecase/**: Casos de uso que contêm a lógica de negócios.
  - **mapper/**: Converte entre objetos de domínio e entidades/DTOs.

Esse formato organizado facilita a compreensão dos desenvolvedores e colaboradores sobre a estrutura e responsabilidade de cada camada no projeto.

## Como Executar o Projeto
1. Instale as dependências do projeto usando o Maven: `mvn clean install`
2. Execute a aplicação: `mvn spring-boot:run`