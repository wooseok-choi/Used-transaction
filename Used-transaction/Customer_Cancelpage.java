import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Customer_Cancelpage extends JFrame {

	private JPanel contentPane;
	private JTextField setTitle;
	private JTextField setPrice;


	public Customer_Cancelpage(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 368);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton submit = new JButton("\uD655\uC778");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid=id;
				String title = setTitle.getText();
				String price = setPrice.getText();
				System.out.println("name = "+userid);
				String[] txtarr;	String txt;
				String text;
				String dump="";
				System.out.println("ok");
				try {
					File file = new File("C:\\sellrequest.txt");
					Scanner scan = new Scanner(file);
					FileWriter fw;
					fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					int i=0;
			        while(scan.hasNextLine()){
			        	txt = scan.nextLine();
			          	txtarr = txt.split(" ");
			          	if(txtarr[0].equals(userid)&&txtarr[1].equals(title)&&txtarr[2].equals(price)) {
			          		text = "admin" + " " + txtarr[1] + " " + txtarr[2]+ " "+"ÆÇ¸Å";
			          		dump +=(text+"\r\n");
			          	}
			          	else {
			          		dump +=(txt+"\r\n");
			          	}   	 
			        }
			        fw = new FileWriter(file);
			        fw.write(dump);
			        
					fw.flush();
					fw.close();
			        scan.close();
			        dispose();
				}catch(IOException e1) {}
				
				
			}
		});
		submit.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		submit.setBounds(52, 221, 147, 59);
		panel.add(submit);
		
		JButton back = new JButton("\uCDE8\uC18C");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		back.setBounds(226, 221, 147, 59);
		panel.add(back);
		
		setTitle = new JTextField();
		setTitle.setBounds(109, 47, 221, 41);
		panel.add(setTitle);
		setTitle.setColumns(10);
		
		setPrice = new JTextField();
		setPrice.setColumns(10);
		setPrice.setBounds(109, 112, 221, 41);
		panel.add(setPrice);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lblNewLabel.setBounds(52, 45, 31, 41);
		panel.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lblPrice.setBounds(52, 110, 43, 41);
		panel.add(lblPrice);
	}
}
