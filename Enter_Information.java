import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class Enter_Information extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter_Information frame = new Enter_Information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Enter_Information() {
		File room_reservation = new File("C:\\test\\room_reservation.txt");
		
		setTitle("Enter Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名稱 :");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 91, 75, 42);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevent) {
				if(keyevent.getKeyCode() == KeyEvent.VK_TAB)
				{
					if(keyevent.getModifiers() > 0)
						textArea.transferFocusBackward();
					else
						textArea.transferFocus();
					keyevent.consume();
				}
			}
		});
		textArea.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		textArea.setBounds(92, 99, 262, 34);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("身分證字號 :");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label.setBounds(24, 148, 145, 34);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevent) {
				if(keyevent.getKeyCode() == KeyEvent.VK_TAB)
				{
					if(keyevent.getModifiers() > 0)
						passwordField.transferFocusBackward();
					else
						passwordField.transferFocus();
					keyevent.consume();
				}
			}
		});
		passwordField.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		passwordField.setEchoChar('*');
		passwordField.setBounds(148, 146, 262, 36);
		contentPane.add(passwordField);
		
		JLabel label_1 = new JLabel("聯絡方式 :");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label_1.setBounds(24, 198, 130, 34);
		contentPane.add(label_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevent) {
				if(keyevent.getKeyCode() == KeyEvent.VK_TAB)
				{
					if(keyevent.getModifiers() > 0)
						textArea_2.transferFocusBackward();
					else
						textArea_2.transferFocus();
					keyevent.consume();
				}
			}
		});
		textArea_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		textArea_2.setBounds(130, 198, 262, 34);
		contentPane.add(textArea_2);
		
		JLabel label_2 = new JLabel("訂房資料");
		label_2.setForeground(new Color(153, 0, 0));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		label_2.setBounds(187, 13, 167, 65);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("退房日期 :");
		label_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label_3.setBounds(24, 292, 117, 34);
		contentPane.add(label_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(130, 249, 262, 34);
		contentPane.add(dateChooser);
		
		JLabel label_4 = new JLabel("入住日期 :");
		label_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label_4.setBounds(24, 247, 117, 34);
		contentPane.add(label_4);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(130, 292, 262, 34);
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("確認訂房");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String room_number = Booking.a3.get(Booking.a3.size()-1);
				String name = textArea.getText();
				String id = String.valueOf(passwordField.getPassword());
				String phone = textArea_2.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String checkin = sdf.format(dateChooser.getDate());
				String checkout = sdf.format(dateChooser_1.getDate());
				if(!(name.equals("")) && !(id.equals("")) && !(phone.equals("")) && !(checkin.equals("")) && !(checkout.equals("")))
				{
					try {
						FileWriter fw = new FileWriter(room_reservation,true);
						fw.write(room_number + " " + name + " " + id + " " + phone + " " + checkin + " " + checkout + "\n");
						fw.flush();
						fw.close();
						JOptionPane.showMessageDialog(null,"訂房成功");
						dispose();
						//System.out.println(Booking.a4.size());
					} catch (IOException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"尚未輸入完整資料");
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 153, 204));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton.setBounds(193, 360, 161, 44);
		contentPane.add(btnNewButton);
		
		
	}
}
