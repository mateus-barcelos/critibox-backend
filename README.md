**CritiBox** é uma API desenvolvida em **Spring Boot** para gerenciamento de séries, episódios e avaliações de usuários.  
O projeto oferece endpoints RESTful que permitem criar, listar e gerenciar conteúdos, além de cadastrar usuários e registrar reviews.

---

## 🚀 Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **Postgres**
---

## 📁 Estrutura do Projeto

```
critibox-backend/
├── src/
│   └── main/
│       ├── java/com/example/critiboxspring/
│       │   ├── controllers/      # Controladores REST
│       │   ├── dto/              # Objetos de transferência de dados
│       │   ├── model/            # Entidades e classes de domínio
│       │   ├── repository/       # Interfaces JPA
│       │   └── critiBoxApplication.java  # Classe principal
│       └── resources/
│           ├── application.properties    # Configurações do projeto
│           └── data.sql (opcional)       # Dados iniciais
├── pom.xml
└── README.md
```

---


### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/critibox-backend.git
   cd critibox-backend
   ```

2. Instale as dependências:
   ```bash
   mvn install
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API:
   ```
   http://localhost:8080
   ```

---

## 📚 Endpoints Principais

| Recurso        | Método | Endpoint               | Descrição                          |
|----------------|--------|------------------------|------------------------------------|
| Séries         | GET    | `/series`              | Lista todas as séries              |
| Séries         | POST   | `/series`              | Cria uma nova série                |
| Episódios      | GET    | `/episodes`            | Lista episódios                    |
| Usuários       | GET    | `/users`               | Lista usuários                     |
| Avaliações     | POST   | `/reviews`             | Cria uma nova review               |





## 🧑‍💻 Autor

**Nome:** Mateus Roberto Barcelos Pereira  
📧 [mateusdilleburg@gmail.com](mailto:mateusdilleburg@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/mateusrbarcelos)

---

## 📝 Licença

Este projeto é de uso livre para fins educacionais e não possui licença comercial definida.
