package edu.isistan.daclassifier;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MachineClassifierGUI extends JFrame {
	private static final long serialVersionUID = -2100873306896182724L;
	private JPanel contentPane;
	private JTextField txtP;
	private JTextField txtPdesc;
	private JTextField txtA0;
	private JTextField txtA0desc;
	private JTextField txtA1;
	private JTextField txtA1desc;
	private JTextField txtA2;
	private JTextField txtA2desc;
	
	private MachineClassifier classifier;
	private JTextArea txtResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MachineClassifierGUI frame = new MachineClassifierGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MachineClassifierGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setTitle("Machine classifier");
		
		classifier = new MachineClassifier();
		classifier.setDebugEnabled(true);
		classifier.loadInstances();
		classifier.trainModel();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JPanel panelPredicate = new JPanel();
		splitPane.setLeftComponent(panelPredicate);
		GridBagLayout gbl_panelPredicate = new GridBagLayout();
		gbl_panelPredicate.columnWidths = new int[]{0, 0, 0};
		gbl_panelPredicate.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPredicate.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPredicate.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPredicate.setLayout(gbl_panelPredicate);
		
		JLabel lblP = new JLabel("P");
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.insets = new Insets(0, 0, 5, 5);
		gbc_lblP.gridx = 0;
		gbc_lblP.gridy = 0;
		panelPredicate.add(lblP, gbc_lblP);
		
		txtP = new JTextField();
		GridBagConstraints gbc_txtP = new GridBagConstraints();
		gbc_txtP.insets = new Insets(0, 0, 5, 0);
		gbc_txtP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtP.gridx = 1;
		gbc_txtP.gridy = 0;
		panelPredicate.add(txtP, gbc_txtP);
		txtP.setColumns(10);
		
		JLabel lblPdesc = new JLabel("P_DESC");
		GridBagConstraints gbc_lblPdesc = new GridBagConstraints();
		gbc_lblPdesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblPdesc.gridx = 0;
		gbc_lblPdesc.gridy = 1;
		panelPredicate.add(lblPdesc, gbc_lblPdesc);
		
		txtPdesc = new JTextField();
		GridBagConstraints gbc_txtPdesc = new GridBagConstraints();
		gbc_txtPdesc.insets = new Insets(0, 0, 5, 0);
		gbc_txtPdesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPdesc.gridx = 1;
		gbc_txtPdesc.gridy = 1;
		panelPredicate.add(txtPdesc, gbc_txtPdesc);
		txtPdesc.setColumns(10);
		
		JLabel lblA0 = new JLabel("A0");
		GridBagConstraints gbc_lblA0 = new GridBagConstraints();
		gbc_lblA0.insets = new Insets(0, 0, 5, 5);
		gbc_lblA0.gridx = 0;
		gbc_lblA0.gridy = 2;
		panelPredicate.add(lblA0, gbc_lblA0);
		
		txtA0 = new JTextField();
		GridBagConstraints gbc_txtA0 = new GridBagConstraints();
		gbc_txtA0.insets = new Insets(0, 0, 5, 0);
		gbc_txtA0.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA0.gridx = 1;
		gbc_txtA0.gridy = 2;
		panelPredicate.add(txtA0, gbc_txtA0);
		txtA0.setColumns(10);
		
		JLabel lblA0desc = new JLabel("A0_DESC");
		GridBagConstraints gbc_lblA0desc = new GridBagConstraints();
		gbc_lblA0desc.insets = new Insets(0, 0, 5, 5);
		gbc_lblA0desc.gridx = 0;
		gbc_lblA0desc.gridy = 3;
		panelPredicate.add(lblA0desc, gbc_lblA0desc);
		
		txtA0desc = new JTextField();
		GridBagConstraints gbc_txtA0desc = new GridBagConstraints();
		gbc_txtA0desc.anchor = GridBagConstraints.NORTH;
		gbc_txtA0desc.insets = new Insets(0, 0, 5, 0);
		gbc_txtA0desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA0desc.gridx = 1;
		gbc_txtA0desc.gridy = 3;
		panelPredicate.add(txtA0desc, gbc_txtA0desc);
		txtA0desc.setColumns(10);
		
		JLabel lblA1 = new JLabel("A1");
		GridBagConstraints gbc_lblA1 = new GridBagConstraints();
		gbc_lblA1.insets = new Insets(0, 0, 5, 5);
		gbc_lblA1.gridx = 0;
		gbc_lblA1.gridy = 4;
		panelPredicate.add(lblA1, gbc_lblA1);
		
		txtA1 = new JTextField();
		GridBagConstraints gbc_txtA1 = new GridBagConstraints();
		gbc_txtA1.insets = new Insets(0, 0, 5, 0);
		gbc_txtA1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA1.gridx = 1;
		gbc_txtA1.gridy = 4;
		panelPredicate.add(txtA1, gbc_txtA1);
		txtA1.setColumns(10);
		
		JLabel lblA1desc = new JLabel("A1_DESC");
		GridBagConstraints gbc_lblA1desc = new GridBagConstraints();
		gbc_lblA1desc.insets = new Insets(0, 0, 5, 5);
		gbc_lblA1desc.gridx = 0;
		gbc_lblA1desc.gridy = 5;
		panelPredicate.add(lblA1desc, gbc_lblA1desc);
		
		txtA1desc = new JTextField();
		GridBagConstraints gbc_txtA1desc = new GridBagConstraints();
		gbc_txtA1desc.insets = new Insets(0, 0, 5, 0);
		gbc_txtA1desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA1desc.gridx = 1;
		gbc_txtA1desc.gridy = 5;
		panelPredicate.add(txtA1desc, gbc_txtA1desc);
		txtA1desc.setColumns(10);
		
		JLabel lblA2 = new JLabel("A2");
		GridBagConstraints gbc_lblA2 = new GridBagConstraints();
		gbc_lblA2.insets = new Insets(0, 0, 5, 5);
		gbc_lblA2.gridx = 0;
		gbc_lblA2.gridy = 6;
		panelPredicate.add(lblA2, gbc_lblA2);
		
		txtA2 = new JTextField();
		GridBagConstraints gbc_txtA2 = new GridBagConstraints();
		gbc_txtA2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA2.insets = new Insets(0, 0, 5, 0);
		gbc_txtA2.gridx = 1;
		gbc_txtA2.gridy = 6;
		panelPredicate.add(txtA2, gbc_txtA2);
		txtA2.setColumns(10);
		
		JLabel lblA2desc = new JLabel("A2_DESC");
		GridBagConstraints gbc_lblA2desc = new GridBagConstraints();
		gbc_lblA2desc.insets = new Insets(0, 0, 0, 5);
		gbc_lblA2desc.gridx = 0;
		gbc_lblA2desc.gridy = 7;
		panelPredicate.add(lblA2desc, gbc_lblA2desc);
		
		txtA2desc = new JTextField();
		GridBagConstraints gbc_txtA2desc = new GridBagConstraints();
		gbc_txtA2desc.anchor = GridBagConstraints.NORTH;
		gbc_txtA2desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA2desc.gridx = 1;
		gbc_txtA2desc.gridy = 7;
		panelPredicate.add(txtA2desc, gbc_txtA2desc);
		txtA2desc.setColumns(10);
		
		JPanel panelOutput = new JPanel();
		splitPane.setRightComponent(panelOutput);
		GridBagLayout gbl_panelOutput = new GridBagLayout();
		gbl_panelOutput.columnWidths = new int[]{83, 0, 0};
		gbl_panelOutput.rowHeights = new int[]{0, 0};
		gbl_panelOutput.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelOutput.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelOutput.setLayout(gbl_panelOutput);
		
		JPanel panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 0;
		panelOutput.add(panelButtons, gbc_panelButtons);
		GridBagLayout gbl_panelButtons = new GridBagLayout();
		gbl_panelButtons.columnWidths = new int[]{117, 0};
		gbl_panelButtons.rowHeights = new int[]{0, 23, 0, 23, 0};
		gbl_panelButtons.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelButtons.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelButtons.setLayout(gbl_panelButtons);
		
		JButton btnClassifyPredicate = new JButton("Classify predicate");
		btnClassifyPredicate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String output = classifier.classifyPredicate(
							txtP.getText(), txtPdesc.getText(),
							txtA0.getText(), txtA0desc.getText(),
							txtA1.getText(), txtA1desc.getText(),
							txtA2.getText(), txtA2desc.getText()
							).toString();
					txtResults.setText(output);
				} catch (Exception e) {
					e.printStackTrace();
					txtResults.setText(e.getMessage());
				}
			}
		});
		btnClassifyPredicate.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnClassifyPredicate = new GridBagConstraints();
		gbc_btnClassifyPredicate.insets = new Insets(0, 0, 5, 0);
		gbc_btnClassifyPredicate.gridx = 0;
		gbc_btnClassifyPredicate.gridy = 1;
		panelButtons.add(btnClassifyPredicate, gbc_btnClassifyPredicate);
		
		JButton btnClearResults = new JButton("Clear results");
		btnClearResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				txtResults.setText("");
			}
		});
		btnClearResults.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnClearResults = new GridBagConstraints();
		gbc_btnClearResults.insets = new Insets(0, 0, 5, 0);
		gbc_btnClearResults.gridx = 0;
		gbc_btnClearResults.gridy = 2;
		panelButtons.add(btnClearResults, gbc_btnClearResults);
		
		txtResults = new JTextArea();
		txtResults.setLineWrap(true);
		txtResults.setEditable(false);
		txtResults.setRows(10);
		txtResults.setWrapStyleWord(true);
		GridBagConstraints gbc_txtResults = new GridBagConstraints();
		gbc_txtResults.fill = GridBagConstraints.BOTH;
		gbc_txtResults.gridx = 1;
		gbc_txtResults.gridy = 0;
		panelOutput.add(txtResults, gbc_txtResults);
	}
}
