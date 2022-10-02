package teamProject;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CheckListFrame {
	Frame Ch_seat_Frame = new Frame("좌석 선택");
	
	Frame f;
	JButton ok_btn = new JButton("확인");
	PriceFrame p = new PriceFrame(f);
	
	int[] countNum = new int[4];
	String[] AgeString = new String[4];
	
	int[] agePrice = {10000, 8000, 6000, 5000};
	int sumAll;
	
	ImageIcon seat_Img = new ImageIcon("src/Images/seatBackGround1.jpg");
	JLabel jl_seat = new JLabel(seat_Img);
	
	public CheckListFrame(Frame f) {
		this.f = f;
	}
	
	public void Frame() {
		FrameSet fset = new FrameSet(new Frame());	
		PriceFrame pr = new PriceFrame(new Frame());
		Selectedseat ss = new Selectedseat(new JButton());
		Age_Numb_count anc = new Age_Numb_count(new Frame());
		ProjectMovie pm = new ProjectMovie();
		
		
		pr.action();
		//프레임 지정 크기 대입
		Ch_seat_Frame.setBounds(350, 30, 670, 700);
		Ch_seat_Frame.setLayout(null);
		
		
		jl_seat.setBounds(0, 0,670,700);
		
		
		
		//프레임 아웃 지정
		fset.myExit(Ch_seat_Frame);
		
		//세부 프레임 해당 버튼 지정

		//화면 전환 버튼
		ok_btn.setBounds(280, 600, 100, 60);
		ok_btn.setVisible(true);
		
		
		ok_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ch_seat_Frame.dispose();
				pr.prFrame.setVisible(true);
				
				countNum = anc.getCnt();
				AgeString = anc.getAge();
				
				
				//선택한 모든 좌석
				for(int i=0; i<4; i++) {
					pr.ta.append(AgeString[i]+ " : " + Integer.toString(countNum[i]) +
						"    금액 : " +Integer.toString(countNum[i]*agePrice[i])+ "원\n" );
					sumAll+=countNum[i]*agePrice[i];
				}
				pr.ta.append("고르신 좌석 : " + ss.getStr().toString() + "\n");
				pr.ta.append("총 금액은 : " + Integer.toString(sumAll) + "원 입니다.\n");
				
				
				
				
			}
			
		});
		
		Ch_seat_Frame.add(ok_btn);
	}
	

	public void seatBtn() {
		//좌석 선택버튼 프레임
		ChooseSeatButton csb = new ChooseSeatButton(Ch_seat_Frame);
		csb.action();
		
		
	}
	
	public void action() {
		
		Frame();
		seatBtn();
		Ch_seat_Frame.add(jl_seat);
	}
}
