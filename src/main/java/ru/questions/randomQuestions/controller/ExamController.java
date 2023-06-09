package ru.questions.randomQuestions.controller;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.questions.randomQuestions.model.Question;
import ru.questions.randomQuestions.service.ExaminerService;

@RestController
public class ExamController {

  private final ExaminerService examinerService;

  public ExamController(ExaminerService examinerService) {
    this.examinerService = examinerService;
  }

  @GetMapping("/get/{amount}")
  public Collection<Question> getQuestions(@PathVariable int amount) {
    return examinerService.getQuestions(amount);
  }

}
