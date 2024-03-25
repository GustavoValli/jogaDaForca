package application;

import entities.Game;
import entities.Human;
import entities.exceptions.GameException;

import java.util.Scanner;

public class UI {

    public static void init(Scanner scanner, Game game) throws NumberFormatException{
        System.out.println("\nSelecione a dificuldade:");
        System.out.println("Fácil(1)  //  Modeerada(2)  //  Difícil(3)");
        System.out.print("-> ");

        String levelDifficulty = scanner.nextLine();

        if (levelDifficulty.length() > 1 || Integer.parseInt(levelDifficulty) < 1
                || Integer.parseInt(levelDifficulty) > 3) {
            throw new GameException("Digite apenas dígitos entre 1 e 3!");
        }

        switch (levelDifficulty) {
            case "1": game.changeDifficulty(new Human(15)); break;
            default: case "2": game.changeDifficulty(new Human(10)); break;
            case "3": game.changeDifficulty(new Human(5)); break;
        }
    }

    public static void play(Scanner scanner, Game game) throws GameException{
        boolean pass = true;
        while (!game.checkGameOver() && pass) {
            System.out.println("\nVida atual: " + game.getHumanLifePoints());

            System.out.println("Letras já escolhidas: ");
            for (char c : game.getPlayerLetters()) {
                System.out.print(c + " / ");
            }

            System.out.println();

            for (int i = 0; i < game.getGameLetters().size(); i++) {
                if (game.getPlayerLetters().contains(game.getGameLetters().get(i))) {
                    System.out.print(game.getGameLetters().get(i));
                } else {
                    System.out.print("_");
                }
            }

            System.out.print("\nDigite uma letra ou chute a palavra: ");
            game.userAnswer(scanner);

            if (game.checkLetter() || game.checkWord()) {
                System.out.println("\n##### Parabéns vc ganhou! A palavra era: " + game.getGameWord() + " #####");
                pass = false;
            }
            if (game.checkGameOver()) {
                System.out.println("\n##### Vc perdeu! A palavra era: " + game.getGameWord() + " #####");
                pass = false;
            }
        }
    }

}
