package main.crud.service;

import main.crud.dominio.Producer;
import main.crud.repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }
    }

    public static void findByName() {
        System.out.println("Type the name or empty to all");
        String name = SCANNER.nextLine();
        ProducerRepository.findByName(name)
                .forEach(p -> System.out.printf("[%d] - %s\n", p.getId(), p.getName()));
    }

    public static void delete() {
        System.out.println("Type the ID of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name of the producer you want to insert");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder()
                .name(name)
                .build();
        ProducerRepository.save(producer);
    }

    public static void update() {
        System.out.println("Type the id of the producer you want to update");
        Integer id = Integer.parseInt(SCANNER.nextLine());
        Optional<Producer> producerOptional = ProducerRepository.findById(id);
        if (producerOptional.isEmpty()){
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDb = producerOptional.get();
        System.out.println("Producer found " + producerFromDb);
        System.out.println("Type the new name or empty to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;

        Producer producerToUpdate = Producer.builder()
                .id(producerFromDb.getId())
                .name(name)
                .build();

        ProducerRepository.update(producerToUpdate);
    }
}
