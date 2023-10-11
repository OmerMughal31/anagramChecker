package beyonnex.interview.task;

import beyonnex.task.main.AnagramCheckerRestApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"beyonnex"})
public class TaskApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskApplication.class, args);
	}
}
