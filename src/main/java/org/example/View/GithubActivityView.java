package org.example.View;

import org.example.Services.GithubClient;
import org.example.Services.InputHandler;
import org.example.Models.Event;
import org.example.Models.User;

import java.net.http.HttpClient;
import java.util.Scanner;

public class GithubActivityView {
    private final HttpClient httpClient;
    private final GithubClient client;
    private final InputHandler inputHandler;
    private Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;
    private String username;

    public GithubActivityView() {
        this.httpClient = HttpClient.newHttpClient();
        this.client = new GithubClient(httpClient);
        this.inputHandler = new InputHandler(scanner);
    }

    public void start() {
        System.out.println("========== || Welcome to the Github CLI || ==========");
        System.out.println("Here you will be able to see the github user and activities associated with");
        this.username = inputHandler.getStringInput("Please enter username: ");

        while (isRunning) {
            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. View User Info");
            System.out.println("2. View Activity Info");
            System.out.println("3. Change username");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = inputHandler.getIntInput();

            navigateMenu(choice);
        }

    }

    private void navigateMenu(int choice) {
        switch (choice) {
            case 1 -> getUserInfo();
            case 2 -> getActivityInfo();
            case 3 -> updateUsername();
            case 4 -> exit();
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private void getUserInfo() {
        User user = client.getUser(username);

        if (user == null) {
            System.out.println("User not found. Please enter correct username");
            updateUsername();
        } else {
            System.out.println(user);
        }
    }

    private void getActivityInfo() {
        Event[] events = client.getEvents(username);

        if (events == null || events.length == 0) {
            System.out.println("Events not found. Most likely username is not found. Please try entering correct username");
            updateUsername();
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    private void updateUsername() {
        this.username = inputHandler.getStringInput("Please enter new username: ");
        System.out.println("Username updated!");
        System.out.println("Username: " + username);
    }

    private void exit() {
        System.out.println("Exiting...");
        isRunning = false;
        scanner.close();
        System.exit(0);
    }
}
