package ru.questions.randomQuestions.service;

import java.util.Collection;
import ru.questions.randomQuestions.model.Question;

public interface ExaminerService {

  Collection<Question> getQuestions(int amount);

}
