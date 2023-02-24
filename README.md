# People Management API

API para gerenciamento de pessoas com as seguintes funcionalidades:

- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereços para a pessoa
- Listar endereços da pessoa
- Informar o endereço principal da pessoa


## Tecnologias Utilizadas
- Java
- SpringBoot
- Maven
- JPA
- H2 - interface do banco de dados deve ser acessada em `http://localhost:8080/`

<hr>

## Métodos e endpoints da classe Person
| Método | Endpoint | Função |
|--------|----------|--------|
| POST | `http://localhost:8080/api/people`| Criar nova pessoa |

Exemplo Request JSON:
```
{
    "name" : "Luiza dos Santos",
    "birthDate" : "1994-07-10"
}
```

Exemplo Response JSON:
```
{
    "id": 1,
    "name": "Luiza dos Santos",
    "birthDate": "10/07/1994"
}
```
<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| PUT | `http://localhost:8080/api/people/{id}`| Alterar um registro de pessoa existente através do ID |

Exemplo Request JSON:
```
{   
    "name" : "Luiza Alves dos Santos",
    "birthDate" : "1994-07-10"
}
```

Exemplo Response JSON: 
```
{
    "id": 1,
    "name": "Luiza Alves dos Santos",
    "birthDate": "10/07/1994",
    "addresses": []
}
```


<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| GET | `http://localhost:8080/api/people`| Buscar todas as pessoas cadastradas |

Exemplo Response JSON:
```
[
    {
        "id": 1,
        "name": "Luiza Alves dos Santos",
        "birthDate": "10/07/1994",
        "addresses": []
    }
]
```








