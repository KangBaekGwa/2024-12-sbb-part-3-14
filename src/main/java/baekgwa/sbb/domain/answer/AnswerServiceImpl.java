package baekgwa.sbb.domain.answer;

import baekgwa.sbb.global.exception.DataNotFoundException;
import baekgwa.sbb.model.answer.Answer;
import baekgwa.sbb.model.answer.AnswerRepository;
import baekgwa.sbb.model.question.Question;
import baekgwa.sbb.model.question.QuestionRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    @Override
    public void create(Integer id, String content) {
        Question question = questionRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("question not found"));

        Answer answer = Answer
                .builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .question(question)
                .build();

        answerRepository.save(answer);
    }

    @Override
    public Question getQuestionByIdAndAnswers(Integer id) {
        return questionRepository.findByIdWithAnswers(id).orElseThrow(
                () -> new DataNotFoundException("question not found"));
    }
}