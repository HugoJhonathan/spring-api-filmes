![](https://i.imgur.com/sFWQuUL.png)


## Etapa 1 (Criação e configurações iniciais)

 1. 👽  __[`Criação do Projeto Spring 🔗`](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=lombok,web,mysql,liquibase,data-jpa)__ com as dependencias **Lombok**, **Spring WEB**, **MySQL Driver**, **Liquibase Migration** e **Spring Data JPA**

<details>

<summary> 
2. ⚙ Configurações do Bando de Dados, JPA e Liquibase ▾
</summary> 

<br>

`src/main/resources/`[__`application.properties`__](https://github.com/HugoJhonathan/spring-api-filmes/blob/atividade-01/filmes/src/main/resources/application.properties) 

```xml
# BANCO DE DADOS CONFIG #
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/filmes
spring.datasource.username=root
spring.datasource.password=

# JPA CONFIG #
spring.jpa.show-sql=true
spring-jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=none

# LIQUIBASE CONFIG #
spring.liquibase.enabled=true
spring.liquibase.drop-first=false
spring.liquibase.change-log=classpath:db/master.xml

```

</details>

<details><summary>
3. ⚙ Configuração Liquibase Changelog (master.xml)  ▾

</summary>

<br>

`src/main/resources/db/`[__`master.xml`__](https://github.com/HugoJhonathan/spring-api-filmes/blob/atividade-01/filmes/src/main/resources/db/master.xml) 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                   http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.3.xsd">

    <property name="bigint" value="java.sql.Types.BIGINT" dbms="mariadb, mysql, postgresql"/>
    <property name="double" value="java.sql.Types.DOUBLE" dbms="mariadb, mysql, postgresql"/>
    <property name="string" value="java.sql.Types.VARCHAR(255)" dbms="mariadb, mysql, postgresql"/>
    <property name="text" value="java.sql.Types.LONGVARCHAR" dbms="mariadb, mysql, postgresql"/>
    <property name="date" value="java.sql.Types.DATE" dbms="mariadb, mysql, postgresql"/>

    <includeAll path="changelog" relativeToChangelogFile="true"></includeAll>
</databaseChangeLog>
```

</details>


<details><summary>
4. ⛏️ Liquibase Changelog (INIT.xml)   ▾
</summary>

<br>

`src/main/resources/db/changelog/`[__`INIT.xml`__](https://github.com/HugoJhonathan/spring-api-filmes/blob/atividade-01/filmes/src/main/resources/db/changelog/INIT.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                   http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.3.xsd">

    <changeSet id="0" author="hugo_"> <!-- Diretor -->
        <preConditions onFail="MARK_RAN" onFailMessage="tabela diretor já existe!">
            <not>
                <tableExists tableName="diretor"/>
            </not>
        </preConditions>
        <createTable tableName="diretor">
            <column name="id" type="${bigint}" autoIncrement="true">
                <constraints primaryKey="true"  primaryKeyName="pk_diretor" nullable="false"></constraints>
            </column>
            <column name="nome" type="${string}">
                <constraints nullable="false"></constraints>
            </column>
        </createTable>
        <addAutoIncrement tableName="diretor" columnName="id" columnDataType="${bigint}" incrementBy="1" startWith="1" />
    </changeSet>



    <changeSet id="1" author="hugo_"> <!-- Filme -->
        <preConditions onFail="MARK_RAN" onFailMessage="tabela filme já existe!" >
            <not>
                <tableExists tableName="filme"/>
            </not>
        </preConditions>
        <createTable tableName="filme">
            <column name="id" type="${bigint}" autoIncrement="true">
                <constraints primaryKey="true" primaryKeyName="pk_filme" nullable="false"></constraints>
            </column>
            <column name="title" type="${string}">
                <constraints nullable="false"></constraints>
            </column>
            <column name="data" type="${date}"/>
            <column name="poster" type="${string}"/>
            <column name="orcamento" type="${double}"/>
            <column name="receita" type="${double}"/>
            <column name="diretor_id" type="${bigint}"/>
        </createTable>
        <addAutoIncrement tableName="filme" columnName="id" columnDataType="${bigint}" incrementBy="1" startWith="1" />
    </changeSet>



    <changeSet id="2" author="hugo_"> <!-- Gênero -->
        <preConditions onFail="MARK_RAN" onFailMessage="tabela genero já existe!">
            <not>
                <tableExists tableName="genero"/>
            </not>
        </preConditions>
        <createTable tableName="genero">
            <column name="id" type="${bigint}" autoIncrement="true">
                <constraints primaryKey="true" primaryKeyName="pk_genero" nullable="false"></constraints>
            </column>
            <column name="nome" type="${string}">
                <constraints nullable="false"/>
            </column>
        </createTable>
        <addAutoIncrement tableName="genero" columnName="id" columnDataType="${bigint}" incrementBy="1" startWith="1" />
    </changeSet>



    <changeSet id="3" author="hugo_"> <!-- Generos_do_filme (associação) -->
        <preConditions onFail="MARK_RAN" onFailMessage="generos_do_filme ja existe">
            <not>
                <tableExists tableName="generos_do_filme"/>
            </not>
        </preConditions>
        <createTable tableName="generos_do_filme" >
            <column name="id_filme" type="${bigint}">
                <constraints nullable="false" />
            </column>
            <column name="id_genero" type="${bigint}">
                <constraints nullable="false"/>
            </column>
        </createTable>
        <addPrimaryKey tableName="generos_do_filme" columnNames="id_filme, id_genero" constraintName="pk_genero_filme"/>
    </changeSet>



    <changeSet id="4" author="hugo_"> <!-- ForeignKeys -->

        <addForeignKeyConstraint constraintName="fk_diretor"
                                 baseTableName="filme"
                                 baseColumnNames="diretor_id"
                                 referencedTableName="diretor"
                                 referencedColumnNames="id"
                                 onDelete="SET NULL"/>

        <addForeignKeyConstraint constraintName="fk_filme"
                                 baseTableName="generos_do_filme"
                                 baseColumnNames="id_filme"
                                 referencedTableName="filme"
                                 referencedColumnNames="id"
                                 onDelete="CASCADE"/>

        <addForeignKeyConstraint constraintName="fk_genero"
                                 baseTableName="generos_do_filme"
                                 baseColumnNames="id_genero"
                                 referencedTableName="genero"
                                 referencedColumnNames="id"
                                 onDelete="CASCADE"/>

        <sqlFile path="import.sql" stripComments="true" />

    </changeSet>

</databaseChangeLog>
```

</details>
