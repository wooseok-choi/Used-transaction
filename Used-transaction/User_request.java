import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class User_request extends JFrame {

	private JPanel contentPane;
	private JTextField title;
	private JLabel lblPrice;
	private JTextField price;
	private JButton regist;
	private JTextField userID;
	private JButton back;

	public User_request(String id) {
		setTitle("\uD310\uB9E4 \uC694\uCCAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		title = new JTextField();
		title.setBounds(87, 22, 263, 24);
		panel.add(title);
		title.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 25, 62, 18);
		panel.add(lblNewLabel);
		
		lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblPrice.setBounds(27, 70, 62, 18);
		panel.add(lblPrice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(87, 69, 263, 24);
		panel.add(price);
		
		regist = new JButton("\uB4F1\uB85D");
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texttitle = title.getText();
				String textprice = price.getText();
				String textuserID = id;
				String state = "¿äÃ»";
				String n = " ";
				//id , ÀÌ¸§ , °¡°Ý , »óÅÂ ¼ø¼­ 
				String text = textuserID+" "+texttitle+" "+textprice+" "+state;
				
				try {
						File file = new File("C:\\sellrequest.txt");
						FileWriter fw;
						fw = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(fw);
	            
						bw.write("\n"+text);
	
	            
						bw.flush();
						bw.close();
						
						System.out.println("Sign up!");
						dispose();
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		regist.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		regist.setBounds(83, 127, 127, 38);
		panel.add(regist);
		
		back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		back.setBounds(222, 127, 127, 38);
		panel.add(back);
		
	}
}
