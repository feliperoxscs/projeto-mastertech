## SistemaPonto

### GET /usuario
Exibe a lista de usuarios no sistema.

**Response 200**
```json
[
    {
        "id": 1,
        "nomeCompleto": "Felipe",
        "cpf": "123-123-123-12",
        "email": "felipe1234@hotmail.com",
        "dataCadastro": "21/02/2015"
    },
    {
        "id": 2,
        "nomeCompleto": "Anilda",
        "cpf": "460-332-758-71",
        "email": "anilda@hotmail.com",
        "dataCadastro": "21/05/2015"
    }
]
```

### GET /usuario/{id}
Exibe a o usuario do sistema de acordo com o id fornecido.

**Response 200**
```json
{
    "id": 1,
    "nomeCompleto": "Felipe",
    "cpf": "123-123-123-12",
    "email": "felipe1234@hotmail.com",
    "dataCadastro": "21/02/2015"
}
```

**Response 404**

### POST /usuario
Cria um usuário no sistema.

**Request Body**
```json
{
    "nomeCompleto": "teste",
    "cpf": "460-332-758-71",
    "email": "teste1234@hotmail.com",
    "dataCadastro": "21/02/2015"
}
```
**Response 201**

**Response 422**
```json
{
    "id": 2,
    "nomeCompleto": "Anilda",
    "cpf": "460-332-758-71",
    "email": "anilda@hotmail.com",
    "dataCadastro": "21/05/2015"
}
```

### PUT /usuario/{id}
Atualiza informações do usuario como nome, cpf e email.
**Request Body**
```json
{
    "nomeCompleto": "Anilda",
    "cpf": "460-332-758-71",
    "email": "anilda@hotmail.com"
}
```
**RESPONSE 201**

**RESPONSE 404**

## BatidaPonto

### POST /baterPonto/{id}
Endpoint que faz o registro do ponto passando o id do usuario.

**Request Body**
```json
{
	"dataBatida":"2020-06-06T20:40:00",
	"tipoBatida":"saida"
}
```
ou
```json
{
	"dataBatida":"2020-06-06T14:40:00",
	"tipoBatida":"entrada"
}
```
**Response 201**
```json
{
    "id": 11,
    "idUsuario": 2,
    "dataBatida": "2020-06-06T20:40:00.000+00:00",
    "tipoBatida": "saida"
}
```

**Response 404**

### GET /ponto/{id}
Exibe todas as marcações de ponto de um determinado usuário passando seu id.

**Response 200**
```json
{
    "batidasPonto": [
        {
            "id": 8,
            "idUsuario": 2,
            "dataBatida": "2020-06-06T10:00:00.000+00:00",
            "tipoBatida": "entrada"
        },
        {
            "id": 9,
            "idUsuario": 2,
            "dataBatida": "2020-06-06T13:00:00.000+00:00",
            "tipoBatida": "saida"
        },
        {
            "id": 10,
            "idUsuario": 2,
            "dataBatida": "2020-06-06T14:15:00.000+00:00",
            "tipoBatida": "entrada"
        },
        {
            "id": 11,
            "idUsuario": 2,
            "dataBatida": "2020-06-06T20:40:00.000+00:00",
            "tipoBatida": "saida"
        }
    ],
    "totalHorasTrabalhadas": "09:25:00"
}
```
**Response 404**