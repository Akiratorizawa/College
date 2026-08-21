package TerminalRPG_v2.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;

import static TerminalRPG_v2.src.Database.pokemonFetcher;


public class Battle extends JFrame implements KeyListener {
    private Window window;
    private Image background;
    private Image cursor;

    private int dialogueStage = 1;

    private int optionChoice;

    private int[] optionsX = {580, 820, 1000};

    ArrayList<Pokemon> pokemon = new ArrayList<>();
    Pokemon opponent;
    Pokemon player;

    Font pokemonFont;
    Font biggerPokemon;
    Font movePokemon;
    Font smallerPokemon;

    int random;

    boolean opponentTurn = false;
    boolean showResult = false;

    public Battle(Window window) {
        background = new ImageIcon("assets/img/battle.png").getImage();
        
        this.window = window;

        try {
            pokemon = pokemonFetcher();
        } catch (Exception error) {
            error.printStackTrace();
        }

        opponent = pokemon.get(0);
        player = pokemon.get(1);

        int playerMaxHp = player.hp();
        int opponentMaxHp = opponent.hp();

        try {
            pokemonFont = Font.createFont(
                Font.TRUETYPE_FONT,
                new File("assets/ttf/pokemon.otf"));

            biggerPokemon = pokemonFont.deriveFont(Font.PLAIN, 48.0f);
            movePokemon = pokemonFont.deriveFont(Font.PLAIN, 32.0f);
            smallerPokemon = pokemonFont.deriveFont(Font.PLAIN, 26.0f);


        } catch (Exception error) {
            error.printStackTrace();
        }

        window.setContentPane(new JPanel() {
           @Override
           protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // About page background
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

            // Cursor
            cursor = new ImageIcon("assets/img/arrow.png").getImage();
            Image lucario = new ImageIcon("assets/img/lucario.png").getImage();
            Image charizard = new ImageIcon("assets/img/charizard.png").getImage();


            g.setColor(Color.BLACK);

            g.setFont(smallerPokemon);
            
            g.drawString(player.name(), 750, 360);
            g.drawString(String.valueOf(player.level()), 1100, 362);

            g.drawString(opponent.name(), 120, 123);
            g.drawString(String.valueOf(opponent.level()), 480, 127);


            g.drawString(String.valueOf(playerMaxHp), 1100, 430);
            g.drawString(String.valueOf(player.hp), 1000, 430);

            g.drawString(String.valueOf(opponent.hp) + " / " + String.valueOf(opponentMaxHp), 280, 123);

            if (player.hp != 0) {
                g.drawImage(lucario, 325, 250, 220, 220, this);
            }
            
            if (opponent.hp != 0) {
                g.drawImage(charizard, 800, 70, 235, 235, this);
            }


            g.setFont(biggerPokemon);
            g.setColor(Color.WHITE);


            if (dialogueStage == 1) {
                g.drawString("A wild Charizard appeared! Go, Lucario!",100, 600);
            }
            

            if (dialogueStage == 2) {
                if (player.hp <= ((double)playerMaxHp * 0.3)) {
                    window.lowHp();
                }
                g.setFont(biggerPokemon);
                g.drawString("What will you do?", 100, 580);
                g.drawImage(cursor, optionsX[optionChoice], 535, 40, 40, this);
                g.drawString("FIGHT", 650, 580);
                g.drawString("BAG", 870, 580);
                g.drawString("RUN", 1050, 580);
            }

            if (dialogueStage == 3) {
                int coordX = 150;
                int[] cursorPos = {100, 370, 640, 915};
                g.setFont(movePokemon);
                for (int i = 0; i < 4; i++) {
                    g.drawString(player.moves().get(i).move(), coordX, 580);
                    coordX += 270;
                }
                g.drawImage(cursor, cursorPos[optionChoice], 550, 40, 40, this);
                
            }

            if (dialogueStage == 4) {
                Move playerMove = player.moves().get(optionChoice);
                
                g.setFont(biggerPokemon);
                if (!(opponentTurn)) {
                    
                    if (opponent.hp == 0) {
                        if (!(showResult)) {
                            window.attackSound();
                            g.drawString("Lucario used " + playerMove.move() + "!", 100, 600);
                        } else {
                            window.playWinMusic();
                            g.drawString("You won the fight! Returning in 5 seconds...", 100, 600);
                        }
                    } else {
                        window.attackSound();
                        g.drawString("Lucario used " + playerMove.move() + "!", 100, 600);
                    }
                } else {
                    Move opponentMove = opponent.moves().get(random);
                    
                        if (player.hp == 0) {
                            g.drawString("You lost the fight. Returning in 5 seconds...", 100, 600);
                        } else {
                            window.attackSound();
                            g.drawString("Charizard used " + opponentMove.move() + "!", 100, 600);
                        }
                }
            }

           } 
        });

