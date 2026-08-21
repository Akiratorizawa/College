package TerminalRPG_v1;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static ArrayList<Pokemon> pokemonFetcher() throws Exception {
        // Force the driver to register
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:TerminalRPG/pokemon.db");
        String sql = "SELECT * FROM pokemon";

        String name = "";
        int level = 0;
        int hp = 0;

        ArrayList<Pokemon> pokemon = new ArrayList<>();

        try (Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sql)) {
                while (rs.next()) {

                    name = rs.getString("name");
                    level = rs.getInt("level");
                    hp = rs.getInt("hp");

                    ArrayList<String> moveNames = new ArrayList<>(); 
                    ArrayList<Move> moves = new ArrayList<>();
                    
                    for (int i = 1; i <= 4; i++) {
                        moveNames.add((rs.getString("move" + i)));
                    }

                    for (int i = 0; i < 4; i++) {
                        String moveName = moveNames.get(i);
                        Move move = moveFetcher(moveName);
                        moves.add(move);
                    
                    }

                    Pokemon pkmn = new Pokemon(name, level, hp, moves);
                    pokemon.add(pkmn);
                }
            }

        conn.close();
        return pokemon;
    }

    public static Move moveFetcher(String moveName) {
        Connection conn = null;

        try {
            Connection temp = DriverManager.getConnection("jdbc:sqlite:TerminalRPG/pokemon.db");
            conn = temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT power, pp, accuracy FROM moves WHERE name = \"" + moveName + "\"" ;

        int power = 0;
        int pp = 0;
        double accuracy = 0;
        try (Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sql)) {
                while (rs.next()) {
                    power = rs.getInt("power");
                    pp = rs.getInt("pp");
                    accuracy = rs.getDouble("accuracy");
                }
            }
        catch (SQLException e) {
            throw new IllegalArgumentException("Database error.");
        }

        Move move = new Move(moveName, power, pp, accuracy);
        return move;

    }
}
