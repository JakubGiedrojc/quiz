package pl.sdacademy.projektplus.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.projektplus.quiz.dto.CategoriesDto;

@Log
@Service
public class QuickDataService {
    public void getQuizCategories(){
        RestTemplate restTemplate=new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz categories: "+result.getCategories());
    }
}
