import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seller_Status extends JFrame{

	private static final Object[][] String = null;
	private JPanel contentPane;
	private JTable table;
	private JButton cancel;

	public Seller_Status(String id) {
		setTitle("\uD310\uB9E4 \uD604\uD669");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		String header[] = {"중고품","가격","상태"};
		String[][] contents = new String[1000][3];
		
		for(int i=0; i<1000; i++) {	//배열 초기화
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
	          	else if(txtarr[3].equals("판매")) {
	          		for(int k=1; k<4; k++) 
		          		contents[i][k-1]=txtarr[k];
		          	i++;	          
		          	System.out.println(txtarr[0]+" "+txtarr[1]+" "+txtarr[2]+" "+txtarr[3]);

	          	}
	       }
	        
	        scan.close();

		}catch(IOException e1) {}
		
		
		
		
		table = new JTable(contents,header);
		table.setBounds(1, 32, 438, 16);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 27, 405, 388);
		panel.add(scrollPane);
		
		cancel = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Cancelpage cp = new User_Cancelpage(id);
				cp.setVisible(true);
			}
		});
		
		cancel.setFont(new Font("굴림", Font.PLAIN, 20));
		cancel.setBounds(467, 27, 168, 54);
		panel.add(cancel);
		
		JButton back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		back.setFont(new Font("굴림", Font.PLAIN, 20));
		back.setBounds(467, 105, 168, 54);
		panel.add(back);
		
		JButton refresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_Status refresh = new Seller_Status(id);
				refresh.setVisible(true);
				dispose();
			}
		});
		refresh.setFont(new Font("굴림", Font.PLAIN, 20));
		refresh.setBounds(467, 185, 168, 54);
		panel.add(refresh);
		
		
	}
}
