package week9.week9.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week9.week9.dto.NotificationRequest;
import week9.week9.model.Notification;
import week9.week9.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Notification> send(
            @Valid @RequestBody NotificationRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.send(request));
    }

    @GetMapping
    public Page<Notification> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        return service.getAll(page, limit);
    }
}
