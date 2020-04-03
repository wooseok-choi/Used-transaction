import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField pw;

	/**
	 * Launch the application.
	 * @return 
	 */
	public String UserId;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel.setBounds(52, 63, 34, 24);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblPw.setBounds(52, 99, 34, 24);
		panel.add(lblPw);
		
		id = new JTextField();
		id.setBounds(117, 65, 226, 24);
		panel.add(id);
		id.setColumns(10);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(117, 101, 226, 24);
		panel.add(pw);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textID = id.getText();
				String textPW = pw.getText();
				
				System.out.println(textID + " " + textPW);
				String[] txtarr;	String txt;
				String adminID = "admin";
				String adminPW = "1q2w3e4r";

				try {
					File file = new File("C:\\info.txt");
					  Scanner scan = new Scanner(file);
			            while(scan.hasNextLine()){
			            	
			            	txt = scan.nextLine();
			            	txtarr = txt.split(" ");
			            	
			            	if(textID.equals(txtarr[0]) && textPW.equals(txtarr[1])) {
			            		UCmain ucmain = new UCmain(textID);
			            		ucmain.setVisible(true);
			            		dispose();
			            		break;
			            	}
			            	else if(textID.equals(adminID) && textPW.equals(adminPW)){
			            		Sellermain sellermain = new Sellermain(textID);
			            		sellermain.setVisible(true);
			            		dispose();
			            		break;
			            	}
			            }
			            

				}catch(IOException e1) {}
			}
			
		});
		login.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		login.setBounds(238, 157, 105, 40);
		panel.add(login);
		
		JButton Signup = new JButton("Sign up");
		Signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Signup signup = new Signup();
				signup.setVisible(true);
			}
		});
		Signup.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		Signup.setBounds(119, 157, 105, 40);
		panel.add(Signup);
	}

}
