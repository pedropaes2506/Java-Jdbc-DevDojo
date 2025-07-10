package main.Jdbc.test;

import main.Jdbc.dominio.Producer;
import main.Jdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        ProducerRepository.save(producer);
    }
}
