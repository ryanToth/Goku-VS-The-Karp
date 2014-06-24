/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shooter;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class Shooter {

    public static void main(String[] args) throws IOException {

        Object[] options = {"RESET HIGH SCORE", "START"};
        int choice = 0;
        do {
            choice = JOptionPane.showOptionDialog(null, "Goku VS The Karp", "New Game",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[1]);

            if (choice == 1) {
                JFrame frame = new JFrame("Goku VS The Karp");
                GameBoard game = new GameBoard();
                frame.setSize(1000, 500);
                frame.add(game, BorderLayout.CENTER);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            } else if (choice == 0) {

                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new PrintWriter("highscore/highscore.txt", "UTF-8"));
                    writer.write("0");
                    writer.close();
                }
                catch(Exception ex) {
                    
                }

            } else if (choice != 0 && choice != 1){
                System.exit(0);
            }
        } while (choice == 0);
    }

}
