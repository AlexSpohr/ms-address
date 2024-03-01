# Challenge III - PB Springboot Dez 2023
> Status: Entregue
-------------------------------------------------------------------------------------------------------


O MS Address tem a responsabilidade de armazenar os endereços e vincula-lo a um usuário.

### Colaborador - Alex Spohr

<table>
  <tr>
    <td>E-mail</td>
    <td>GitHub</td>
  </tr>
   <tr>
    <td>alex.spohr.pb@compasso.com.br</td>
    <td>AlexSpohr</td>
  </tr>
</table>

-------------------------------------------------------------------------------------------------------

### Tecnologias Utilizadas
<table>
  <tr>
    <td>Java</td>
    <td>Spring</td>
    <td>MySql</td>
  </tr>
  <tr>
    <td>17.*</td>
    <td>3.2</td>
    <td>8.0</td>
  </tr>
</table>

-------------------------------------------------------------------------------------------------------

### Setup
1. Clone o repositório
```
git clone https://github.com/AlexSpohr/ms-address.git
```
2. Configure o banco de dados no arquivo `application.properties`  


3. Execute a aplicação
```
mvn spring-boot:run
```
A aplicação deverá estar em execução e acessível em http://localhost:8081/

-------------------------------------------------------------------------------------------------------

### Endpoints MS Address

`POST - /v1/address/:cep`

Criar/Retorna um endereço.  
Precisa estar relacionado com o MS User, na qual ele irá receber no path um cep que se ainda não estiver cadastrado  
no sistema, irá salvar a partir de uma busca realizada no viacep e retornar o endereço completo, caso contrário,  
somente irá retornar o endereço já existente.


`GET - /v1/address/:id`

usado para recuperar um endereço específico do sistema. O :id no caminho do URL é um parâmetro que deve ser  
substituído pelo ID do endereço que você deseja recuperar.  Quando este endpoint é chamado, o sistema irá procurar   
no banco de dados um endereço com o ID fornecido. Se um endereço com esse ID for encontrado, o sistema retornará os   
detalhes desse endereço como uma resposta. 
-------------------------------------------------------------------------------------------------------

### Link Swagger

http://localhost:8081/swagger-ui/index.html

-------------------------------------------------------------------------------------------------------


