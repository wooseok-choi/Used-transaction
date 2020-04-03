import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class UCmain extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public UCmain(String id) {
	setTitle("\uBA54\uC778 \uD654\uBA74");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		String header[] = {"¡ﬂ∞Ì«∞","∞°∞›","ªÛ≈¬"};
		String[][] contents = new String[1000][3];
		
		for(int i=0; i<1000; i++) {	//πËø≠ √ ±‚»≠
			for(int j=0; j<3; j++) {
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
	          	else if(txtarr[3].equals("∆«∏≈")) {
		          	System.out.println(txtarr[0]+" "+txtarr[1]+" "+txtarr[2]+" "+txtarr[3]);

	          		for(int k=1; k<4; k++) 
		          		contents[i][k-1]=txtarr[k];
	          		i++;
	          	}
	          	
	       }
	        
	        scan.close();

		}catch(IOException e1) {}
		
		table = new JTable(contents, header);
		table.setBounds(14, 23, 432, 379);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 23, 432, 379);
		panel.add(scrollPane);
		
		JButton sellrequest = new JButton("\uD310\uB9E4 \uC694\uCCAD");
		sellrequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_request userRequest = new User_request(id);
				userRequest.setVisible(true);
			}
		});
		sellrequest.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		sellrequest.setBounds(472, 25, 180, 41);
		panel.add(sellrequest);
		
		JButton myPageSearch = new JButton("\uC791\uC131\uAE00 \uC870\uD68C");
		myPageSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_status status = new User_status(id);
				status.setVisible(true);
			}
		});
		myPageSearch.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		myPageSearch.setBounds(472, 85, 180, 41);
		panel.add(myPageSearch);
		
		JButton buyRequsetStatus = new JButton("\uAD6C\uC785 \uC694\uCCAD \uC870\uD68C");
		buyRequsetStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_status cs = new Customer_status(id);
				cs.setVisible(true);
			}
		});
		buyRequsetStatus.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		buyRequsetStatus.setBounds(472, 208, 180, 41);
		panel.add(buyRequsetStatus);
		
		JButton BuyRequest = new JButton("\uAD6C\uC785 \uC694\uCCAD");
		BuyRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_request cr = new Customer_request(id);
				cr.setVisible(true);
				
			}
		});
		BuyRequest.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		BuyRequest.setBounds(472, 147, 180, 41);
		panel.add(BuyRequest);
		
		JButton refresh = new JButton("\uC0C8\uB85C \uACE0\uCE68");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UCmain refresh = new UCmain(id);
				refresh.setVisible(true);
			}
		});
		refresh.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		refresh.setBounds(472, 272, 180, 41);
		panel.add(refresh);
		

	}
}
