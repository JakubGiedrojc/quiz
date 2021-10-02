package pl.sdacademy.projektplus.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sdacademy.projektplus.quiz.dto.CategoriesDto;
import pl.sdacademy.projektplus.quiz.dto.QuestionsDto;
import pl.sdacademy.projektplus.quiz.frontend.GameOptions;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@Log
@Service
public class QuickDataService {

    public List<CategoriesDto.CategoryDto> getQuizCategories() {
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz categories: " + result.getCategories());
        return result.getCategories();
    }
    public List<QuestionsDto.QuestionDto> getQuizQuestions(GameOptions gameOptions){
        RestTemplate restTemplate=new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount",gameOptions.getNumberOfQuestion())
                .queryParam("category",gameOptions.getCategoryId())
                .queryParam("difficulty",gameOptions.getDifficulty().name().toLowerCase(Locale.ROOT))
                .build().toUri();
        log.info("Quiz question retrieve: "+uri);
        QuestionsDto result =restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Quiz questions: "+result.getResults());
        return result.getResults();
    }
}
