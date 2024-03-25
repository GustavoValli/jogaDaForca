package entities;

import entities.exceptions.GameException;

import java.util.*;

public class Game {

    private String gameWord;
    private String playerWord;
    private final List<Character> playerLetters = new ArrayList<>();

    private Human human;

    public Game() {
        randomWord(gameWords());
    }

    public void changeDifficulty(Human human) {
        this.human = human;
    }

    private List<String> gameWords() {
        List<String> list = new ArrayList<>();
        list.add("carro");
        list.add("melancia");
        list.add("cartao");
        list.add("banana");
        list.add("abacaxi");
        list.add("cachorro");
        list.add("gato");
        list.add("computador");
        list.add("teclado");
        list.add("mouse");
        list.add("caneta");
        list.add("caderno");
        list.add("livro");
        list.add("celular");
        list.add("fone");
        list.add("mesa");
        list.add("cadeira");
        list.add("copo");
        list.add("prato");
        list.add("garfo");
        list.add("faca");
        list.add("panela");
        list.add("geladeira");
        list.add("televisao");
        list.add("cama");
        list.add("travesseiro");
        list.add("cobertor");
        list.add("janela");
        list.add("porta");
        list.add("tapete");
        list.add("espelho");
        list.add("escova");
        list.add("pente");
        list.add("shampoo");
        list.add("condicionador");
        list.add("sabonete");
        list.add("toalha");
        list.add("pasta");
        list.add("meia");
        list.add("calca");
        list.add("camisa");
        list.add("sapato");
        list.add("chinelo");
        list.add("oculos");
        list.add("relogio");
        list.add("anel");
        list.add("brinco");
        return list;
    }

    private List<Character> wordToLetters(String word) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }
        return list;
    }

    private void randomWord(List<String> words) {
        Collections.shuffle(words);
        gameWord = words.get(0);
    }

    public void userAnswer(Scanner scanner) {

        String word = scanner.nextLine();

        if (hasANumber(word) || word.isBlank() || word.isEmpty()) {
            throw new GameException("Digite apenas letras!");
        }

        char letter = word.charAt(0);

        if (word.length() > 1) {
            playerWord = word;
            if (!playerWord.equals(gameWord)) {
                human.lostLife(human.getLifePoints());
            }
        } else {
            if (!playerLetters.contains(letter)) {
                playerLetters.add(letter);
                if (!getGameLetters().contains(letter)) {
                    HumanLostLife(1);
                }
            }
        }
    }
    private Boolean hasANumber(String s) {
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            return Character.isDigit(c);
        }
        return false;
    }

    public Boolean checkLetter() {
            return new HashSet<>(playerLetters).containsAll(getGameLetters());
    }

    public Boolean checkWord() {
        return playerWord != null && playerWord.equals(gameWord);
    }

    public Boolean checkGameOver() {
        return human.getLifePoints() <= 0;
    }

    public String getGameWord() {
        return gameWord;
    }

    public List<Character> getGameLetters() {
        return wordToLetters(gameWord);
    }

    public List<Character> getPlayerLetters() {
        return playerLetters;
    }

    public Integer getHumanLifePoints() {
        return human.getLifePoints();
    }

    public void HumanLostLife(Integer lifePoints) {
        human.lostLife(lifePoints);
    }
}
