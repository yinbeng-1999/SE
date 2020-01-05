import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private static String selected_room_number;
	private static ArrayList<String> a1 = new ArrayList<String>();
	private static ArrayList<String[]> a2 = new ArrayList<String[]>();
	int linenumber;
	String tmp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
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
	public Checkout() {
		File room_reservation = new File("C:\\test\\room_reservation.txt");
		
		try {
			if(room_reservation.exists())
			{
				FileReader fr = new FileReader(room_reservation);
				LineNumberReader lnr = new LineNumberReader(fr);
				
				linenumber = 0;
				while(lnr.readLine() != null)
				{
					linenumber++;
				}
				System.out.println(linenumber);
			}
			else
			{
				System.out.println("File does not exist!");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(room_reservation);
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<linenumber;i++)
			{
				try {
					String Line = br.readLine();
					a1.add(Line);
					System.out.println(a1.get(i));
					String [] tmp = Line.split(" ");
					a2.add(tmp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "File is empty.");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"File not exists");
		}
		
		setTitle("取消訂房");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("輸入資料");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		label.setBounds(130, 13, 167, 65);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("房號 :");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label_1.setBounds(27, 90, 75, 42);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("身分證字號 :");
		label_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		label_2.setBounds(27, 151, 145, 34);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		passwordField.setEchoChar('*');
		passwordField.setBounds(153, 149, 262, 36);
		contentPane.add(passwordField);
		
		String[] room_number = {"1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8","1-9","1-10",
				"2-1","2-2","2-3","2-4","2-5","2-6","2-7","2-8","2-9","2-10",
				"3-1","3-2","3-3","3-4","3-5","3-6","3-7","3-8","3-9","3-10"};
		JComboBox comboBox = new JComboBox(room_number);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_number = (String)comboBox.getSelectedItem();
				
			}
		});
		comboBox.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		comboBox.setBounds(98, 91, 91, 41);
		contentPane.add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(51, 153, 204));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String room_number = selected_room_number;
				String id = String.valueOf(passwordField.getPassword());
				
				System.out.println(room_number);
				System.out.println(id);
				System.out.println(linenumber);
				
				boolean judge_equal = true;
				for(int i=0;i<linenumber;i++)
				{
					System.out.println(a2.get(i)[0]);
					if((room_number.equals(a2.get(i)[0])))
					{
						judge_equal = true;
						break;
					}
					else
					{
						judge_equal = false;
					}
				}
				if(judge_equal)
				{
					FileWriter fw;
					try {
						fw = new FileWriter(room_reservation,false);
						fw.write("\n");
						fw.flush();
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int i=0;i<linenumber;i++)
					{
						try {
							if(!(room_number.equals(a2.get(i)[0])))
							{
								FileWriter fw1 = new FileWriter(room_reservation,true);
								fw1.write(a2.get(i)[0] + " " + a2.get(i)[1] + " " + a2.get(i)[2] + " " + a2.get(i)[3] + " " + a2.get(i)[4] + " " + a2.get(i)[5] + "\n");
								fw1.flush();
								fw1.close();
							}
						} catch (IOException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null,"取消成功");
				}
				else
				{
					JOptionPane.showMessageDialog(null,room_number + " 仍是空房");
				}
			}
		});
		btnCancel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnCancel.setBounds(141, 227, 167, 65);
		contentPane.add(btnCancel);
	}
}
