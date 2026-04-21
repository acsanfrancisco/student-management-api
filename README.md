# 📚 Student Management API

API REST para gerenciamento de alunos e suas matrículas, desenvolvida com **Java + Spring Boot**, aplicando boas práticas como DTOs, camada de serviço e documentação com Swagger.

---

## 🚀 Funcionalidades

### 👨‍🎓 Alunos (Students)

* ✅ Cadastro de aluno
* ✅ Listagem de todos os alunos
* ✅ Atualização de dados do aluno
* ✅ Remoção de alunos
* ✅ Validação de dados de entrada
* ✅ Tratamento global de exceções
* ❌ Cadastro de aluno com matrículas (em desenvolvimento)
* ❌ Listar matrículas por aluno (em desenvolvimento)
* ❌ Atualizar aluno + matrículas (em desenvolvimento)

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

Base URL:

```
/api/v1/students
```

---

### 🔹 Criar aluno

**POST /**

**Request**

```json
{
  "name": "João",
  "telephone": "11999999999",
  "birthDate": "2000-01-01"
}
```

**Response (201)**

```json
{
  "id": 1,
  "name": "João",
  "telephone": "11999999999",
  "birthDate": "2000-01-01"
}
```

---

### 🔹 Listar todos os alunos

**GET /**

```json
[
  {
    "id": 1,
    "name": "João",
    "telephone": "11999999999"
  }
]
```

---

### 🔹 Atualizar aluno

**PATCH /{id}**

```json
{
  "name": "João Silva",
  "telephone": "11988888888",
  "birthDate": "2000-01-01"
}
```

---

### 🔹 Remover aluno

**DELETE /{id}**

```
204 No Content
```

---

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

### Exemplo de resposta de erro:

```json
{
  "path": "/api/v1/students/10",
  "method": "GET",
  "status": 404,
  "statusText": "Not Found",
  "message": "Student not Found"
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
git clone https://github.com/seu-usuario/student-management-api.git
cd student-management-api
./mvnw spring-boot:run
```

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

## 📅 Status do projeto

🚧 Em desenvolvimento

### 📍 Roadmap

* ✅ CRUD de alunos
* ✅ Validações de entrada
* ✅ Tratamento global de exceções
* ✅ Swagger/OpenAPI
* ⚠️ Matrículas (Enrollments)
* ⚠️ Consulta de matrículas por aluno
* ⚠️ Atualização completa com relacionamento

---

## 📌 Observação

Este projeto foi desenvolvido como parte de um desafio prático baseado no seguinte conteúdo:

https://www.youtube.com/watch?v=R5Rm0ULoJLU&t=184s

---

