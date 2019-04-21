import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HeyFrame extends JFrame {
	
	private String selectedID = ""; // ID selected to compare others to
	private int selectedDist = 0;
	
	public HeyFrame() {
		setTitle("Hamming Distance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		HeyPanel panel1;
		HeyPanel panel2;
		HeyPanel panel3;
		
		//panel one stuff
		panel1 = new HeyPanel();
		JLabel entryLabel;
		JTextField entryField;
		JSlider dist;
		JButton showStation;
		JTextField stationList;
		JLabel testID;
		JComboBox selectList;
		
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints layoutConst = null;
		
		entryLabel = new JLabel("Enter Hamming Dist:");
		entryField = new JTextField(10);
		entryField.setEditable(true);
		
		dist = new JSlider(1,4);
		dist.setPaintLabels(true);
		dist.setPaintTicks(true);
		dist.setMajorTickSpacing(1);
		dist.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				selectedDist = dist.getValue();	
			}
		});
		
		showStation = new JButton("Show Station");
		
		stationList = new JTextField(20);
		stationList.setEditable(false);
		
		testID = new JLabel("Compare with: \t");
		selectList = new JComboBox(); //use addItem(Object)
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridx=0;
		panel1.add(entryLabel, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=0;
		panel1.add(entryField,layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=1;
		panel1.add(dist,layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=2;
		panel1.add(showStation,layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=3;
		panel1.add(stationList,layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=4;
		panel1.add(testID,layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=4;
		panel1.add(selectList, layoutConst);
		
		//second half parts
		JButton calcButton;
		JLabel d0;
		JTextField n0;
		JLabel d1;
		JTextField n1;
		JLabel d2;
		JTextField n2;
		JLabel d3;
		JTextField n3;
		JLabel d4;
		JTextField n4;
		JButton addStation;
		JTextField newStation;
		
		calcButton = new JButton("Calculate HD");
		d0 = new JLabel("Distance 0");
		n0 = new JTextField("0");
		n0.setEditable(false);
		d1 = new JLabel("Distance 1");
		n1 = new JTextField("0");
		n1.setEditable(false);
		d2 = new JLabel("Distance 2");
		n2 = new JTextField("0");
		n2.setEditable(false);
		d3 = new JLabel("Distance 3");
		n3 = new JTextField("0");
		n3.setEditable(false);
		d4 = new JLabel("Distance 4");
		n4 = new JTextField("0");
		n4.setEditable(false);
		newStation = new JTextField(10);
		newStation.setEditable(true);
		addStation = new JButton("Add Station");
		addStation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectList.addItem(newStation.getText());	//write code to handle duplicates
			}
		});	
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=5;
		panel1.add(calcButton, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=6;
		panel1.add(d0, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=6;
		panel1.add(n0, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=7;
		panel1.add(d1, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=7;
		panel1.add(n1, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=8;
		panel1.add(d2, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=8;
		panel1.add(n2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=9;
		panel1.add(d3, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=9;
		panel1.add(n3, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=10;
		panel1.add(d4, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=10;
		panel1.add(n4, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=0;
		layoutConst.gridy=11;
		panel1.add(addStation, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=1;
		layoutConst.gridy=11;
		panel1.add(newStation, layoutConst);
		
		
		add(panel1);
		pack();
		
	}

	public static void main(String[] args) {
		new HeyFrame();
	}
}
