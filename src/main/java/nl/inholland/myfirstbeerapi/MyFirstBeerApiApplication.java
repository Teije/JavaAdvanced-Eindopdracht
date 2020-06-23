package nl.inholland.myfirstbeerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class MyFirstBeerApiApplication {

	// Create a new logger for this application
	private static final Logger logger = Logger.getLogger(MyFirstBeerApiApplication.class.getName());

	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Starting Teije's Beer Shop Application...");
		SpringApplication.run(MyFirstBeerApiApplication.class, args);
	}
}
