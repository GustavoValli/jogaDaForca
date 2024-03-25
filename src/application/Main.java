package application;

import entities.Game;
import entities.exceptions.GameException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean playAgain = true;
        boolean playing = true;

        System.out.println("Bem vindo ao jogo da forca!");

        while (playAgain) {
            Scanner scanner = new Scanner(System.in);
            Game game = new Game();
            try {
                UI.init(scanner, game);
                while (playing) {
                    try {
                        UI.play(scanner, game);
                        playing = false;
                    } catch (GameException e) {
                        System.out.println(e.getMessage() + "\n");
                    }
                }
                System.out.print("\nDigite \"play\" para jogar: ");
                if (!scanner.nextLine().equals("play")) {
                    playAgain = false;
                } else {
                    System.out.println("\nBora pra mais uma tentativa!\n");
                    playing = true;
                }
            } catch (GameException e) {
                System.out.println(e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas valores válidos!");
            }
        }
    }
}