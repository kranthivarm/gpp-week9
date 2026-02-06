package week9.week9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import week9.week9.model.NotificationType;

@Data
public class NotificationRequest {

    @NotBlank
    private String recipient;

    @NotNull
    private NotificationType type;

    private String subject;

    @NotBlank
    private String body;
}
