package rpg.src.main.java;

import java.io.Console;

import rpg.src.main.java.characters.Player;

public class Driver {
    private static GameManager gameManager;
    private static Console console;
    public static void main(String[] args) {
        gameManager = GameManager.getInstance();
        console = System.console();
        if (console == null) {
            System.err.println("No console found");
            return;
        }

        startIntro();
    }

    private static void startIntro() {
        String playerName = console.readLine("What is your name? ");
        System.out.println("Creating player...");
        gameManager.createPlayer(playerName);
        Player player = gameManager.getPlayer();
        System.out.println(String.format("Hi %s, welcome to your new life", player.getName()));
        boolean randomizingStats = false;
        do {
            System.out.println("Here are your stats!");
            System.out.println(player.getStats());
            String response = console.readLine("Would you like to re-roll (y/n)? ");
            switch (response) {
                case "y":
                    player.createStats();
                    randomizingStats = true;
                    break;
                case "n":
                default:
                    randomizingStats = false;
            }
        } while (randomizingStats);

        System.out.println("""
                Glad that you're happy with your stats!
                Let's get started, adventure awaits!
                """);
    }
}