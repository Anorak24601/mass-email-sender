package functional;

import javax.swing.*;
import java.awt.*;

//This is copied from ErrorMessage, pay the variable names no mind

@SuppressWarnings("serial")
public class FinalPopup extends JFrame{
	JLabel errorMessage = new JLabel();
	JButton ok = new JButton("Ok");

	public FinalPopup(String message) {
		super("Finished...");
		setSize(message.length()*7,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//display message
		errorMessage.setText(message);
		add(errorMessage);
		add(ok);
		
		//button can have local lambda function, closes frame
		ok.addActionListener(e -> {
			System.exit(0);
		});
		
		setVisible(true);
	}

}
