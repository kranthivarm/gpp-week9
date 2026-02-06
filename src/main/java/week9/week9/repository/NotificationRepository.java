package week9.week9.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import week9.week9.model.Notification;

public interface NotificationRepository
        extends MongoRepository<Notification, String> {
}
