package main.Jdbc.test;

import lombok.extern.log4j.Log4j2;
import main.Jdbc.dominio.Producer;
import main.Jdbc.service.ProducerServiceRowSet;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
        ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);
        log.info("---------------");
        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
        log.info("Producers found: '{}'", producers);
    }
}
