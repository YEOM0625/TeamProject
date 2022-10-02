package teamProject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class BuyFrame {
	
	
	Frame f; //메인에서 구매 버튼 클릭시 넘어오는 영화를 고르는 첫 프레임
	int[] cnt_group= new int[4];
	
	//세부 프레임 추가
	Frame age = new Frame("Age");
	Frame checkList = new Frame("CheckList");

	
	//세부 프레임 해당 터치 스크린 해당 버튼 구현
	JButton age_btn = new JButton("확인");
	JButton check_btn = new JButton("");
	
	CheckListFrame ch = new CheckListFrame(f);
	
	static int perSum;
	int[] cnt = new int[4];
	
	public static int getPerSum() {
		return perSum;
	}

	public static void setPerSum(int perSum) {
		BuyFrame.perSum = perSum;
	}

	public BuyFrame(Frame f) {
		this.f =f;
	}
	
	//세부 프레임 설정
	public void Frames() {
		FrameSet fset = new FrameSet(new Frame());
		
		//프레임 지정 크기 대입
		age.setBounds(480,200,300,350);
		age.setLayout(null);
		
		fset.FrameSetBounds(checkList);
		
		//프레임 아웃 지정
		fset.myExit(age);
		fset.myExit(checkList);

		//세부 프레임 해당 버튼 지정
		age.add(age_btn);
		checkList.add(check_btn);
		check_btn.setBounds(0, 0, 450, 600);
	}
	

	
	public void Buttons(){
		//해당 버튼의 역활 클래스
		Age_Numb_count anc = new Age_Numb_count(age);
		//체크리스트 클래스와의 연결
		CheckListFrame cl = new CheckListFrame(new Frame());
		cl.action();
		
		Random random = new Random();
		JButton[][] movie_time_btns = new JButton[4][5];
		int time;
		
		
//가장어려웠음		타임라인 버튼 생성 // 2차원 배열, 시간 랜덤 진짜 삭제땡기는부분 
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				
				if(j<2) { //j - 0, 1
					time=random.nextInt((j+1)*2,(j+1)*4);
					movie_time_btns[i][j] = new JButton(time+":"+time*5);
				}
				else if(j<4){ //j - 2, 3
					time=random.nextInt(j*2,j*3);
					movie_time_btns[i][j] = new JButton("1"+ time+":"+time*5);
				}
				else { //j - 4
					time=random.nextInt(1,j);
					movie_time_btns[i][j] = new JButton("2"+ time+":"+time*5);
				}
				
				movie_time_btns[i][j].setVisible(true);
				
				movie_time_btns[i][j].setBounds(j*60+122, i*140+85, 70,30);
				movie_time_btns[i][j].setBackground(Color.black);
				movie_time_btns[i][j].setForeground(Color.white);;
				movie_time_btns[i][j].setBorderPainted(false);
				f.add(movie_time_btns[i][j]);
				movie_time_btns[i][j].addActionListener(new Next_Frame_Button(f, age));
				
			}
			
		}
		
		
		
		//화면 전환 버튼 || 인원 선택 프레임 -> 체크리스트 프레임 // 취소버튼 따로 구현
		age_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt = anc.getCnt();
				String[] str = new String[4];
				
				for(int i=0; i<4; i++) {
					str[i] = Integer.toString(cnt[i]);	
				}
				int answer = JOptionPane.showConfirmDialog(f, "해당하는 인원이 맞습니까?\n성인 " +str[0] + " 명\n청소년 "
				+ str[1] + " 명\n어린이 " + str[2] + " 명\n노인 " + str[3]+ " 명","확인",JOptionPane.OK_CANCEL_OPTION);
				if(answer!=1) {
					age.dispose();
					checkList.setVisible(true);

				}
				for(int i=0; i<cnt.length; i++) {
					perSum+=cnt[i];
				}
				
				setPerSum(perSum);
				
				
			}
		});
		
		//화면 전환 버튼 || 체크리스트 프레임 -> 좌석 선택 프레임
		check_btn.addActionListener(new Next_Frame_Button(checkList, cl.Ch_seat_Frame));
		
		age_btn.setBounds(115, 290, 60, 40);
		age_btn.setBackground(Color.darkGray);
		////버튼 외곽선 투명화
		age_btn.setBorderPainted(false);
		
		//버튼 투명화
		check_btn.setContentAreaFilled(false);

		
		//해당 영화에 관한 이미지 투입
		ImageIcon[] movie_Img = new ImageIcon[4];
		JLabel[] jl_movie_Img = new JLabel[4];
		
		//해당 영화에 대한 포스터
		String[] movie_Img_name = {"src/Images/deadpool2Poster.jpg","src/Images/witch2Poster.jpg",
				"src/Images/crimecity2Poster.jpg","src/Images/bullettrainPoster.jpg"};
		
		
		ImageIcon[] movie_name = new ImageIcon[4];
		JLabel[] jl_movie_name = new JLabel[4];
		
		//해당 영화에 대한 제목
		String[] movie_name_string = {"src/Images/deadpool2name.png","src/Images/witch2name.png",
				"src/Images/crimecity2name.png", "src/Images/bullettrainname.png"};
		
		for(int i=0; i<4; i++) {
			movie_Img[i] = new ImageIcon(movie_Img_name[i]);
			jl_movie_Img[i] = new JLabel(movie_Img[i]);
			jl_movie_Img[i].setBounds(20, i*140+32, 100,140);
			jl_movie_Img[i].setVisible(true);
			
			movie_name[i] = new ImageIcon(movie_name_string[i]);
			
			jl_movie_name[i] = new JLabel(movie_name[i]);
			jl_movie_name[i].setBackground(Color.white);
			jl_movie_name[i].setBounds(130, i*140+30, 180, 40);
			jl_movie_name[i].setVisible(true);
			
			f.add(jl_movie_Img[i]);
			f.add(jl_movie_name[i]);
		}
		
	}		
	
	public void age_count() {
		Age_Numb_count anc = new Age_Numb_count(age);
			
		anc.age_count_btn();
		
	}
	
	public void ch() {
		
		ImageIcon check_Img = new ImageIcon("src/Images/choroWarning.jpg"); // 15세 영화 기준 
		JLabel checkList_Img = new JLabel(check_Img);
		checkList_Img.setBounds(0, 0, 450, 600);
		
		checkList.add(checkList_Img);
		
		ImageIcon age_back = new ImageIcon("src/Images/CgvLogo1.png");
		JLabel jl_age_Img = new JLabel(age_back);
		
		jl_age_Img.setBounds(0,0,300,350);
		age.add(jl_age_Img);
	}
	
	//구매 프레임 메인에 전달및 수행
		public void buyFrame_frame() {
			
			
			Frames();
			age_count();
			
			Buttons();
			ch();
		}
	
}
	