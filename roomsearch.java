import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Font;
import java.awt.ScrollPane;

public class roomsearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roomsearch frame = new roomsearch();
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
	public roomsearch() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		setTitle("已預約房間");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 758, 256);
		contentPane.add(scrollPane);
		
		JList list = new JList(model);
		scrollPane.setViewportView(list);
		list.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		model.removeAllElements();
		for(int i=0;i<Booking.linenumber;i++)
		{
			model.addElement(Booking.a5.get(i));
		}
	}
}
