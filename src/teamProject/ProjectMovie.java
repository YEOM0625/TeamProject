package teamProject;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import team_food.FinalFinal;

public class ProjectMovie {
	
	static Frame SubFrame = new Frame();
	
	public static Frame getSubFrame() {
		return SubFrame;
	}

	public static void setSubFrame(Frame subFrame) {
		SubFrame = subFrame;
	}

	public static void main(String[] args) {
		//필요 기능 추가 -----------------------------------------------------------------------------
		FrameSet fset = new FrameSet(new Frame()); // FrameSet클래스
		
		
		//프레임 해당 프레임 형식
		Frame mainFrame = new Frame();
		Frame subFrame = new Frame("sub");
		Frame buyFrame = new Frame("buy");
		
		Frame FoodFrame = new Frame("food");
		Frame LoginFrame = new Frame("Login");
		
		FinalFinal ff = new FinalFinal(FoodFrame);
		
		BuyFrame bFrame = new BuyFrame(buyFrame);
		bFrame.buyFrame_frame();
		
		JButton main_btn = new JButton("main");
		
		JButton buy_Ticket_btn = new JButton(new ImageIcon("src/Images/cgvLogoImg.jpg"));
		
		JButton Food_btn = new JButton("food");
		JButton Login_btn = new JButton("Login");
		
		
		JButton back_btn = new JButton(new ImageIcon("src/Images/cgvLogoImg.jpg"));
		
		main_btn.setBorderPainted(false); // 외곽선 지워줌
		buy_Ticket_btn.setBorderPainted(false); 
		back_btn.setBorderPainted(false);
		
		//이미지 투입
		ImageIcon mainBack = new ImageIcon("src/Images/TopgunPoster.jpg");
		JLabel jl_main = new JLabel(mainBack);
		jl_main.setBounds(0, 0, 450, 600);
		mainFrame.add(jl_main);
		
		ImageIcon subBack = new ImageIcon("src/Images/cgvLogoImg.jpg");
		JLabel jl_sub = new JLabel(subBack);
		jl_sub.setBounds(0, 20, 450, 580);
		jl_sub.setOpaque(false);
		
		ImageIcon backbtn_Img = new ImageIcon("src/Images/backBtn.png");
		JLabel jl_backbtn = new JLabel(backbtn_Img);
		back_btn.add(jl_backbtn);
		
		ImageIcon buybtn_Img = new ImageIcon("src/Images/buyBtnImg.png");
		JLabel jl_buybtn = new JLabel(buybtn_Img);
		buy_Ticket_btn.add(jl_buybtn);
		
		//프레임 크기 지정 -----------------------------------------------------------------------------
		fset.FrameSetBounds(mainFrame);
		fset.FrameSetBounds(LoginFrame);
//		fset.FrameSetBounds(FoodFrame);
		fset.FrameSetBounds(buyFrame);
		fset.FrameSetBounds(subFrame);
		buyFrame.setBackground(Color.black);
		
		//버튼 크기 지정 -----------------------------------------------------------------------------
		main_btn.setBounds(0, 0, 450, 600);
		main_btn.setContentAreaFilled(false); // 버튼 투명화
		buy_Ticket_btn.setBounds(5,200,150,250);
		Food_btn.setBounds(155,200,150,250);
		Login_btn.setBounds(305,200,150,250);
		back_btn.setBounds(20, 35, 80, 40);
		
		
		
		//메인 프레임 기능 -----------------------------------------------------------------------------
		mainFrame.add(main_btn);
		
		//서브 프레임 기능 -----------------------------------------------------------------------------
		subFrame.add(buy_Ticket_btn);
		subFrame.add(Login_btn);
		subFrame.add(Food_btn);
		subFrame.add(back_btn);
		
		
		//외부 프레임 기능
		
		
		//버튼을 통한 화면전환 -----------------------------------------------------------------------------
		main_btn.addActionListener(new Next_Frame_Button(mainFrame, subFrame));
		buy_Ticket_btn.addActionListener(new Next_Frame_Button(subFrame,buyFrame));
		Food_btn.addActionListener(new Next_Frame_Button(subFrame,FoodFrame));
		
		Login_btn.addActionListener(new Next_Frame_Button(subFrame, LoginFrame));
		
		//뒤로가기 
		back_btn.addActionListener(new Next_Frame_Button(subFrame, mainFrame));
		
		
		
		
		
		//윈도우 끄기 -----------------------------------------------------------------------------
		fset.myExit(mainFrame);
		fset.myExit(subFrame);
		fset.myExit(LoginFrame);
		fset.myExit(FoodFrame);
		fset.myExit(buyFrame);
		subFrame.add(jl_sub);
		
		setSubFrame(subFrame);
		
		mainFrame.setVisible(true);
	}
}
