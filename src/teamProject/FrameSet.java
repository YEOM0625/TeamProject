package teamProject;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameSet {
	Frame f;
	
	public FrameSet(Frame f) {
		this.f = f;
	}
	
	public void myExit(Frame f){
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}//셋바운드
	public void FrameSetBounds(Frame f) {
		f.setBounds(400, 80, 450, 600);
		f.setLayout(null);
		
	}
	
}
