package week9.week9.service;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import week9.week9.dto.NotificationRequest;
import week9.week9.model.Notification;
import week9.week9.model.NotificationType;
import week9.week9.repository.NotificationRepository;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification send(NotificationRequest request) {

        if (request.getType() == NotificationType.EMAIL &&
                request.getSubject() == null) {
            throw new ValidationException("Subject required for email");
        }

        // Simulate sending
        System.out.println("Sending " + request.getType() +
                " to " + request.getRecipient());

        Notification notification = new Notification(
                null,
                request.getRecipient(),
                request.getType(),
                request.getSubject(),
                request.getBody(),
                "SENT",
                LocalDateTime.now()
        );

        return repository.save(notification);
    }

    public Page<Notification> getAll(int page, int limit) {
        return repository.findAll(
                PageRequest.of(page, limit, Sort.by("timestamp").descending())
        );
    }
}
