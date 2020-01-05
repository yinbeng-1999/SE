import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("首頁");
		frame.setBounds(100, 100, 589, 219);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button_1 = new JButton("訂房");
		button_1.setBackground(new Color(51, 153, 204));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.dispose();
				Booking booking = new Booking();
				booking.setVisible(true);
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		button_1.setBounds(31, 86, 158, 66);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("取消訂房");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(51, 153, 204));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				Checkout checkout = new Checkout();
				checkout.setVisible(true);
			}
		});
		button_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		button_2.setBounds(218, 86, 158, 66);
		frame.getContentPane().add(button_2);
		
		JButton button = new JButton("已預約房間");
		button.setBackground(new Color(51, 153, 204));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				roomsearch rs = new roomsearch();
				rs.setVisible(true);
				
				
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.setBounds(399, 86, 158, 66);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("5星級");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 13, 103, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("高師大");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 153, 204));
		label.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		label.setBounds(159, 13, 108, 60);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("飯店");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(204, 51, 0));
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		label_1.setBounds(328, 13, 103, 60);
		frame.getContentPane().add(label_1);
		

	}
}
