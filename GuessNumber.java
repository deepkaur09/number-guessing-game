import java.util.Random;
import java.awt.CardLayout;
import java.awt.event.*;
import javax.swing.*;

public class GuessNumber{
    CardLayout layout = new CardLayout();
    JPanel mainPanel = new JPanel(layout);
    JFrame frame = new JFrame();
    JPanel menuPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JTextField text;
    JButton check;
    JLabel label;
    JLabel result;
    
    Random random = new Random();
    int correctNum = random.nextInt(101);
    int guessedNum;
    int tries = 0;
    boolean matched = false;
    int maxTries = 5;
    

    GuessNumber(){
        //method calls 
        buildMenuPanel();
        buildGamePanel();

        //adding panels 'menu' and 'game' to the main panel
        mainPanel.add(menuPanel, "menu");
        mainPanel.add(gamePanel, "game");

        frame.add(mainPanel);

        frame.setVisible(true);
        frame.setSize(500, 500);

    }


    //method for layout of 'Menu Panel'
    public void buildMenuPanel(){
        JButton start = new JButton("Start Game");
        JButton exit = new JButton("Exit");
        start.setBounds(200, 100, 200, 100);
        exit.setBounds(200, 300, 200, 100);
        menuPanel.add(start);
        menuPanel.add(exit);
        menuPanel.setLayout(null);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                layout.show(mainPanel, "game");
            }
            
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            
        });

    }

    //method for layout of 'Game Panel'
    public void buildGamePanel(){
        text = new JTextField();
        check = new JButton("Check the guess");
        label = new JLabel();
        result = new JLabel();
        JButton back = new JButton("<=");
        JButton retry = new JButton("Retry");

        text.setBounds(200, 100, 200, 50);
        check.setBounds(200, 200, 200, 50);
        label.setBounds(200, 300, 200, 50);
        result.setBounds(150, 350, 250, 50);
        back.setBounds(50, 50, 50, 50);
        retry.setBounds(250, 420, 100, 50);

        gamePanel.add(text);
        gamePanel.add(check);
        gamePanel.add(label);
        gamePanel.add(result);
        gamePanel.add(back);
        gamePanel.add(retry);
        gamePanel.setLayout(null);

        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                guessedNum = Integer.parseInt(text.getText());
                tries++;
                if (guessedNum == correctNum){
                    matched = true;
                }
                else if(guessedNum < correctNum && maxTries > tries){
                    label.setText("Guess a bigger number: ");
                }
                else if(guessedNum > correctNum && maxTries > tries){
                     label.setText("Guess a smaller number: ");
                }

                if(!matched && tries == maxTries){
                    result.setText("Try again?");
                    check.setEnabled(false);
                }
                else if(matched){
                    result.setText("You took " + tries + " tries to guess the right number!");
                    check.setEnabled(false);
                }
            }  
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                layout.show(mainPanel, "menu");
            }
            
        });

        retry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                resetGame();
            }
        });

    }

    public void resetGame(){
        correctNum = random.nextInt(101);
        tries = 0;
        matched = false;   
        check.setEnabled(true);
        text.setText("");
        label.setText("");
        result.setText("");
    }


    public static void main(String[] args) {
        new GuessNumber();
    }

}
