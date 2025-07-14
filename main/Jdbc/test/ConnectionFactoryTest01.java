package main.Jdbc.test;

import lombok.extern.log4j.Log4j2;
import main.Jdbc.dominio.Producer;
import main.Jdbc.service.ProducerService;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//        ProducerService.save(producer);
//        ProducerService.delete(4);
//        ProducerService.delete(5);
//        ProducerService.delete(6);
//        ProducerService.delete(7);
//        ProducerService.delete(8);
//        ProducerService.delete(9);
//        ProducerService.update(producerToUpdate);
//        List<Producer> producers = ProducerService.findAll();
//        List<Producer> producers = ProducerService.findByName("Mad");
//        log.info("Producers found '{}'", producers);
//        ProducerService.showProducerMetaData();
        ProducerService.showDriverMetaData();
    }
}
