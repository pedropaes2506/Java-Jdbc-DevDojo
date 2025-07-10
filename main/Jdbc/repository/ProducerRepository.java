package main.Jdbc.repository;

import lombok.extern.log4j.Log4j2;
import main.Jdbc.conn.ConnectionFactory;
import main.Jdbc.dominio.Producer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void  save(Producer producer){
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer in the database, rows affected '{}'", rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
