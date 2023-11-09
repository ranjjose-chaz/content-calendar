package dev.chaz.contentcalendar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Author(
        @Id
        @Column("author_id")
        Integer authorId,
        String name
) {
}
