package teamProject;

import java.awt.Frame;
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
//import javax.swing.JToggleButton;

public class ChooseSeatButton {
	Frame f;
	int allseat = 50;
	int seatNum = allseat/6;
	ArrayList<String> selectedSeat = new ArrayList<>();
	
	Random random = new Random();
	
	//좌석의 버튼
	JButton[][] seat_btn = new JButton[allseat][seatNum];
	
	public ChooseSeatButton(Frame f) {
		this.f = f;
	}
	
	//버튼 구현
	public void Buttons() {
		Selectedseat ss = new Selectedseat(new JButton());
		Age_Numb_count anc = new Age_Numb_count(new Frame());
		
		int selSeat;
		int countNum;
		
		
		for(int i=1; i<7; i++) {
			for(int j=1; j<seatNum; j++) {
				
				
				seat_btn[i][j] = new JButton((char)(i+64)+"열"+ j);
				//(400, 150, 670, 800); 영화 좌석 프레임의 크기
				
				//좌석의 크기
				seat_btn[i][j].setBounds(j*80-20, i*70+100, 70, 60);
				seat_btn[i][j].setVisible(true);
				
				
				
				//좌석선택 버튼 추가
				ss.isSelectedseat(seat_btn[i][j]);
			
				
				
				f.add(seat_btn[i][j]);
			}
		}
		
		int count =0 ;
		
		for(int i=1; i<7; i++) {
			for(int j=1; j<seatNum; j++) {
				selSeat = random.nextInt(1,allseat/seatNum);
				
				//랜덤 이미 앉은자리
				if(count<allseat/2+3) {
					seat_btn[i][selSeat].setEnabled(false);
					count++;
				}
				
				
			}
		}
		
	}
	
	
	public void action() {
		Buttons();
		
	}
	
		
}
