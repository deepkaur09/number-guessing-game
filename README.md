# Number Guessing Game

Guess the random number in 5 tries.

## About

A desktop game built with Java Swing. The computer picks a random number, and you try to guess it. After each wrong guess you get a hint telling you to go higher or lower. Use up all your tries and the round ends, then you can retry for a fresh number.

## Features

- Menu screen with **Start Game** and **Exit** buttons
- Game screen with a text box, a **Check** button, hints, and a **Retry** button
- Back button to return to the menu
- 5 tries per round, with a win or lose message at the end

## How to Play

1. Click **Start Game**.
2. Type a number from 0 to 100 and click **Check the guess**.
3. Follow the hint to guess higher or lower.
4. Guess it within 5 tries to win. Click **Retry** to play again.

## How to Run

You need the Java Development Kit (JDK) installed.

```
javac GuessNumber.java
java GuessNumber
```

## What I Learned

- Building a GUI with Swing (`JFrame`, `JPanel`, `JButton`, `JLabel`, `JTextField`)
- Switching between screens with `CardLayout`
- Handling button clicks with `ActionListener`
