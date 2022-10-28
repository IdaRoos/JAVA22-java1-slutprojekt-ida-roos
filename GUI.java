package Slutprojekt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class GUI {

	static void createAndDisplay() {

		JFrame frame = new JFrame("CALENDER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 500);
		frame.setLayout(new GridLayout());

		for (int i = 0; i < 7; i++) {

			JPanel panel = new JPanel();

			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setBackground(Color.white);
			panel.setBounds(0, 0, 100, 100);

			if (Date.getDate(i).equals(LocalDate.now())) {
				panel.setBackground(Color.red);

			}

			addGroupOfComponents(i, panel);
			frame.add(panel);

		}

		frame.setVisible(true);

	}

	private static void addGroupOfComponents(int x, JPanel panels) {

		JLabel labelWeekDay = new JLabel(Date.getDayOfWeek(x));
		JLabel labelDate = new JLabel(Date.getDate(x).toString());
		labelWeekDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelDate.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel textArea = new JPanel();
		textArea.setBackground(Color.white);
		Border lines = BorderFactory.createLineBorder(Color.gray);
		textArea.setBorder(lines);

		JTextField textfield = new JTextField("Add event", 30);
		textfield.setPreferredSize(new Dimension(10, 50));
		textfield.setMaximumSize(textfield.getPreferredSize());

		JButton button = new JButton("Add");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

		panels.add(labelWeekDay);
		panels.add(labelDate);
		panels.add(textArea);
		panels.add(textfield);
		panels.add(button);

		ActionListener bListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JLabel labelText = new JLabel();
				textArea.add(labelText);
				labelText.setText("<html><p style=\"width:100px\"><br>" + textfield.getText() + "</p></html>");

			}

		};

		button.addActionListener(bListener);

	}

}
