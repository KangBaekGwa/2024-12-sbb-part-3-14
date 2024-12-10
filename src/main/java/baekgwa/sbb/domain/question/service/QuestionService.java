package baekgwa.sbb.domain.question.service;

import baekgwa.sbb.domain.question.dto.QuestionDto;
import java.util.List;

public interface QuestionService {
    List<QuestionDto.MainInfo> getList();

    QuestionDto.DetailInfo getQuestion(Integer id);

    void create(String subject, String content);
}