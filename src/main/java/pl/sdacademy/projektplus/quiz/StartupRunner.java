package pl.sdacademy.projektplus.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.projektplus.quiz.database.repositories.PlayerEntityRepository;
import pl.sdacademy.projektplus.quiz.services.QuickDataService;

import javax.transaction.Transactional;

@Component
@Log
public class StartupRunner implements CommandLineRunner {
    @Autowired
    private PlayerEntityRepository playerEntityRepository;
    @Autowired
    private QuickDataService quickDataService;


    @Override
    @Transactional
    public void run(String...args) throws Exception {
        log.info("Executing startup actions...");
        quickDataService.getQuizCategories();
        //quickDataService.getQuizQuestions();
        /*playerEntityRepository.save(new PlayerEntity("John"));
        playerEntityRepository.save(new PlayerEntity("Harry"));
        playerEntityRepository.save(new PlayerEntity("George"));

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDatabase = playerEntityRepository.findAll();
        for (PlayerEntity player : playersFromDatabase) {
            log.info("Retrieved player: " + player);
        }*/

    }
}
