package main.crud.service;

import main.crud.dominio.Anime;
import main.crud.dominio.Producer;
import main.crud.repository.AnimeRepository;
import main.crud.test.CrudTest01;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
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
        AnimeRepository.findByName(name)
                .forEach(p -> System.out.printf("[%d] - %s %d %s\n", p.getId(), p.getName(), p.getEpisodes(), p.getProducer().getName()));
    }

    public static void delete() {
        System.out.println("Type the ID of the anime you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name of the anime you want to insert");
        String name = SCANNER.nextLine();
        System.out.println("Type the number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Type the id of the producer");
        Integer id = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime.builder()
                .episodes(episodes)
                .name(name)
                .producer(Producer.builder().id(id).build())
                .build();
        AnimeRepository.save(anime);
    }

    public static void update() {
        System.out.println("Type the id of the anime you want to update");
        Integer id = Integer.parseInt(SCANNER.nextLine());
        Optional<Anime> animeOptional = AnimeRepository.findById(id);
        if (animeOptional.isEmpty()){
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.println("Anime found " + animeFromDb);
        System.out.println("Type the new name or empty to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;

        System.out.println("Type the new number of episodes or empty to keep the same");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime.builder()
                .id(animeFromDb.getId())
                .name(name)
                .episodes(episodes)
                .producer(animeFromDb.getProducer())
                .build();

        AnimeRepository.update(animeToUpdate);
    }
}
