package ru.questions.randomQuestions.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;
import ru.questions.randomQuestions.exception.QuestionAlreadyExistsException;
import ru.questions.randomQuestions.exception.QuestionNotFoundException;
import ru.questions.randomQuestions.exception.QuestionsAreEmptyException;
import ru.questions.randomQuestions.model.Question;
import ru.questions.randomQuestions.service.QuestionService;

@Service
public class JavaQuestionService implements QuestionService {

  private final Set<Question> questions = new HashSet<>();
  private final Random random = new Random();

  @Override
  public Question add(String question, String answer) {
    return add(new Question(question, answer));
  }

  @Override
  public Question add(Question question) {
    if (!questions.add(question)) {
      throw new QuestionAlreadyExistsException();
    }
    return question;
  }

  @Override
  public Question remove(Question question) {
    if (!questions.remove(question)) {
      throw new QuestionNotFoundException();
    }
    return question;
  }

  @Override
  public Collection<Question> getAll() {
    return Collections.unmodifiableCollection(questions);
  }

  @Override
  public Question getRandomQuestion() {
    if (questions.isEmpty()) {
      throw new QuestionsAreEmptyException();
    }
    return new ArrayList<>(questions).get(random.nextInt(questions.size()));
  }

}
