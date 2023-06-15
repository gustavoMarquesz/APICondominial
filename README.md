
# APICondominial

Como usar? 
Dê uma boa olhada no graddle e suas depêndencias, vejam o spring e sua versão também. 
No application.proprieties você vai se deparar com o seguinte: 

- Altera a estrutura da tabela caso a entidade tenha mudanças.
spring.jpa.hibernate.ddl-auto=update

- Acesso ao banco de dados - aqui você vai configurar o seu banco, como não existe esse banco no seu computador se atente a modificar ou criar um igual
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/propigdata

- Usuário do banco de dados geralmente todos são root
.spring.datasource.username=root

- Senha do banco de dados - a senha você que indica
spring.datasource.password=suaSenhaAqui

spring.mvc.pathmatch.matching-strategy=ant-path-matcher



Nossa arquitetura de pastas ficou assim:

![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/ea990a6b-ac6b-42b7-a342-7585bc198863)

Ficamos com a parte de EVENTOS, e nossa entidade ficou da seguinte maneira: 
![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/adb2a631-145c-45a8-bd60-f8907884bab8)

Usamos uma interface disponibilizada pelo JPA, a Jpa repository, onde ele oferece vários métodos, como findById, findAll, save, update, delete... 
como pudemos observar na imagem a seguir, adicionei mais dois: findByTipo e findByData, onde como os nomes sugerem acha por data e por tipo de evento (string)

![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/52aa86e0-a538-4b27-9519-392dc3a291eb)


Em nosso Swagger, conseguimos ver todos os métodos do EventroController, que por sua vez comome o EventoService por meio de injeção de dependência usando a anotação @Autowirred
![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/c7a14725-ab90-4c16-bd44-2bb8632d5c36)

Vamos dar uma olhada no postman? 
Para salvar precisamos acessar o endereço que se encontra na imagem, para ver se deu tudo certo o postman precisa retornar 201(created)

![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/a599d623-de41-4dd9-b0c6-51feaa612624)


Um exemplo de um GET por ID 

![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/eb22e36c-2300-4f6e-aa92-3c4145a153f1)


E agora um exemplo de um GET por data: 

![image](https://github.com/gustavoMarquesz/APICondominial/assets/29557719/086742f4-6a75-41c5-910e-a6bbb8b0e0ee)








