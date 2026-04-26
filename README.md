# 📚 Student Management API

API REST para gerenciamento de alunos e suas matrículas, desenvolvida com **Java + Spring Boot**, aplicando boas práticas como DTOs, camada de serviço e documentação com Swagger.

---

## 🚀 Funcionalidades

### 👨‍🎓 Alunos (Students)

* ✅ Cadastro um aluno junto com suas matrículas
* ✅ Listagem de todos os alunos cadastrados
* ✅ Listar todas as matrículas a partir do ID do aluno
* ✅ Atualização de dados do aluno ( e suas matrículas associadas )
* ✅ Remoção de alunos ( e matrículas associadas ) 
* ✅ Validação de dados de entrada
* ✅ Tratamento global de exceções
---

## 🛠️ Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation
* Lombok
* Swagger / OpenAPI
* H2 Database
* Maven

---

## 📌 Endpoints

### Base URL

```bash
/api/v1/students
🔹 Criar aluno

POST /

Request
{
  "name": "João",
  "telephone": "11999999999",
  "birthDate": "2000-01-01",
  "enrollments": [
    {
      "courseName": "Math",
      "enrollmentCod": "matricula-001",
      "startDate": "2024-01-01"
    }
  ]
}
🔹 Listar todos os alunos

GET /

[
  {
    "id": 1,
    "name": "João",
    "telephone": "11999999999",
    "birthDate": "2000-01-01"
  }
]
🔹 Atualizar aluno

PUT /{id}

Request
{
  "name": "João Silva",
  "telephone": "11988888888",
  "birthDate": "2000-01-01",
  "enrollments": [
    {
      "id": 1,
      "courseName": "Physics",
      "startDate": "2024-02-01"
    },
    {
      "courseName": "Chemistry",
      "startDate": "2024-03-01"
    }
  ]
}

👉 Comportamento:

Se id existir → atualiza matrícula
Se não tiver id → cria nova matrícula
🔹 Remover aluno

DELETE /{id}

204 No Content
🔹 Buscar matrículas por aluno

GET /{id}

{
  "name": "João",
  "enrollments": [
    {
      "id": 1,
      "courseName": "Math",
      "startDate": "2024-01-01"
    }
  ]
}

## ❗ Validações

* `name` → obrigatório
* `telephone` → obrigatório e deve conter 11 dígitos
* `birthDate` → obrigatório e deve ser uma data no passado

---

## ⚠️ Tratamento de Exceções

O projeto possui tratamento global de exceções via `@RestControllerAdvice`.

### Principais erros tratados:

* `StudentNotFoundException` → aluno não encontrado (404)
* `MethodArgumentNotValidException` → validação de campos (400)
* Exception → erro inesperado (500)

### Exemplo de resposta de erro:

```json
{
  "path": "/api/v1/students/10",
  "method": "GET",
  "status": 404,
  "statusText": "Not Found",
  "message": "Student not found. ID = 10"
}
```

---

## 📖 Documentação da API (Swagger)

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Como rodar o projeto

```bash
git clone https://github.com/acsanfrancisco/student-management-api.git
cd student-management-api
./mvnw spring-boot:run
```
## 🔧 Variáveis de Ambiente (.env)

- Este projeto utiliza variáveis de ambiente para configurar o acesso ao banco de dados.  
- Você encontrará um arquivo `.env.example` com as variáveis necessárias.  
- Crie um arquivo `.env` na raiz do projeto com base no exemplo.
---

## 🧪 Banco de dados

H2 em memória:

```
http://localhost:8080/h2-console
```

---

## 🧱 Arquitetura

* Controller → endpoints REST
* Service → regras de negócio
* Repository → acesso ao banco
* DTOs → transporte de dados
* Mapper → conversão Entity ↔ DTO
* Exception Handler → tratamento global de erros
---

## 📌 Observação

Este projeto foi desenvolvido como parte de um desafio prático baseado no seguinte conteúdo:

https://www.youtube.com/watch?v=R5Rm0ULoJLU&t=184s

---

