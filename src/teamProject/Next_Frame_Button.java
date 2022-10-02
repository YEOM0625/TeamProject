package teamProject;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Next_Frame_Button implements ActionListener {
	Frame pevFrame;
	Frame nextFrame;
	
	
	public Next_Frame_Button(Frame pevFrame, Frame nextFrame) {
		this.pevFrame = pevFrame;
		this.nextFrame = nextFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pevFrame.dispose();
		nextFrame.setVisible(true);
		
	}
}
