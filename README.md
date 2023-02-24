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

## Métodos e endpoints para criar e editar registros da classe Person
| Método | Endpoint | Função |
|--------|----------|--------|
| POST | `http://localhost:8080/api/people`| Criar registro de nova pessoa |

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
| PUT | `http://localhost:8080/api/people/{id}`| Alterar o registro de uma pessoa existente através do ID |

Exemplo Request JSON (alterando a pessoa com ID 1):
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
| DELETE | `http://localhost:8080/api/people/{id}`| Deletar o registro de uma pessoa pelo ID |

Retorna Status 200 OK
<br>
<hr>

## Métodos e endpoints para criar e alterar registros da classe Address
| Método | Endpoint | Função |
|--------|----------|--------|
| POST | `http://localhost:8080/api/addresses`| Criar um novo endereço e atribuí-lo à pessoa do ID passado como atributo |

Exemplo Request JSON:
```
{
    "personId" : 1,
    "street" : "Rua Sarmento Leite",
    "postalCode" : "90050-170",
    "number" : 1024,
    "city" : "Porto Alegre",
    "addressType" : "MAIN"
}
```

Exemplo Response JSON:
```
{
    "addressId": 1,
    "personId": 1,
    "street": "Rua Sarmento Leite",
    "postalCode": "90050-170",
    "number": 1024,
    "city": "Porto Alegre",
    "addressType": "MAIN"
}
```
<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| POST | `http://localhost:8080/api/addresses`| Adicionar um endereço secundário à pessoa do ID passado como atributo |

Exemplo Request JSON:
```
{
    "personId" : 1,
    "street" : "Rua Garibaldi",
    "postalCode" : "90035-971",
    "number" : 633,
    "city" : "Porto Alegre",
    "addressType" : "SECONDARY"
}
```

Exemplo Response JSON: 
```
{
    "addressId": 2,
    "personId": 1,
    "street": "Rua Garibaldi",
    "postalCode": "90035-971",
    "number": 633,
    "city": "Porto Alegre",
    "addressType": "SECONDARY"
}
```

<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| PUT | `http://localhost:8080/api/addresses/{id}`| Alterar o registro de um endereço existente através do ID |

Exemplo JSON Request (alterando o atributo 'number' do endereço de ID 1):
```
{
    "personId" : 1,
    "street": "Rua Sarmento Leite",
    "postalCode": "90050-170",
    "number": 1034,
    "city": "Porto Alegre",
    "addressType": "MAIN"
}
```
Exemplo JSON Response:
```
{
    "id": 1,
    "street": "Rua Sarmento Leite",
    "postalCode": "90050-170",
    "number": 1034,
    "city": "Porto Alegre",
    "addressType": "MAIN"
}
```

<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| GET | `http://localhost:8080/api/addresses/{id}`| Buscar um endereço pelo ID |

Exemplo JSON Response (buscando pelo endereço de ID 1):
```
{
    "id": 1,
    "street": "Rua Sarmento Leite",
    "postalCode": "90050-170",
    "number": 1034,
    "city": "Porto Alegre",
    "addressType": "MAIN"
}
```

<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| GET | `http://localhost:8080/api/addresses`| Buscar todos os endereços cadastrados |

Exemplo JSON Response:
```
[
    {
        "id": 1,
        "street": "Rua Sarmento Leite",
        "postalCode": "90050-170",
        "number": 1024,
        "city": "Porto Alegre",
        "addressType": "MAIN"
    },
    {
        "id": 2,
        "street": "Rua Garibaldi",
        "postalCode": "90035-971",
        "number": 633,
        "city": "Porto Alegre",
        "addressType": "SECONDARY"
    }
]
```

<hr>

| Método | Endpoint | Função |
|--------|----------|--------|
| DELETE | `http://localhost:8080/api/addresses/{id}`| Deletar o registro de uma pessoa pelo ID |

Retorna Status 200 OK

<hr>

## Métodos para buscar registros de pessoas, após atribuição de endereços:

| Método | Endpoint | Função |
|--------|----------|--------|
| GET | `http://localhost:8080/api/people/{id}`| Buscar uma pessoa pelo ID |

Exemplo Response JSON (buscando pela pessoa com ID 1):

```
{
    "id": 1,
    "name": "Luiza Alves dos Santos",
    "birthDate": "10/07/1994",
    "addresses": [
        {
            "id": 1,
            "street": "Rua Sarmento Leite",
            "postalCode": "90050-170",
            "number": 1024,
            "city": "Porto Alegre",
            "addressType": "MAIN"
        },
        {
            "id": 2,
            "street": "Rua Garibaldi",
            "postalCode": "90035-971",
            "number": 633,
            "city": "Porto Alegre",
            "addressType": "SECONDARY"
        }
    ]
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
        "addresses": [
            {
                "id": 1,
                "street": "Rua Sarmento Leite",
                "postalCode": "90050-170",
                "number": 1024,
                "city": "Porto Alegre",
                "addressType": "MAIN"
            },
            {
                "id": 2,
                "street": "Rua Garibaldi",
                "postalCode": "90035-971",
                "number": 633,
                "city": "Porto Alegre",
                "addressType": "SECONDARY"
            }
        ]
    },
    {
        "id": 2,
        "name": "Maria Alves dos Santos",
        "birthDate": "10/10/1954",
        "addresses": [
            {
                "id": 3,
                "street": "Avenida Ipiranga",
                "postalCode": "91530-000",
                "number": 7200,
                "city": "Porto Alegre",
                "addressType": "MAIN"
            }
        ]
    }
]
```

