package dev.chaz.contentcalendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.chaz.contentcalendar.controller.repository.ContentRepository;
import dev.chaz.contentcalendar.model.Content;
import dev.chaz.contentcalendar.model.Status;
import dev.chaz.contentcalendar.model.Type;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {

			Content content = new Content(
				null,
				5,
				"Introduction to chatGPT",
				"Blog About chatGPt and Generative AI stuff",
				Status.IDEA,
				Type.VIDEO,
				LocalDateTime.now(),
				null,
				""
			);

			repository.save(content);
			repository.save(new Content(
				null,
				5,
				"Blog 2",
				"Blog 2 About Insurance, etc.",
				Status.IN_PROGRESS,
				Type.CONFERENCE_TALK,
				LocalDateTime.now(),
				null,
				"https://test.blog2.com"
			));

			repository.save(new Content(
				null,
				8,
				"Blog 3",
				"Some financial stuff",
				Status.PUBLISHED,
				Type.COURSE,
				LocalDateTime.now(),
				null,
				"https://test.blog3.com"
			));

			repository.save(new Content(
				null,
				4,
				"Blog 3",
				"Blog 3 About Insurance, etc.",
				Status.IN_PROGRESS,
				Type.CONFERENCE_TALK,
				LocalDateTime.now(),
				null,
				"https://test.blog3.com"
			));

			

		};
	}

}
