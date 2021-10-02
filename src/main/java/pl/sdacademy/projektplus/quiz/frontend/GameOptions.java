package pl.sdacademy.projektplus.quiz.frontend;

import lombok.Data;

@Data
public class GameOptions {
    private int numberOfQuestion=5;
    private Difficulty difficulty;
    private int categoryId;
}
