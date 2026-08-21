package TerminalRPG_v1;

import java.util.concurrent.ThreadLocalRandom;

import static TerminalRPG_v1.Database.pokemonFetcher;
import static TerminalRPG_v1.Helpers.mainMenu;
import static TerminalRPG_v1.Helpers.optionChoice;

import java.util.ArrayList;

public class Play {
    public static void play() throws Exception {
        ArrayList<Pokemon> players = new ArrayList<>();
        
        players = pokemonFetcher();
        int pkmn1Hp = players.get(0).hp();
        int pkmn2Hp = players.get(1).hp();

        int choice = 0;
        int damage = 0;

        while (players.get(0).hp != 0 && players.get(1).hp != 0) {
                System.out.printf("""
                                                                                %s
                                                                                Level %d
                                                                                HP: %d/%d



                        """, players.get(0).name(), players.get(0).level(), players.get(0).hp(), pkmn1Hp);

                System.out.printf("""
                        %s
                        Level %d
                        HP: %d/%d

                        1 - Fight   ||   2 - Bag   ||   3 - Run

                        """, players.get(1).name(), players.get(1).level(), players.get(1).hp(), pkmn2Hp);

                choice = optionChoice(1, 4);

                if (choice == 1) {
                        for (int i = 0; i < 4; i++) {
                                System.out.print((i + 1) + " - " + players.get(1).moves().get(i).move() + "  ||  ");
                        }
                        System.out.println("\n");

                        System.out.println("");
                        choice = optionChoice(1, 4);

                        damage = damageCalculation(players.get(1).moves().get(choice - 1), players.get(0));
                        
                }       if (players.get(0).hp - damage <= 0) {
                                players.get(0).hp = 0;
                        } else {
                                players.get(0).hp = players.get(0).hp - damage;
                        }
                        
                        System.out.println(players.get(1).name() + " used " + players.get(1).moves.get(choice - 1).move() + "!");
                        Thread.sleep(750);
                        System.out.println(players.get(1).moves.get(choice - 1).move() + " did " + damage + " damage!\n\n");
                        Thread.sleep(750);


                        if (players.get(0).hp == 0) {
                                break;
                        }
                        
                        choice = ThreadLocalRandom.current().nextInt(1, 5);

                        damage = damageCalculation(players.get(0).moves().get(choice - 1), players.get(1));

                        if (players.get(1).hp - damage <= 0) {
                                players.get(1).hp = 0;
                        } else {
                                players.get(1).hp = players.get(1).hp - damage;
                        }

                        System.out.println(players.get(0).name() + " used " + players.get(0).moves.get(choice - 1).move() + "!");
                        Thread.sleep(750);

                        System.out.println(players.get(0).moves.get(choice - 1).move() + " did " + damage + " damage!\n\n");
                        Thread.sleep(750);

                        if (players.get(1).hp == 0) {
                                break;
                        
                        }
            }

            if (players.get(1).hp == 0) {
                Thread.sleep(750);

                System.out.println(players.get(1).name() + " has fainted!\nYou lost the fight... Better luck next time!\n");
            } else {
                System.out.println(players.get(0).name() + " has fainted!\nYou won the fight!\n");
            }

            try {
                System.out.println("Returning to the main menu in 5 seconds.");
                Thread.sleep(5000);
                mainMenu();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

    public static int damageCalculation(Move move, Pokemon target) {
        int variance = ThreadLocalRandom.current().nextInt(-10, 11);
        int damage = (move.power() / 2) + variance;
        return damage;
    }     
}
