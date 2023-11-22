# Apresentando MãeConecta: Sua Aliada Confiável na Jornada da Maternidade 
Bem-vinda ao MãeConecta, o aplicativo que entende que cada momento da gestação é único e que, por vezes, surgem situações inesperadas. Estamos aqui para oferecer suporte e garantir que você esteja sempre no controle da sua saúde e bem-estar durante essa fase especial da vida. 
Recursos Especiais: 
1.	Registro de Procedimentos: Mantenha um histórico detalhado de consultas e exames para acompanhar de perto o progresso da sua gestação. O MãeConecta permite que você registre informações essenciais para discussão com seu profissional de saúde. 
2.	Ocorrências Gestacionais: Registre eventos que demandam atenção especial. Seja um sangramento vaginal, contrações, enxaqueca, ou qualquer outra situação fora do comum, o MãeConecta oferece um espaço seguro para documentar essas ocorrências. Isso permite que você se lembre de relatar esses eventos em consultas ou exames, promovendo uma comunicação eficaz com seu profissional de saúde. 
3.	Contatos de Emergência: Cadastre contatos importantes para situações de emergência, proporcionando a segurança de que você está conectada com quem mais importa. Em momentos críticos, a facilidade de acionar ajuda faz toda a diferença. 
4.	Chat com Assistente Virtual: Converse com nosso assistente virtual especializado em gestação, parto e pré-natal. Tire dúvidas sobre ocorrências gestacionais, receba orientações e sinta-se apoiada a qualquer momento, mantendo-se informada e preparada para cada situação.

No MãeConecta, acreditamos que a informação é a chave para uma gestação saudável. Com nosso aplicativo, tenha ao seu alcance uma ferramenta que não apenas registra momentos especiais, mas que também proporciona suporte essencial em situações imprevistas.

MãeConecta: porque sua jornada é única, e nós estamos aqui para ajudar em cada passo, oferecendo tranquilidade e suporte quando mais você precisa.

- Observações :
       
    - Aqui está o link para o projeto do Front-End (React Native): [https://github.com/mariananieton/MaeConecta-Mobile](https://github.com/mariananieton/MaeConecta-Mobile) Clone o repositorio e nos endpoints deve-se colocar o IP local caso queira emular pelo Android.

- Integrantes : 
    - RM93042 - FILIPE SANTOS DA SILVA
    - RM94467 - FRANKLIN PEREIRA DO NASCIMENTO
    - RM92920 - JOSE GABRIEL DA SILVA COELHO
    - RM94141 - MARIANA NIETON BORGES

--------------------------

### ENDPOINTS


- Usuario Controller
  
    - salvar ( método que faz a persistência tanto de Usuário quanto de Login )

    - buscar por ID ( apenas os dados do Usuário )

    - deletar por ID ( método deleta Usuário, Login, Procedimentos, Ocorrências e Contatos por cascade, pelo ID do usuário )

    - atualizar por ID ( atualiza o Usuário isoladamente )

--------------------------

- Login Controller
  
   - login ( método de autenticação com JWT )

   - atualizar por ID ( atualiza o Login isoladamente )
     
--------------------------

- Procedimento Controller
  
    - salvar ( método que faz a persistência do Procedimento )

    - buscar por ID ( apenas os dados do Procedimento )

    - deletar por ID ( método que deleta o Procedimento e Ocorrências relacionadas por cascade, pelo ID do procedimento )

    - atualizar por ID ( atualiza o Procedimento isoladamente )
      
    - buscar todos por ID do usuário ( busca todos os procedimentos do usuário, de acordo com o id do usuário )

--------------------------

- Ocorrencia Controller
  
    - salvar ( método que faz a persistência da Ocorrência e atrela a um Procedimento já existente, caso passe o procedimentoId )

    - buscar por ID ( apenas os dados da Ocorrência + procedimentoId caso tenha )

    - deletar por ID ( método que deleta a Ocorrência, pelo ID da ocorrência )

    - atualizar por ID ( atualiza a Ocorrência isoladamente )
      
    - buscar todos por ID do usuário ( busca todas as ocorrências do usuário, de acordo com o id do usuário )

--------------------------

- Contato Controller
  
    - salvar ( método que faz a persistência do Contato )

    - buscar por ID ( apenas os dados do Contato )

    - deletar por ID ( método que deleta o Contato, pelo ID do Contato )

    - atualizar por ID ( atualiza o Contato isoladamente )
      
    - buscar todos por ID do usuário ( busca todos os contatos do usuário, de acordo com o id do usuário )

--------------------------

- Chat Controller
  
    - enviar mensagem ( método que envia uma request a integração com o ChatGPT )

--------------------------

### Usuario Controller

### Salvar usuário

`POST` /api/v1/usuario - não requer autenticação

**Campos da Requisição**

- Usuario

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | String | sim | o nome do usuario deve ser entre 3 a 200
|dataNascimento | LocalDate | sim | a data do usuario deve ser no formato YYYY-MM-DD
|semanasGestacao | Integer | sim | o número de semanas de gestação
|tipoSanguineo | String | sim | deve estar no formato "O+" ou "AB-" 

- Login

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|email | String | sim | o valor do email, único
|senha | String | sim | a senha não pode ser nula e vai ser criptografada

**Exemplo de corpo de requisição**

```js
{
    "nome": "Bella Swan",
    "dataNascimento": "2000-04-17",
    "semanasGestacao": 24,
    "tipoSanguineo":"O-",
    "login": {
        "email": "bella@swan.com",
        "senha": "12345678"
    }
}

```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | Usuário salvo
| 400 | Campos inválidos
----

### Detalhes do Usuário - buscar por ID 

`GET` /api/v1/usuario{id} - requer autenticação

**Exemplo de corpo de resposta**

```js

{
    "id": 1,
    "nome": "Bella Swan",
    "dataNascimento": "2000-04-17",
    "dataCadastro": "2023-11-22",
    "tipoSanguineo": "O-",
    "semanasGestacao": 24
}

```

**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Dados do usuário retornados
| 404 | Não existe usuário com o ID informado
------------------

### Deleta usuário por ID 

`DELETE` /api/v1/usuario{id} - requer autenticação

**Códigos de Respostas**

| código | descrição
|-|-
| 204 | Usuário deletado
| 403 | Não autorizado
----
### Atualiza usuário por ID 

`PUT` /api/v1/usuario/{id} - requer autenticação

**Campos da Requisição**

- Usuario

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | String | sim | o nome do usuario deve ser entre 3 a 200
|dataNascimento | LocalDate | sim | a data do usuario deve ser no formato YYYY-MM-DD
|semanasGestacao | Integer | sim | o número de semanas de gestação
|tipoSanguineo | String | sim | deve estar no formato "O+" ou "AB-" 


**Exemplo de corpo de requisição**

```js
{
    "nome": "Hayley Williams",
    "dataNascimento": "2000-11-15",
    "semanasGestacao": 40,
    "tipoSanguineo":"AB-"
}

```

**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Usuário salvo
| 400 | Campos inválidos
----
