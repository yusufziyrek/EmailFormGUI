import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainClass {

	static JTextField toField;
	static JTextField subjectField;
	static JTextArea messageArea;

	public static void main(String[] args) {

		showForm();

	}

	public static void showForm() {

		// Form ile ilgili tüm ayarlamalar

		JFrame frame = new JFrame("Email Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xc79ff5));

		JPanel panel = new JPanel();
		panel.setBounds(95, 30, 400, 600);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));

		JLabel formLabel = new JLabel();
		formLabel.setText("Email Form");
		formLabel.setBounds(120, 70, 150, 30);
		formLabel.setFont(new Font("Consolas", Font.BOLD, 26));
		formLabel.setForeground(Color.black);

		JLabel to = new JLabel("To");
		to.setBounds(20, 150, 50, 15);
		to.setFont(new Font("Consolas", Font.BOLD, 16));
		to.setForeground(Color.black);

		toField = new JTextField();
		toField.setBounds(20, 170, 220, 30);
		toField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		toField.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel subject = new JLabel("Subject");
		subject.setBounds(20, 230, 80, 15);
		subject.setFont(new Font("Consolas", Font.BOLD, 16));
		subject.setForeground(Color.black);

		subjectField = new JTextField();
		subjectField.setBounds(20, 250, 220, 30);
		subjectField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		subjectField.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel message = new JLabel("Message");
		message.setBounds(20, 310, 80, 15);
		message.setFont(new Font("Consolas", Font.BOLD, 16));
		message.setForeground(Color.black);

		messageArea = new JTextArea();
		messageArea.setBounds(20, 330, 358, 150);
		messageArea.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		messageArea.setFont(new Font("Arial", Font.PLAIN, 15));
		messageArea.setForeground(Color.black);

		JButton button = new JButton("Send");
		button.setBounds(125, 510, 150, 50);
		button.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		button.setForeground(Color.black);
		button.setBackground(new Color(0xc79ff5));
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sendMail();

			}
		});

		panel.add(formLabel);
		panel.add(subject);
		panel.add(to);
		panel.add(message);
		panel.add(toField);
		panel.add(subjectField);
		panel.add(messageArea);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);

	}

	public static void sendMail() {

		String to = toField.getText();
		String subject = subjectField.getText();
		String message = messageArea.getText();

		// Email'i text dosyasına kaydediyorum

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("email.txt", true))) {

			writer.write("To: " + to + "\n");
			writer.write("Subject: " + subject + "\n");
			writer.write("Message: \n" + message + "\n");
			writer.write("------------------------ \n");
			writer.close();

		} catch (IOException e) {

			System.out.println("Hata : " + e.getMessage());
		}

	}

}
