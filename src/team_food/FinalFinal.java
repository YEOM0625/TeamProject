package team_food;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import teamProject.ProjectMovie;

public class FinalFinal {

	int[] count = {0,0,0,0,0};
	String show = "";
	Frame frame;
	
	public FinalFinal(Frame frame) {
		// ��Ÿ�� ����
		ProjectMovie pm = new ProjectMovie();
		this.frame =frame;
//		Frame rm = new Frame("�޺� ����");
		frame.setBounds(0, 0, 625, 700);
		frame.setBackground(Color.black);

		// ��Ʈ
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// ����
		Panel pNorth = new Panel();
		pNorth.setBackground(new Color(255, 200, 215));
		pNorth.setLayout(null);
		pNorth.setSize(0, 500);
		pNorth.setFont(font);

		// ��ư.

		String movie_arr[] = { "Ŀ���޺�", "�йи��޺�", "����", "�ݶ�","����"};
		
		int price[] = { 8500,9500,6000,2500,3000};
		Button minus[] = new Button[movie_arr.length];
		Button plus[] = new Button[movie_arr.length];
		JButton btn[] = new JButton[movie_arr.length];
		JButton ok[] = new JButton[movie_arr.length];
		TextField num[] = new TextField[movie_arr.length];
		ImageIcon icon[] = new ImageIcon[movie_arr.length]; 
		JLabel l[] = new JLabel[movie_arr.length];
		
		
		//�̹���
		// ���� �ؾߵ�.
		
		
		
		
		
		
		// ��ư ����.
		for (int i = 0; i < movie_arr.length; i++) {

			// ��ȭ ��ư
			btn[i] = new JButton(movie_arr[i]);
			if (i < 4) {
				btn[i].setBounds(20 + i * 155, 50, 110, 100);
			} else {
				btn[i].setBounds(20 + (i - 4) * 150, 300, 110, 100);
			}
			
			icon[i] = new ImageIcon(i+ "");
			btn[i].setIcon(icon[i]);
			

			

			// ���� txt ��ư
			num[i] = new TextField("0");
			num[i].setBackground(Color.white);
			num[i].setEditable(false);
			num[i].setBounds(btn[i].getX() + 30, btn[i].getY() + 130, 40, 20);


			// "-" ��ư
			minus[i] = new Button("-");
			minus[i].setBounds(btn[i].getX(), num[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			// "+" ��ư
			plus[i] = new Button("+");
			plus[i].setBounds(btn[i].getX() + (100 - 20), num[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			// ����
			l[i] = new JLabel(price[i] + "��");
			l[i].setBounds(btn[i].getX() + 20, num[i].getY() - 25, 100, 20);

			// Ȯ�� ��ư
			ok[i] = new JButton("Ȯ��");
			ok[i].setBounds(btn[i].getX(), num[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			pNorth.add(btn[i]);
			pNorth.add(num[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}

		// �߾�
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setText("  �޺���        ����        ����        �հ�\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// ����
		Panel pSouth = new Panel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(255, 200, 215));

		Button btn1 = new Button("����");
		Button btn2 = new Button("�ʱ�ȭ");
		Button btn3 = new Button("�ݱ�");
		pSouth.add(btn1);
		pSouth.add(btn2);
		pSouth.add(btn3);

		// �ֹ���ư
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + " ���ŵǾ����ϴ�. \n�̿����ּż� �����մϴ�.");
				for (int i = 0; i < movie_arr.length; i++) {
					btn[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("  �޺���        ����        ����        �հ�\n\n");

				}
			}
		});

		// �ʱ�ȭ ��ư
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < movie_arr.length; i++) {
					btn[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("  �޺���        ����        ����        �հ�\n\n");

				}
			}
		});

		// bt3 �ݱ��ư

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				pm.getSubFrame().setVisible(true);
			}
		});

		// ������Ʈ
		frame.add(pNorth, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(pSouth, BorderLayout.SOUTH);
		

		// �̺�Ʈ
		for (int i = 0; i < movie_arr.length; i++) {
			int j = i;

			// ��ư �̺�Ʈ
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					btn[j].setEnabled(false);
					ok[j].setEnabled(true);

					count[j] = 0;
				}
			});

			// "-" ��ư �̺�Ʈ
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count[j] > 0) {
						count[j] = count[j] - 1;
						num[j].setText(count[j] + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" ��ư �̺�Ʈ
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count[j] = count[j] + 1;
					num[j].setText(count[j] + "");
					ok[j].setEnabled(true);
					if (count[j] > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// Ȯ�� ��ư
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				
					ta.append(" " + movie_arr[j] + "        " + price[j] + "       " + count[j] + "         " + price[j] * count[j]
							+ "��" + "\n");
					ok[j].setEnabled(false);
				}
			});

		}

		// x버튼시 종료
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	
	
	
}
