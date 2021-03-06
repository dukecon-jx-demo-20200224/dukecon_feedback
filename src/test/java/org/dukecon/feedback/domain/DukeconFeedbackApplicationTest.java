package org.dukecon.feedback.domain;

import org.dukecon.feedback.adapters.main.DukeconFeedbackMain;
import org.dukecon.feedback.domain.model.ConferenceId;
import org.dukecon.feedback.domain.model.Feedback;
import org.dukecon.feedback.domain.model.TalkId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(JUnitPlatform.class)
//@ExtendWith(MockitoExtension.class)
@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = DukeconFeedbackMain.class) // FeedbackRepositoryJpa.class)
public class DukeconFeedbackApplicationTest {
    @Mock
    FeedbackStore repository;

    @InjectMocks
    DukeconFeedbackApplication feedbackApplication;

    @Test
    void saveTest () {
        ConferenceId conferenceId = ConferenceId.of("javaland2018");
        TalkId talkId = TalkId.of("12345");
        Feedback feedback
                = Feedback
                .builder()
                .author("Gerd Aschemann")
                .conferenceId(conferenceId)
                .talkId(talkId)
                .comment("No Comment")
                .build();

        feedbackApplication.save(feedback);
    }
}
