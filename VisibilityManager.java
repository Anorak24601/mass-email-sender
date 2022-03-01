package functional;

public class VisibilityManager {

	MassEmailMaker maker;
	
	public VisibilityManager(MassEmailMaker mem) {
		maker = mem;
	}
	
	public void loginPage() {
		maker.loginLabels.setVisible(true);
		maker.loginInteractives.setVisible(true);
		maker.loginButton.setVisible(true);
		maker.fieldAreaPanel.setVisible(false);
		maker.rField.setVisible(false);
		maker.moveNextPanel.setVisible(false);
		maker.rLabels.setVisible(false);
		maker.rEntries.setVisible(false);
		maker.rButtons.setVisible(false);
		maker.subj.setVisible(false);
		maker.content.setVisible(false);
		maker.emailButtons.setVisible(false);
		maker.redundancyArea.setVisible(false);
		maker.redundancyButtons.setVisible(false);
		maker.redundancyLabel.setVisible(false);
	}
	
	public void recipientFields() {
		maker.loginLabels.setVisible(false);
		maker.loginInteractives.setVisible(false);
		maker.loginButton.setVisible(false);
		maker.fieldAreaPanel.setVisible(true);
		maker.rField.setVisible(true);
		maker.moveNextPanel.setVisible(true);
		maker.rLabels.setVisible(false);
		maker.rEntries.setVisible(false);
		maker.rButtons.setVisible(false);
		maker.subj.setVisible(false);
		maker.content.setVisible(false);
		maker.emailButtons.setVisible(false);
		maker.redundancyArea.setVisible(false);
		maker.redundancyButtons.setVisible(false);
		maker.redundancyLabel.setVisible(false);
	}
	
	public void addRecipients() {
		maker.loginLabels.setVisible(false);
		maker.loginInteractives.setVisible(false);
		maker.loginButton.setVisible(false);
		maker.fieldAreaPanel.setVisible(false);
		maker.rField.setVisible(false);
		maker.moveNextPanel.setVisible(false);
		maker.rLabels.setVisible(true);
		maker.rEntries.setVisible(true);
		maker.rButtons.setVisible(true);
		maker.subj.setVisible(false);
		maker.content.setVisible(false);
		maker.emailButtons.setVisible(false);
		maker.redundancyArea.setVisible(false);
		maker.redundancyButtons.setVisible(false);
		maker.redundancyLabel.setVisible(false);
	}
	
	public void writeEmail() {
		maker.loginLabels.setVisible(false);
		maker.loginInteractives.setVisible(false);
		maker.loginButton.setVisible(false);
		maker.fieldAreaPanel.setVisible(false);
		maker.rField.setVisible(false);
		maker.moveNextPanel.setVisible(false);
		maker.rLabels.setVisible(false);
		maker.rEntries.setVisible(false);
		maker.rButtons.setVisible(false);
		maker.subj.setVisible(true);
		maker.content.setVisible(true);
		maker.emailButtons.setVisible(true);
		maker.redundancyArea.setVisible(false);
		maker.redundancyButtons.setVisible(false);
		maker.redundancyLabel.setVisible(false);
	}
	
	public void redundancy() {
		maker.loginLabels.setVisible(false);
		maker.loginInteractives.setVisible(false);
		maker.loginButton.setVisible(false);
		maker.fieldAreaPanel.setVisible(false);
		maker.rField.setVisible(false);
		maker.moveNextPanel.setVisible(false);
		maker.rLabels.setVisible(false);
		maker.rEntries.setVisible(false);
		maker.rButtons.setVisible(false);
		maker.subj.setVisible(false);
		maker.content.setVisible(false);
		maker.emailButtons.setVisible(false);
		maker.redundancyArea.setVisible(true);
		maker.redundancyButtons.setVisible(true);
		maker.redundancyLabel.setVisible(true);
	}

}
