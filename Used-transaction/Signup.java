import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField pw;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton cancel;

	
	public Signup() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		id = new JTextField();
		id.setBounds(106, 41, 257, 36);
		panel.add(id);
		id.setColumns(10);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(106, 102, 257, 36);
		panel.add(pw);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblId.setBounds(50, 39, 29, 36);
		panel.add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblPw.setBounds(50, 100, 29, 36);
		panel.add(lblPw);
		
		JButton signup = new JButton("Sign up");
		signup.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textID = id.getText();
				String textPW = pw.getText();
				String adminID = "admin", adminPW = "1q2w3e4r";
				String[] txtarr;	String txt;
	
				String n = " ";
				String text;
				File file = new File("C:\\info.txt");
				
		            text = textID+n+textPW;
		            FileWriter fw;
					try {
						if(textID.equals(adminID)) {
							System.out.println("get back!");
						}
						else {
							fw = new FileWriter(file, true);
							BufferedWriter bw = new BufferedWriter(fw);
		            
							bw.newLine();
							bw.write(text);
		
		            
							bw.flush();
							bw.close();
							
							System.out.println("Sign up!");
							dispose();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		            
			}
		});
		signup.setBounds(106, 167, 118, 41);
		panel.add(signup);
		
		cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		cancel.setBounds(245, 167, 118, 41);
		panel.add(cancel);
	}
}
