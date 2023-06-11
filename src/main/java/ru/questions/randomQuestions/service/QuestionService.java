package ru.questions.randomQuestions.service;

import java.util.Collection;
import ru.questions.randomQuestions.model.Question;

public interface QuestionService {

  Question add(String question, String answer);

  Question add(Question question);

  Question remove(Question question);

  Collection<Question> getAll();

  Question getRandomQuestion();

}
