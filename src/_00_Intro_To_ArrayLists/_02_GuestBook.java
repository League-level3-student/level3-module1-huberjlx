package _00_Intro_To_ArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	ArrayList<String> guests = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton view = new JButton();
	
	public static void main(String[] args) {
		_02_GuestBook gb = new _02_GuestBook();
		gb.run();
	
	}
	
	public void run() {
		add.setText("Add Name");
		view.setText("View Names");
		add.addActionListener(this);
		view.addActionListener(this);
		panel.add(add);
		panel.add(view);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton)e.getSource();
		if (buttonClicked == add) {
			//System.out.println("Stuff");
			addGuests();
		}
		else if (buttonClicked == view) {
			//System.out.println("More Stuff");
			viewGuests();
		}
		
	}
	
	public void viewGuests() {
		if (guests.size() == 0) {
			JOptionPane.showMessageDialog(null, "There are no guests at this time");
		}
		else {
			String message = "";
			for (int i = 0; i < guests.size(); i++) {
				message += "Guest #" + (i + 1) + ": " + guests.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, message);
		}

	}
	
	public void addGuests() {
		String name = JOptionPane.showInputDialog("Enter a name for the guest book:");
		guests.add(name);
	}
	
	
}
