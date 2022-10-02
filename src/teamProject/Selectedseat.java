package teamProject;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class Selectedseat{
	JButton b;
	static ArrayList<String> str = new ArrayList<>(); 
	static int countNum;
	int count=1;
	boolean check=true;
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public static int getCountNum() {
		return countNum;
	}

	public static void setCountNum(int countNum) {
		Selectedseat.countNum = countNum;
	}

	public static ArrayList<String> getStr() {
		return str;
	}

	public static void setStr(ArrayList<String> str) {
		Selectedseat.str = str;
	}

	public Selectedseat(JButton b) {
		this.b = b;
	}
	
	public void isSelectedseat(JButton sel_seat) {
		CheckListFrame cf = new CheckListFrame(new Frame());
		BuyFrame bf = new BuyFrame(new Frame());
		PriceFrame pr = new PriceFrame(new Frame());
		
			sel_seat.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(sel_seat.isEnabled()) {
						
						if(bf.getPerSum()>getCountNum()) {
							str.add(sel_seat.getActionCommand().toString());
							sel_seat.setEnabled(false);
							setStr(str);
							setCountNum(count++);
							
						}
						
						//현재 고른 좌석 갯수와 티켓을 구매한 인원의 비교
						else if(bf.getPerSum()==getCountNum()) {
							int answer = JOptionPane.showConfirmDialog(cf.Ch_seat_Frame, "인원에 대한 좌석선택이 끝났습니다","확인",JOptionPane.OK_CANCEL_OPTION);
								if(answer!=1) {
									JOptionPane.showMessageDialog(cf.Ch_seat_Frame, "다음 화면으로 이동해주세요");
									setCheck(false);
								}
							}
						
					}
					
					
						
					}
					
				
			
			});
		}
//		else {
//			JOptionPane.showMessageDialog(clf.Ch_seat_Frame, "좌석을 모두 고르셨습니다.");
//		}

		
	}
	
	
//}
