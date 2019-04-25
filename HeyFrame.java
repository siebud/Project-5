import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HeyFrame extends JFrame {
	
	HeyPanel panel1; // left side of window, with required components
	HeyPanel panel2; // right side with optional components and fun stuff
		
	public HeyFrame() {
		setTitle("Hamming Distance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		//panel one stuff
		panel1 = new HeyPanel();
		JLabel entryLabel;
		JTextField entryField;
		JSlider dist;
		JButton showStation;
		JTextArea stationList;
		JLabel testID;
		JComboBox<String> selectList;
		
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints layoutConst = null;
		
		entryLabel = new JLabel("Enter Hamming Dist:");
		entryField = new JTextField("2", 10);
		entryField.setEditable(false);
		
		dist = new JSlider(1,4);
		dist.setPaintLabels(true);
		dist.setPaintTicks(true);
		dist.setMajorTickSpacing(1);
		dist.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				dist.getValue();	
				entryField.setText(String.valueOf(dist.getValue()));
			}
		});
		
		stationList = new JTextArea(10, 20);
		stationList.setEditable(false);
		JScrollPane stationPane = new JScrollPane(stationList);
		
		Comparison comp = null;
		try {
			comp = new Comparison("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		testID = new JLabel("Compare with: \t");
		selectList = new JComboBox<String>(comp.getNameList()); //use addItem(Object)
		
		showStation = new JButton("Show Station");
		showStation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Comparison c = new Comparison((String)selectList.getSelectedItem());
				
					ArrayList<String> newList = c.getNames(dist.getValue());
					String textFormat = "";
					for(int i = 0; i <newList.size(); i++) {
						
						textFormat = textFormat + newList.get(i) + "\n";
						stationList.setText(textFormat);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
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
		panel1.add(stationPane,layoutConst);
		
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
		
	
		
		d0 = new JLabel("Distance 0");
		n0 = new JTextField("0", 3);
		n0.setEditable(false);
		d1 = new JLabel("Distance 1");
		n1 = new JTextField("0", 3);
		n1.setEditable(false);
		d2 = new JLabel("Distance 2");
		n2 = new JTextField("0", 3);
		n2.setEditable(false);
		d3 = new JLabel("Distance 3");
		n3 = new JTextField("0", 3);
		n3.setEditable(false);
		d4 = new JLabel("Distance 4");
		n4 = new JTextField("0", 3);
		n4.setEditable(false);
			calcButton = new JButton("Calculate HD");
		
		calcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Comparison c = new Comparison((String)selectList.getSelectedItem());
					n0.setText(String.valueOf(c.getZeros()));
					n1.setText(String.valueOf(c.getOnes()));
					n2.setText(String.valueOf(c.getTwos()));
					n3.setText(String.valueOf(c.getThrees()));
					n4.setText(String.valueOf(c.getFours()));
				
				} catch (IOException e) {
					n0.setText("No station selected");
					e.printStackTrace();
				}
			}
		});	
		newStation = new JTextField(10);
		newStation.setEditable(true);
		addStation = new JButton("Add Station");
		ArrayList<String> nameList = new ArrayList<String>();
		addStation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!nameList.contains(newStation.getText())) {
					selectList.addItem(newStation.getText());	//write code to handle duplicates
					nameList.add(newStation.getText());
				}
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
		
		panel2 = new HeyPanel();
		panel2.setSize(400,400);
		panel2.setVisible(true);
		panel2Stuff();
		layoutConst = new GridBagConstraints();
		layoutConst.gridx=3;
		layoutConst.gridy=0;
		panel1.add(panel2, layoutConst);
		
		add(panel1);

		pack();
		
	}
	
	private void panel2Stuff() {
		
		panel2.setLayout(new GridBagLayout());
		GridBagConstraints lc = null;
		
		JLabel newStuff = new JLabel("How far away from the station are you?");
		lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 0;
		panel2.add(newStuff, lc);

		JFormattedTextField inputStuff = new JFormattedTextField(100);
		inputStuff.setEditable(true);
		lc = new GridBagConstraints();
		lc.gridx = 1;
		lc.gridy = 0;
		panel2.add(inputStuff, lc);
		
		
	    ButtonGroup ops = new ButtonGroup();

	    JRadioButton w = new JRadioButton("Walking");
	    JRadioButton b = new JRadioButton("Biking");
	    JRadioButton d = new JRadioButton("Driving");
        ops.add(w);
        ops.add(b);
        ops.add(d);
        d.setSelected(true);
        
        lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 2;
        panel2.add(w, lc);
        
        lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 3;
        panel2.add(b, lc);
        
        lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 4;
        panel2.add(d, lc);
        
        JLabel output = new JLabel("You will arrive in ");
        lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 6;
		panel2.add(output, lc);
		
        JTextField stuffs = new JTextField(15);
		stuffs.setEditable(false);
		lc = new GridBagConstraints();
		lc.gridx = 1;
		lc.gridy = 6;
		panel2.add(stuffs, lc);
		
        JButton calc = new JButton("Calculate");
        lc = new GridBagConstraints();
		lc.gridx = 0;
		lc.gridy = 5;
		panel2.add(calc, lc);
        calc.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dist = Integer.valueOf(inputStuff.getText());
				if(w.isSelected()) {
					double time = dist/3.0;
				stuffs.setText(String.valueOf(time) + " hours");	
				}
				else if(b.isSelected()) {
					double time = dist/12.0;
				stuffs.setText(String.valueOf(time) + " hours");	
				}
				else if(d.isSelected()) {
					double time = dist/30.0;
				stuffs.setText(String.valueOf(time) + " hours");	
				}
			} 	
        });	
	}

	public static void main(String[] args) {
		new HeyFrame();
	}
}
