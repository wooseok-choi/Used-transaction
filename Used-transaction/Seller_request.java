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
import java.util.Scanner;

import javax.swing.JButton;

public class Seller_request extends JFrame {

	private JPanel contentPane;
	private JTextField settitle;
	private JLabel lblPrice;
	private JTextField setprice;
	private JButton regist;
	private JTextField userID;
	private JButton back;

	public Seller_request(String id) {
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
		
		settitle = new JTextField();
		settitle.setBounds(87, 22, 263, 24);
		panel.add(settitle);
		settitle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 25, 62, 18);
		panel.add(lblNewLabel);
		
		lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblPrice.setBounds(27, 70, 62, 18);
		panel.add(lblPrice);
		
		setprice = new JTextField();
		setprice.setColumns(10);
		setprice.setBounds(87, 69, 263, 24);
		panel.add(setprice);
		
		regist = new JButton("\uB4F1\uB85D");
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid=id;
				String title = settitle.getText();
				String price = setprice.getText();
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
			          	if(txt.equals("")) {
			          		continue;
			          	}
			          	else if(txtarr[1].equals(title)&&txtarr[2].equals(price)) {
			          		text = id + " " + txtarr[1] + " " + txtarr[2]+ " "+"ÆÇ¸Å";
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
		regist.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		regist.setBounds(87, 126, 127, 38);
		panel.add(regist);
		
		back = new JButton("\uCDE8\uC18C");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		back.setBounds(223, 126, 127, 38);
		panel.add(back);
		
	}
}
