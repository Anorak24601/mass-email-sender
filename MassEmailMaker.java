package functional;

import javax.mail.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MassEmailMaker {
	JPanel loginLabels, loginInteractives, loginButton, fieldAreaPanel, rField, moveNextPanel, rLabels, rEntries, rButtons,
	subj, content, emailButtons, redundancyLabel, redundancyArea, redundancyButtons;
	String userCredential, passCredential;
	ArrayList<String> fields = new ArrayList<String>();
	
	public MassEmailMaker() {
		//VisManager to be used throughout
		VisibilityManager vm = new VisibilityManager(this);
		//make basic window
		JFrame win = new JFrame("Mass Email System (MES)");
		win.setSize(500,400);
		win.setLayout(null);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//login page elements
		loginLabels = new JPanel(); //labels for username and password
		loginLabels.setBounds(50,25,70,200);
		loginLabels.setLayout(new GridLayout(2,1));
		loginLabels.add(new JLabel("Email:"));
		loginLabels.add(new JLabel("Password:"));
		
		loginInteractives = new JPanel(); //fields for username and password
		loginInteractives.setBounds(120,25,320,200);
		loginInteractives.setLayout(new GridLayout(6,1));
		loginInteractives.add(new JLabel(""));
		JTextField userField = new JTextField();
		loginInteractives.add(userField);
		loginInteractives.add(new JLabel(""));
		loginInteractives.add(new JLabel(""));
		JTextField passField = new JTextField();
		loginInteractives.add(passField);
		
		loginButton = new JPanel(); //button for login
		loginButton.setBounds(200,250,100,50);
		JButton login = new JButton("Log In");
		loginButton.add(login);
		
		win.add(loginLabels);
		win.add(loginInteractives);
		win.add(loginButton);
		
		//time for recepient fields!
		fieldAreaPanel = new JPanel(); //JTextArea that displays fields
		fieldAreaPanel.setBounds(50,90,390,200);
		fieldAreaPanel.setLayout(new BorderLayout());
		JTextArea fieldArea = new JTextArea();
		fieldArea.setText("email\nfirstName\nlastName");
		fieldArea.setEditable(false);
		JScrollPane scrollField = new JScrollPane(fieldArea);
		scrollField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		fieldAreaPanel.add(scrollField);
		
		rField = new JPanel(); //panel where you add new fields in
		rField.setBounds(50,10,390,70);
		rField.add(new JLabel("New Field:"));
		JTextField newField = new JTextField("",10);
		rField.add(newField);
		JButton addField = new JButton("Add Field");
		rField.add(addField);
		rField.add(new JLabel("Current List of Fields:"));
		
		moveNextPanel = new JPanel(); //button to move
		moveNextPanel.setBounds(200, 300, 100, 50);
		JButton moveNext = new JButton("Confirm Fields");
		moveNextPanel.add(moveNext);
		
		win.add(fieldAreaPanel);
		win.add(rField);
		win.add(moveNextPanel);
		
		//time to add some recipients
		rLabels = new JPanel(); //labels for JTextAreas
		rLabels.setBounds(50,10,390,20);
		rLabels.setLayout(new GridLayout(1,3));
		rLabels.add(new JLabel("List of Fields to Enter:"));
		rLabels.add(new JLabel("  Enter Fields Here:"));
		rLabels.add(new JLabel("List of Recipients:"));
		
		rEntries = new JPanel();
		rEntries.setBounds(30,40,430,270); //JTextAreas to enter fields into
		rEntries.setLayout(new GridLayout(1,3));
		JTextArea fieldsList = new JTextArea();
		fieldsList.setEditable(false);
		JScrollPane scrollList = new JScrollPane(fieldsList);
		scrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rEntries.add(scrollList);
		JTextArea fieldEntries = new JTextArea();
		JScrollPane scrollEntries = new JScrollPane(fieldEntries);
		scrollEntries.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollEntries.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rEntries.add(scrollEntries);
		JTextArea recipientsArea = new JTextArea();
		recipientsArea.setEditable(false);
		recipientsArea.setText("");
		JScrollPane scrollRecipients = new JScrollPane(recipientsArea);
		scrollRecipients.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollRecipients.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rEntries.add(scrollRecipients);
		
		rButtons = new JPanel();
		rButtons.setBounds(127,320,230,25);
		rButtons.setLayout(new GridLayout(1,2));
		JButton addRecipient = new JButton("Add Recipient");
		JButton doneRecipients = new JButton("Finished");
		rButtons.add(addRecipient);
		rButtons.add(doneRecipients);
		
		ArrayList<Recipient> recipients = new ArrayList<Recipient>();
		
		win.add(rLabels);
		win.add(rEntries);
		win.add(rButtons);
		
		//second to last bit, writing the email
		subj = new JPanel(); //Labels and field for Subject
		subj.setBounds(50,10,390,70);
		subj.setLayout(new GridLayout(3,1));
		subj.add(new JLabel("Subject:"));
		JTextField subjField = new JTextField();
		subj.add(subjField);
		subj.add(new JLabel("Body:"));
		
		content = new JPanel(); //JTextArea for body
		content.setBounds(50,80,390,230);
		content.setLayout(new GridLayout(1,1));
		JTextArea body = new JTextArea();
		body.setLineWrap(true);
		body.setWrapStyleWord(true);
		JScrollPane scrollBody = new JScrollPane(body);
		scrollBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		content.add(scrollBody);
		
		emailButtons = new JPanel(); //send and back buttons
		emailButtons.setBounds(180,320,140,25);
		emailButtons.setLayout(new GridLayout(1,2));
		JButton back = new JButton("Back");
		JButton preSend = new JButton("Done");
		emailButtons.add(back);
		emailButtons.add(preSend);
		
		win.add(subj);
		win.add(content);
		win.add(emailButtons);
		
		//the redundancy
		redundancyLabel = new JPanel(); //label
		redundancyLabel.setBounds(50,10,390,20);
		redundancyLabel.add(new JLabel("Example Output:"));
		
		redundancyArea = new JPanel(); //output area
		redundancyArea.setBounds(50,40,390,270);
		redundancyArea.setLayout(new BorderLayout());
		JTextArea example = new JTextArea();
		example.setEditable(false);
		example.setLineWrap(true);
		example.setWrapStyleWord(true);
		JScrollPane scrollEx = new JScrollPane(example);
		scrollEx.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		redundancyArea.add(scrollEx);
		
		redundancyButtons = new JPanel(); //buttons to send and go back
		redundancyButtons.setBounds(180,320,140,25);
		redundancyButtons.setLayout(new GridLayout(1,2));
		JButton cancel = new JButton("Back");
		JButton send = new JButton("Send");
		redundancyButtons.add(cancel);
		redundancyButtons.add(send);
		
		win.add(redundancyArea);
		win.add(redundancyButtons);
		win.add(redundancyLabel);
		
		//TODO: Message page: JTextField for subject, JTextArea for message. Add scroll bar! Use brackets for around each field to be
		//      accessed (ex. [FirstName] gets replaced with that recipient's first name). Button for send
		//TODO: Redundancy page: Gives an example of what an email will look like if sent, buttons to send and to cancel
		
		ActionListener act = e -> {
			if(e.getSource() == login) { //login button on first page
				//authenticate the creds now so you don't have to do it later
				if (authenticate("pop.gmail.com", "pop3", userField.getText(), passField.getText())) {
					userCredential = userField.getText();
					passCredential = passField.getText();
					vm.recipientFields();
				}
				else new ErrorMessage("Invalid Credentials");
			}
			
			if(e.getSource() == addField) { //button to add recipient fields
				fieldArea.setText(fieldArea.getText() + "\n" + newField.getText());
				newField.setText("");
			}
			
			if(e.getSource() == moveNext) { //button to move from recipient fields to adding recipients
				String[] fieldsArr = fieldArea.getText().split("\\n");
				for(String i : fieldsArr) fields.add(i);
				fieldsList.setText(fieldArea.getText());
				vm.addRecipients();
			}
			
			if(e.getSource() == addRecipient) { //add a recipient button
				String[] rBoxArr = fieldEntries.getText().split("\\n");
				if(rBoxArr.length == fields.size()) {
					if(rBoxArr[0].contains("@")) {
						ArrayList<String> rList = new ArrayList<String>();
						for(String i : rBoxArr) rList.add(i);
						Recipient newR = new Recipient(fields, rList);
						recipients.add(newR);
						recipientsArea.setText(recipientsArea.getText() + (recipientsArea.getText().equals("")?"":"\n") 
								+ newR.yoink("email"));
						fieldEntries.setText("");
					} else new ErrorMessage("No Email Detected");
				} else new ErrorMessage("Incorrect Number of Arguments");
			}
			
			if(e.getSource() == doneRecipients) { //move from recipients to writing email
				vm.writeEmail();
			}
			
			if(e.getSource() == back) { //move from writing email to recipients
				vm.addRecipients();
			}
			
			if(e.getSource() == preSend) { //go to redundancy
				example.setText("TO: " + recipients.get(0).yoink("email") + "\nFROM: " + userCredential + "\n================" 
						+ "\nSUBJ: " + customizeEmail(subjField.getText(), recipients.get(0)) + "\n================\nBODY:\n"
						+ customizeEmail(body.getText(), recipients.get(0)));
				vm.redundancy();
			}
			
			if(e.getSource() == cancel) { //go back to keep working
				vm.writeEmail();
			}
			
			if(e.getSource() == send) {
				// SMTP server information
		        String host = "smtp.gmail.com";
		        String port = "587";
		        String mailFrom = userCredential;
		        String password = passCredential;
		        
		        for(Recipient r : recipients) {
		        	String mailTo = r.yoink("email");
		            String subject = customizeEmail(subjField.getText(), r);
		            String message = customizeEmail(body.getText(), r);
		            
		            MassEmailSender mailer = new MassEmailSender();
		            
		            try {
		                mailer.sendEmail(host, port, mailFrom, password, mailTo,
		                        subject, message);
		                System.out.println("Email Sent.");
		            } catch (Exception ex) {
		                System.out.println("Failed to sent email.");
		                ex.printStackTrace();
		            }
		        }
		        
		        new FinalPopup("All emails have finished sending!");
			}
		};
		
		//give the buttons that sweet, sweet ActionListener
		login.addActionListener(act);
		addField.addActionListener(act);
		moveNext.addActionListener(act);
		addRecipient.addActionListener(act);
		doneRecipients.addActionListener(act);
		back.addActionListener(act);
		preSend.addActionListener(act);
		cancel.addActionListener(act);
		send.addActionListener(act);
		
		//finally, make the proper things visible
		win.setVisible(true);
		vm.loginPage();
	}
	
	public static void main(String[] args) {
		new MassEmailMaker();
    }

//swap args in brackets with their counterparts
public static String customizeEmail(String mail, Recipient r) {
	String[] mailWords = mail.split(" ");
	StringBuilder finishedProduct = new StringBuilder();
	
	for(int i = 0; i < mailWords.length; i++) {
		if(mailWords[i].contains("[") && mailWords[i].contains("]")) {
			StringBuilder replacer = new StringBuilder(mailWords[i]);
			String key = mailWords[i].substring(mailWords[i].indexOf("[") + 1, mailWords[i].indexOf("]"));
			replacer.replace(mailWords[i].indexOf("["), mailWords[i].indexOf("]")+1, r.yoink(key));
			mailWords[i] = replacer.toString();
		}
		finishedProduct.append(mailWords[i] + (i<mailWords.length-1?" ":""));
	}
	
	return finishedProduct.toString();
}

public static boolean authenticate(String host, String storeType, String user,
	      String password) 
	   {
	      try {

	      //create properties field
	      Properties properties = new Properties();

	      properties.put("mail.pop3.host", host);
	      properties.put("mail.pop3.port", "995");
	      properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
	  
	      //create the POP3 store object and connect with the pop server
	      Store store = emailSession.getStore("pop3s");

	      store.connect(host, user, password);

	      //create the folder object and open it
	      Folder emailFolder = store.getFolder("INBOX");
	      emailFolder.open(Folder.READ_ONLY);

	      // retrieve the messages from the folder in an array, which will attempt a login
	      @SuppressWarnings("unused")
		Message[] messages = emailFolder.getMessages();

	      //close the store and folder objects
	      emailFolder.close(false);
	      store.close();
	      return true;

	      } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	      } 
	   }
}