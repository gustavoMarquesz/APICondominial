# APICondominial


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


