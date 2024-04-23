package apiaut.apiaut.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfigurarion {
    @Bean // Objeto do spring
    public DataSource dataSource() {

        //Objeto do tipo Gerenciador de banco
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Informo qual o a classe do drive
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //URL do banco de dados
        dataSource.setUrl("jdbc:mysql://bajef937jjb2nn6nzv6q-mysql.services.clever-cloud.com/bajef937jjb2nn6nzv6q?useTimezone=true&serverTimezone=UTC");
        //Usuario e senha
        dataSource.setUsername("uekwd8s9d6wkxdyf");
        //Usuario e senha
        dataSource.setPassword("L9f0gvBvh5fjyaaDQlrt");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        // Criando o objeto Hibernate
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        //Informa o tipo de banco que vai ser usado
        adapter.setDatabase(Database.MYSQL);
        //Solicita para mostrar o SQL que está sendo executado
        adapter.setShowSql(true);
        // Caso as tabelas não existam, crie
        adapter.setGenerateDdl(true);
        //Qual o tipo de SQL que vai ser usado
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        //Inicie a conexão
        adapter.setPrepareConnection(true);

        return adapter;

    }
}
