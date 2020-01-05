import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;

public class Booking extends JFrame {

	private JPanel contentPane;
	public static ArrayList<String[]> a1 = new ArrayList<String[]>();
	public static ArrayList<String> a2 = new ArrayList<String>();
	public static ArrayList<String> a3 = new ArrayList<String>();
	public static ArrayList<String[]> a4 = new ArrayList<String[]>();
	public static ArrayList<String> a5 = new ArrayList<String>();
	public static ArrayList<String> a6 = new ArrayList<String>();
	public static String selected_room_number;
	public static String selected_room_type;
	public static String selected_room_smoke;
	public static String selected_room_scenery;
	public static String selected_room_quality;
	public static String selected_room_price;
	public static int linenumber;
	public static String tmp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		File room = new File("C:\\test\\room.txt");
		try {
			FileReader fr = new FileReader(room);
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<30;i++)
			{
				try {
					String Line = br.readLine();
					a2.add(Line);
					String[] tmp = Line.split(" ");
					a1.add(tmp);
					model.addElement(Line);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "File is empty.");
				}
			}
		} catch (FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "File is not exist.");
		}

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
		a4.clear();
		try {
			FileReader fr = new FileReader(room_reservation);
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<linenumber;i++)
			{
				try {
					String Line = br.readLine();
					a5.add(Line);
					System.out.println(a5.get(i));
					String [] tmp = Line.split(" ");
					a4.add(tmp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "File is empty.");
				}
			}
		} catch (FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "File is not exist.");
		}
		
		setTitle("訂房");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 625);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 153, 204));
		btnNewButton.setBounds(509, 527, 117, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String room_number = selected_room_number;
				System.out.println(room_number);
				boolean judge_equal = false;
				
				for(int i=0;i<linenumber;i++)
				{
					if((room_number.equals(a4.get(i)[0])))
					{
						tmp = a4.get(i)[0];
						judge_equal = false;
						break;
					}
					else
					{
						judge_equal = true;
					}
				}
				for(int i=0;i<linenumber;i++)
				{
					System.out.println(a4.get(i)[0]);
				}
				if(judge_equal)
				{
					JOptionPane.showMessageDialog(null,"輸入資料");
					dispose();
					Enter_Information enter_information = new Enter_Information();
					enter_information.setVisible(true);
					//break;
					//System.out.println(a3.size());
					//System.out.println(a4.size());
					//System.out.println(room_number);
				}
				else
				{
					JOptionPane.showMessageDialog(null,tmp + " 已被預約");
					//break;
				}
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 24));
		contentPane.add(btnNewButton);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(14, 203, 612, 311);
		scrollpane.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(scrollpane);
		
		JList list = new JList(model);
		scrollpane.setViewportView(list);
		list.setFont(new Font("微軟正黑體", Font.BOLD, 18));

		String[] room_number = {"1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8","1-9","1-10",
								"2-1","2-2","2-3","2-4","2-5","2-6","2-7","2-8","2-9","2-10",
								"3-1","3-2","3-3","3-4","3-5","3-6","3-7","3-8","3-9","3-10"};     // comboBox 的資料
		JComboBox comboBox = new JComboBox(room_number);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_number = (String)comboBox.getSelectedItem();
				a3.add(selected_room_number);
			}
		});
		comboBox.setBounds(14, 526, 91, 41);
		comboBox.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("1.房型 : ");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		lblNewLabel.setBounds(14, 23, 80, 29);
		contentPane.add(lblNewLabel);
		
		String [] room_type = {"Single","Double","Shared"};
		JComboBox comboBox_1 = new JComboBox(room_type);
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(93, 13, 215, 48);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_type = (String)comboBox.getSelectedItem();
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					if(selected_room_type.equals(a1.get(i)[1]))
					{
						model.addElement(a1.get(i)[0] + " " + a1.get(i)[1] + " " + a1.get(i)[2] + " " + a1.get(i)[3] + " " + a1.get(i)[4]);
					}
				}
			}
		});
		comboBox_1.setEditable(false);
		comboBox_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		contentPane.add(comboBox_1);
		
		JLabel label = new JLabel("2.吸菸 : ");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		label.setBounds(322, 23, 80, 29);
		contentPane.add(label);
		
		String [] room_smoke = {"smoke","no-smoke"};
		JComboBox comboBox_2 = new JComboBox(room_smoke);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_smoke = (String)comboBox.getSelectedItem();
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					if(selected_room_type.equals(a1.get(i)[1]) && selected_room_smoke.equals(a1.get(i)[2]))
					{
						model.addElement(a1.get(i)[0] + " " + a1.get(i)[1] + " " 
					+ a1.get(i)[2] + " " + a1.get(i)[3] + " " + a1.get(i)[4] + " " + a1.get(i)[5]);
					}
				}
			}
		});
		comboBox_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		comboBox_2.setEditable(false);
		comboBox_2.setBounds(411, 13, 215, 48);
		contentPane.add(comboBox_2);
		
		JLabel label_1 = new JLabel("3.風景 : ");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		label_1.setBounds(14, 84, 91, 29);
		contentPane.add(label_1);
		
		String [] room_scenery = {"scenery","no-scenery"};
		JComboBox comboBox_3 = new JComboBox(room_scenery);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_scenery = (String)comboBox.getSelectedItem();
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					if(selected_room_type.equals(a1.get(i)[1]) && selected_room_smoke.equals(a1.get(i)[2]) 
							&& selected_room_scenery.equals(a1.get(i)[3]))
					{
						model.addElement(a1.get(i)[0] + " " + a1.get(i)[1] + " " 
					+ a1.get(i)[2] + " " + a1.get(i)[3] + " " + a1.get(i)[4] + " " + a1.get(i)[5]);
					}
				}
			}
		});
		comboBox_3.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		comboBox_3.setEditable(false);
		comboBox_3.setBounds(93, 74, 215, 48);
		contentPane.add(comboBox_3);
		
		JLabel label_2 = new JLabel("4.星級 : ");
		label_2.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		label_2.setBounds(322, 84, 75, 29);
		contentPane.add(label_2);
		
		String [] room_quality = {"1","2","3","4","5"};
		JComboBox comboBox_4 = new JComboBox(room_quality);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_quality = (String)comboBox.getSelectedItem();
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					if(selected_room_type.equals(a1.get(i)[1]) && selected_room_smoke.equals(a1.get(i)[2]) && 
							selected_room_scenery.equals(a1.get(i)[3]) && selected_room_quality.equals(a1.get(i)[4]))
					{
						model.addElement(a1.get(i)[0] + " " + a1.get(i)[1] + " " 
					+ a1.get(i)[2] + " " + a1.get(i)[3] + " " + a1.get(i)[4] + " " + a1.get(i)[5]);
					}
				}
			}
		});
		comboBox_4.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		comboBox_4.setEditable(false);
		comboBox_4.setBounds(411, 74, 215, 48);
		contentPane.add(comboBox_4);
		
		JButton button = new JButton("重新篩選");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(51, 204, 102));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					model.addElement(a2.get(i));
				}
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		button.setBounds(492, 135, 134, 40);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("5.價格 : ");
		label_3.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		label_3.setBounds(14, 141, 75, 29);
		contentPane.add(label_3);
		
		String [] room_price = {"2000","3000","4000","5000","6000","7000","8000","9000","10000","11000","12000"};
		JComboBox comboBox_5 = new JComboBox(room_price);
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				selected_room_price = (String)comboBox.getSelectedItem();
				model.removeAllElements();
				for(int i=0;i<30;i++)
				{
					if(selected_room_type.equals(a1.get(i)[1]) && selected_room_smoke.equals(a1.get(i)[2]) 
							&& selected_room_scenery.equals(a1.get(i)[3]) && selected_room_quality.equals(a1.get(i)[4])
							&& selected_room_price.equals(a1.get(i)[5]))
					{
						model.addElement(a1.get(i)[0] + " " + a1.get(i)[1] + " " + a1.get(i)[2] 
								+ " " + a1.get(i)[3] + " " + a1.get(i)[4] + " " + a1.get(i)[5]);
					}
				}
			}
		});
		comboBox_5.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		comboBox_5.setEditable(false);
		comboBox_5.setBounds(93, 131, 215, 48);
		contentPane.add(comboBox_5);
		
		JButton btnBookedRoom = new JButton("Booked room");
		btnBookedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File room_reservation = new File("C:\\test\\room_reservation.txt");
					FileReader fr = new FileReader(room_reservation);
					BufferedReader br = new BufferedReader(fr);
					for(int i=0;i<linenumber;i++)
					{
						try {
							String Line = br.readLine();
							a6.add(Line);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "File is empty.");
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				model.removeAllElements();
				for(int i=0;i<linenumber;i++)
				{
					model.addElement(a6.get(i));
				}
			}
		});
		btnBookedRoom.setForeground(Color.WHITE);
		btnBookedRoom.setFont(new Font("Arial Black", Font.BOLD, 24));
		btnBookedRoom.setBackground(new Color(51, 204, 102));
		btnBookedRoom.setBounds(119, 527, 234, 40);
		contentPane.add(btnBookedRoom);
	}
}