        if (dialogueStage == 1) {
            Timer timer = new Timer(2500, e -> {
                dialogueStage = 2;
                window.repaint();
            });
            
            timer.setRepeats(false);
            timer.start();
        }

        window.revalidate();
        window.repaint();

        window.addKeyListener(this);
        window.setFocusable(true);
        window.requestFocusInWindow();
        
        window.battleMusic();


    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Listening for enter key strokes
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (dialogueStage == 2 || dialogueStage == 3) {
                if (optionChoice - 1 < 0) {
                    optionChoice = 0;
                } else {
                    optionChoice--;
                    window.optionSound();
                }
                
                window.repaint();
            }
      }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (dialogueStage == 2) {
                if (optionChoice + 1 > 2) {
                    optionChoice = 2;
                } else {
                    optionChoice++;
                    window.optionSound();
                }
                
                window.repaint();
            }

            if (dialogueStage == 3) {
                if (optionChoice + 1 > 3) {
                    optionChoice = 3;
                } else {
                    optionChoice++;
                    window.optionSound();
                }
                
                window.repaint();
                
            }

      }
      
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (optionChoice == 0 && dialogueStage == 2) {
                dialogueStage++;
                window.confirmSound();
                window.repaint();
                optionChoice = 0;
            } else if (dialogueStage == 3) {
                window.confirmSound();
                window.repaint();
                dialogueStage++;
            }

            if (dialogueStage == 4) {
                if (player.hp == 0 || opponent.hp == 0) {
                    window.removeKeyListener(this);
                    Timer lastMoveTimer = new Timer(2500, er1 -> {
                        showResult = true;
                        window.confirmSound();

                        window.repaint();

                        Timer backMenu = new Timer(5000, er -> {
                                window.showMainMenu();
                            });
                            
                        backMenu.setRepeats(false);
                        backMenu.start();

                    });

                    lastMoveTimer.setRepeats(false);
                    lastMoveTimer.start();

                } else {
                    Move playerMove = player.moves().get(optionChoice);
                    opponent.hp -= damageCalculation(playerMove, opponent);
                    
                    if (opponent.hp < 0) {
                        opponent.hp = 0;
                    }
                
                    window.repaint();

                    Timer timer = new Timer (2500, er -> {
                        if (opponent.hp == 0) {
                            window.removeKeyListener(this);
                            showResult = true;
                            window.repaint();

                            Timer returnTimer = new Timer(5000, er2 -> {
                                window.showMainMenu();
                            });

                            returnTimer.setRepeats(false);
                            returnTimer.start();

                            return;
                        } 

                        opponentTurn = true;
                        random = ThreadLocalRandom.current().nextInt(0, 4);

                        Move opponentMove = opponent.moves().get(random);
                        player.hp -= damageCalculation(opponentMove, player);

                        if (player.hp < 0) {
                            player.hp = 0;
                        }

                        window.repaint();

                        if (player.hp == 0) {
                            window.removeKeyListener(this);
                            showResult = true;

                            Timer returnTimer = new Timer(5000, er2 -> {
                                window.showMainMenu();
                            });

                            returnTimer.setRepeats(false);
                            returnTimer.start();
                            return;
                        }

                        Timer backToFight= new Timer(2500, er2 -> {
                        dialogueStage = 2;
                        optionChoice = 0;
                        opponentTurn = false;
                        window.repaint();
                    });
                        backToFight.setRepeats(false);
                        backToFight.start();
                    });
                    
                    timer.setRepeats(false);
                    timer.start();   
                    }

                }
                
        }

        }
    

  @Override
      public void keyReleased(KeyEvent e) {
      }

  @Override
      public void keyTyped(KeyEvent e) {
      }

    public static int damageCalculation(Move move, Pokemon target) {
        int variance = ThreadLocalRandom.current().nextInt(-10, 11);
        int damage = (move.power() / 2) + variance;
        return damage;
    }   
}
