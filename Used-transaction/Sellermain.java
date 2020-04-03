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

public class Sellermain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton refuse;

	public Sellermain(String id) {
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
	          	else if(txtarr[3].equals("요청") || txtarr[3].equals("구매중")) {
	          		for(int k=0; k<4; k++) {
	          			contents[i][k]=txtarr[k];
	          		}
	          		i++;	
	          		System.out.println(txtarr[0]+" "+txtarr[1]+" "+txtarr[2]+" "+txtarr[3]);

	          	}
	          	 
	        }
	        
	        scan.close();

		}catch(IOException e1) {}
		
		table = new JTable(contents, header);
		table.setBounds(14, 23, 432, 379);
		panel.add(table);
		
		refuse = new JButton("\uC694\uCCAD \uCDE8\uC18C");
		refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_requestCancel src = new Seller_requestCancel(id);
				src.setVisible(true);
			}
		});
		refuse.setFont(new Font("굴림", Font.PLAIN, 20));
		refuse.setBounds(472, 176, 180, 41);
		panel.add(refuse);
		
		JButton selling = new JButton("\uD310\uB9E4\uAE00 \uB4F1\uB85D");
		selling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_request sellup = new Seller_request(id);
				sellup.setVisible(true);
			}
		});
		selling.setFont(new Font("굴림", Font.PLAIN, 20));
		selling.setBounds(472, 23, 180, 41);
		panel.add(selling);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 23, 432, 379);
		panel.add(scrollPane);
		
		JButton sellingStatus = new JButton("\uD310\uB9E4\uAE00 \uC870\uD68C");
		sellingStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_Status ss = new Seller_Status(id);
				ss.setVisible(true);
			}
		});
		sellingStatus.setFont(new Font("굴림", Font.PLAIN, 20));
		sellingStatus.setBounds(472, 74, 180, 41);
		panel.add(sellingStatus);
		
		JButton refresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sellermain refresh =  new Sellermain(id);
				refresh.setVisible(true);
				dispose();
				
			}
		});
		refresh.setFont(new Font("굴림", Font.PLAIN, 20));
		refresh.setBounds(472, 227, 180, 41);
		panel.add(refresh);
		
		JButton sellComplete = new JButton("\uD310\uB9E4 \uC644\uB8CC");
		sellComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_sellcomplete ssc =  new Seller_sellcomplete(id);
				ssc.setVisible(true);
			}
		});
		sellComplete.setFont(new Font("굴림", Font.PLAIN, 20));
		sellComplete.setBounds(472, 125, 180, 41);
		panel.add(sellComplete);
	}
}
