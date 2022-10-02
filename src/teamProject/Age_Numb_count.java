package teamProject;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Age_Numb_count{
	Frame f;
	boolean com = true;
	static int cnt[] = new int[4];
	static int sumAll;
	static boolean check;
	static String age[] = {"성인", "청소년", "어린이", "노인"};
	
	public static String[] getAge() {
		return age;
	}

	public static int getSumAll() {
		return sumAll;
	}

	public static boolean isCheck() {
		return check;
	}

	public static void setCheck(boolean check) {
		Age_Numb_count.check = check;
	}

	public static void setSumAll(int sumAll) {
		Age_Numb_count.sumAll = sumAll;
	}

	public Age_Numb_count(Frame f) {
		this.f = f;
	}
	
	public static int[] getCnt() {
		return cnt;
	}

	public static void setCnt(int[] cnt) {
		Age_Numb_count.cnt = cnt;
	}

	//해당 열에 해당하는 플러스 버튼과 텍스트 공간에 카운트를 통하여 인원수 증가
	public void countPlusNum(JButton b,TextArea t, int i) {
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String str;
				cnt[i]++;
				
				str = Integer.toString(cnt[i]);
				
				t.setText("");
				t.append(str);
				
				setCnt(cnt);
			}
		});
	}
	
	//해당 열에 해당하는 마이너스 버튼과 텍스트공간에 카운트를 통하여 인원수 감소
	public void countMinusNum(JButton b,TextArea t,int i) {
		
		b.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String str;
				
				if(cnt[i]!=0) {
					cnt[i]--;
				}
				else { //카운트의 값이 존재하지 않을 시 내려갈수 없기에 메세지 박스 출력
					JOptionPane.showMessageDialog(null, "현재 선택되어있는 인원이 존재하지않습니다.","error",JOptionPane.WARNING_MESSAGE);
				}
				str = Integer.toString(cnt[i]);
				t.setText("");
				t.append(str);
				setCnt(cnt);
			}
		});
	}
	
	//연령 및 인원 체크를 위한 버튼 생성 및 기존 프레임에 투입
	public void age_count_btn() {
		JButton[] per_Plus_btn = new JButton[4];
		JButton[] per_Minus_btn = new JButton[4];
		
		TextArea[] cnt_Numbers = new TextArea[4];
		TextArea[] showAge_area = new TextArea[4];
		
		ImageIcon[] Plus_btn_Img = new ImageIcon[4];
		ImageIcon[] Minus_btn_Img = new ImageIcon[4];
		
		JLabel[] jl_Plus_Img = new JLabel[4];
		JLabel[] jl_Minus_Img = new JLabel[4];
		
		String str = "";
		
		//인원수 추가 버튼 구현
		for(int i =0; i<4; i++) {
			//플러스 버튼 설정
			per_Plus_btn[i] = new JButton(new ImageIcon("src/Images/PlusbtnImg.png"));
			
			per_Plus_btn[i].setVisible(true);
			per_Plus_btn[i].setBounds(25,(i+1)*60+20,20,20);
			per_Plus_btn[i].setBorderPainted(false);
			
			Plus_btn_Img[i] = new ImageIcon("src/Images/PlusbtnImg.png"); //플러스 이미지 버튼 다운로드
			jl_Plus_Img[i] = new JLabel(Plus_btn_Img[i]);
			jl_Plus_Img[i].setVisible(true);
			
			//마이너스 버튼 설정
			per_Minus_btn[i] = new JButton(new ImageIcon("src/Images/MinusbtnImg.png"));
			
			per_Minus_btn[i].setVisible(true);
			per_Minus_btn[i].setBounds(50, (i+1)*60+20, 15, 20);
			per_Minus_btn[i].setBorderPainted(false);
			
			Minus_btn_Img[i] = new ImageIcon("src/Images/MinusbtnImg.png"); //마이너스 이미지 버튼 다운로드
			jl_Minus_Img[i] = new JLabel(Minus_btn_Img[i]);
			jl_Minus_Img[i].setVisible(true);
			
			//텍스트공간 형성
			cnt_Numbers[i] = new TextArea(str,0,0,TextArea.SCROLLBARS_NONE);
			
			cnt_Numbers[i].setBounds(250, (i+1)*60, 20, 20);
			cnt_Numbers[i].setVisible(true);
			
			showAge_area[i] = new TextArea(age[i],0,0,TextArea.SCROLLBARS_NONE);
			
			showAge_area[i].setBounds(20, (i+1)*60, 60, 20);
			showAge_area[i].setFont(new Font(age[i],Font.BOLD,18));
			showAge_area[i].setVisible(true);
			
			countPlusNum(per_Plus_btn[i],cnt_Numbers[i],i);
			countMinusNum(per_Minus_btn[i],cnt_Numbers[i],i);
			
			f.add(per_Plus_btn[i]);
			f.add(per_Minus_btn[i]);
			
			f.add(jl_Plus_Img[i]);
			f.add(jl_Minus_Img[i]);
			
			f.add(cnt_Numbers[i]);
			f.add(showAge_area[i]);
			
		}
		
	}
	
	public void Count() {
		age_count_btn();	
		
	}
}
