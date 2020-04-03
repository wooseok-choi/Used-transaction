import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Customer_status extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton cancel;
	private JScrollPane scrollPane;
	private JButton refresh;
	private JButton back;


	public Customer_status(String id) {
		setTitle("\uAD6C\uB9E4 \uD604\uD669");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 647, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String header[] = {"ID","중고품","가격","상태"};
		String[][] contents = new String[1000][4];
		
		for(int i=0; i<1000; i++) {	//배열 초기화
			for(int j=0; j<4; j++) {
				contents[i][j]=" ";
			}
		}
		
		String userid=id;
		
		System.out.println("name = "+userid);
		String[] txtarr;	String txt;
		
		System.out.println("ok");
		try {
			File file = new File("C:\\sellrequest.txt");
			Scanner scan = new Scanner(file);

			int i=0;
	        while(scan.hasNextLine()){
	        	txt = scan.nextLine();
	          	txtarr = txt.split(" ");

	        
	        	if(txt.equals("")) {
	          		continue;
	          	}
	        	else if(txtarr[0].equals(userid)&&txtarr[3].equals("구매중")) {
	          	  	for(int k=0; k<4; k++) {
		          		System.out.print(txtarr[k]+" ");
		          	}
		          	System.out.println();
	          		for(int k=0; k<4; k++) {
	          			contents[i][k]=txtarr[k];
	          		}
	            	
	          		i++; 
	          	}
	          	 
	        }
	        
	        scan.close();

		}catch(IOException e1) {}
		
		
		table = new JTable(contents, header);
		table.setBounds(25, 29, 402, 379);
		panel.add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 29, 403, 379);
		panel.add(scrollPane);
		
		cancel = new JButton("\uAD6C\uB9E4 \uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer_Cancelpage cc = new Customer_Cancelpage(id);
				cc.setVisible(true);
			}
		});
		cancel.setFont(new Font("굴림", Font.PLAIN, 20));
		cancel.setBounds(453, 29, 165, 57);
		panel.add(cancel);
		
		refresh = new JButton("\uC0C8\uB85C \uACE0\uCE68");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_status refresh = new Customer_status(id);
				refresh.setVisible(true);
				dispose();
			}
		});
		refresh.setFont(new Font("굴림", Font.PLAIN, 20));
		refresh.setBounds(453, 178, 165, 57);
		panel.add(refresh);
		
		back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("굴림", Font.PLAIN, 20));
		back.setBounds(453, 100, 165, 57);
		panel.add(back);
		
		
	}

}
