package com;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.data.*;
import com.service.*;

public class MainCall {
	private static List<User> users = new ArrayList<>();
	private static List<Route> routes = new ArrayList<>();
	private static List<Order> orders = new ArrayList<>();
	private static Map<String, Integer> userInvalidLoginAttempt = new HashMap<>();
	private static UserService userService = new UserService(users, userInvalidLoginAttempt);
	private static JourneyService journeyService = new JourneyService(routes, orders);
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to JAGGU travels");
		initializeRoutes();
		showMenuOptions();
		
	}
	private static void initializeRoutes() {
		routes.add(new Route(1,"Vijayawada", "Bangalore", LocalDate.parse("2025-04-11", DateTimeFormatter.ISO_LOCAL_DATE),900,30));
		routes.add(new Route(2,"Gudivada", "Bangalore", LocalDate.parse("2025-04-12", DateTimeFormatter.ISO_LOCAL_DATE),900,30));
		routes.add(new Route(3,"Bangalore", "Vijayawada", LocalDate.parse("2025-04-13", DateTimeFormatter.ISO_LOCAL_DATE),900,30));
		routes.add(new Route(4,"Vijayawada", "Hyderabad", LocalDate.parse("2025-04-14", DateTimeFormatter.ISO_LOCAL_DATE),900,30));
	}
	
	private static void showMenuOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean running = true;
		
		while(running) {
			System.out.println("\n Menu Options: ");
			System.out.println("1. New User Registration");
			System.out.println("2. Login");
			System.out.println("3. Plan Journey");
			System.out.println("4. Reschedule Booking");
			System.out.println("5. Exit");
			
			System.out.print("Enter your Choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				userService.registerNewAdmin();
				break;
			case 2:
				userService.login();
				break;
			case 3:
				journeyService.planJourney();;
				break;
			case 4:
				journeyService.reScheduleJourney();;
				break;
			case 5:
				System.out.println("Exiting......");
				running = false;
				break;
			default:
				System.out.println("Invalid Input. Plz try again...");
			
			}
		}
	}

}
