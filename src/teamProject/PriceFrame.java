package teamProject;

import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PriceFrame {
	
	
	Frame prFrame = new Frame("결제 금액");
	Frame f = new Frame();
	
	JButton buy_btn = new JButton("결제");
	
	int[] count = new int[4];
	String[] String = new String[4];
	
	FrameSet fset = new FrameSet(prFrame);
	int sumAll;
	TextArea ta = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
	
	public PriceFrame(Frame f) {
		this.f = f;
	}
	
	public void Frame() {
		
		fset.FrameSetBounds(prFrame);
		fset.myExit(prFrame);
		
			
		ta.setBounds(75, 50, 300, 400);
		ta.setVisible(true);
		
		
		prFrame.add(ta);
		
		
	}
	
	public void Button() {
		CheckListFrame cf = new CheckListFrame(new Frame());
		Age_Numb_count anc = new Age_Numb_count(new Frame());
		Selectedseat ss = new Selectedseat(new JButton());
		
		buy_btn.setBounds(165, 500, 100, 50);
		buy_btn.setVisible(true);
		
		prFrame.add(buy_btn);
		
		buy_btn.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count=anc.getCnt();
				String = anc.getAge();
				for(int i=0; i<4; i++) {
					
				sumAll+=count[i] * cf.agePrice[i];
				}
				int answer = JOptionPane.showConfirmDialog(f, "" + String[0] + " : "
					+ Integer.toString(count[0])+ "\n" + String[1] + " : "
					+ Integer.toString(count[1])+ "\n" + String[2] + " : "
					+ Integer.toString(count[2])+ "\n" + String[3] + " : "
					+ Integer.toString(count[3])+ "\n" + "고르신 좌석 : " + ss.getStr().toString() + "\n"
					+ "총 금액은 : " + Integer.toString(sumAll) + "원 입니다.\n"
					,"확인",JOptionPane.OK_CANCEL_OPTION);
				if(answer!=1) {
					JOptionPane.showMessageDialog(prFrame, "이용해주셔서 감사합니다.");
				}
				else {
					
				}
				
				}
			
		});
	}
	
	public void Image() {
		ImageIcon prFrame_Img = new ImageIcon("src/Images/seatBackGround2.jpg");
		JLabel jl_prFrame = new JLabel(prFrame_Img);
		jl_prFrame.setBounds(0, 0,450,600);
		
		
		prFrame.add(jl_prFrame);
		
	}
	
	
	public void action() {
		
		Frame();
		Button();
		Image();
	}
}
