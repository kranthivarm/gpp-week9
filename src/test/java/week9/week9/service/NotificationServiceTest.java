package week9.week9.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import week9.week9.dto.NotificationRequest;
import week9.week9.model.NotificationType;
import week9.week9.repository.NotificationRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationService service;

    @Test
    void shouldSendEmailNotification() {
        NotificationRequest request = new NotificationRequest();
        request.setRecipient("test@example.com");
        request.setType(NotificationType.EMAIL);
        request.setSubject("Hello");
        request.setBody("Welcome");

        service.send(request);

        verify(repository, times(1)).save(org.mockito.ArgumentMatchers.any());
    }
}
