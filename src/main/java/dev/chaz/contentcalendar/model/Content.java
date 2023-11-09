package dev.chaz.contentcalendar.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.relational.core.mapping.Column;

public record Content(
    
    @Id
    Integer id,
    Integer hits,
    @NotBlank
    String title,
    String description,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated,
    String url,

    @Column("author_id")
    Author author
) {
    
}
