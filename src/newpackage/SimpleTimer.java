package newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTimer extends JFrame implements ActionListener {
    private javax.swing.Timer timer; // Menggunakan javax.swing.Timer untuk timer kita
    private JLabel timeLabel;
    private JButton startStopButton, resetButton;
    private int seconds;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Inisialisasi timer
        timer = new javax.swing.Timer(1000, this); // Menggunakan javax.swing.Timer

        // Komponen-komponen GUI
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        startStopButton = new JButton("Start");
        startStopButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        // Membuat panel
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Menambahkan komponen-komponen ke panel
        buttonPanel.add(startStopButton);
        buttonPanel.add(resetButton);
        panel.add(timeLabel);
        panel.add(buttonPanel);

        // Menambahkan panel ke frame
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startStopButton) {
            if (!timer.isRunning()) {
                startStopButton.setText("Stop");
                timer.start();
            } else {
                startStopButton.setText("Start");
                timer.stop();
            }
        } else if (e.getSource() == resetButton) {
            timer.stop();
            startStopButton.setText("Start");
            seconds = 0;
            updateTimeLabel();
        } else if (e.getSource() == timer) {
            seconds++;
            updateTimeLabel();
        }
    }

    private void updateTimeLabel() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, secs));
    }

    public static void main(String[] args) {
        new SimpleTimer();
    }
}
