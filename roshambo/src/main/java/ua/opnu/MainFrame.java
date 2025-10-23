package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    private final JButton btnRock;
    private final JButton btnPaper;
    private final JButton btnScissors;
    private final JLabel lblPlayer;
    private final JLabel lblComputer;
    private final JLabel lblResult;
    private final Random random;

    public MainFrame() {
        setTitle("Гра \"Камінь-Ножиці-Папір\"");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        random = new Random();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnRock = new JButton("Камінь");
        btnPaper = new JButton("Папір");
        btnScissors = new JButton("Ножиці");

        btnRock.addActionListener(this);
        btnPaper.addActionListener(this);
        btnScissors.addActionListener(this);

        buttonPanel.add(btnRock);
        buttonPanel.add(btnPaper);
        buttonPanel.add(btnScissors);

        JPanel resultPanel = new JPanel(new GridLayout(3, 1));
        lblPlayer = new JLabel("Гравець: (очікування)");
        lblComputer = new JLabel("Комп'ютер: (очікування)");
        lblResult = new JLabel("Результат: Зробіть ваш хід!");

        lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setFont(new Font("Serif", Font.BOLD, 16));

        resultPanel.add(lblPlayer);
        resultPanel.add(lblComputer);
        resultPanel.add(lblResult);

        add(new JLabel("Оберіть вашу фігуру:", SwingConstants.CENTER), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private GameShape generateShape() {
        int choice = random.nextInt(3);

        switch (choice) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
            default:
                return new Scissors();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape playerShape = null;
        Object source = e.getSource();

        if (source == btnRock) {
            playerShape = new Rock();
        } else if (source == btnPaper) {
            playerShape = new Paper();
        } else if (source == btnScissors) {
            playerShape = new Scissors();
        }

        GameShape computerShape = generateShape();

        int result = checkWinner(computerShape, playerShape);

        lblPlayer.setText("Гравець: " + playerShape.toString());
        lblComputer.setText("Комп'ютер: " + computerShape.toString());

        switch (result) {
            case 1:
                lblResult.setText("Результат: Ви виграли!");
                lblResult.setForeground(Color.GREEN);
                break;
            case -1:
                lblResult.setText("Результат: Комп'ютер виграв!");
                lblResult.setForeground(Color.RED);
                break;
            case 0:
                lblResult.setText("Результат: Нічия!");
                lblResult.setForeground(Color.BLUE);
                break;
        }
    }

    private int checkWinner(GameShape comp, GameShape player) {

        if ((comp instanceof Rock && player instanceof Rock) ||
                (comp instanceof Paper && player instanceof Paper) ||
                (comp instanceof Scissors && player instanceof Scissors)) {
            return 0;
        }

        if ((player instanceof Rock && comp instanceof Scissors) ||
                (player instanceof Paper && comp instanceof Rock) ||
                (player instanceof Scissors && comp instanceof Paper)) {
            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}