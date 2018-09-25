package carbControl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 428, 362);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Consultar Usu\u00E1rio", null, panel, null);
		panel.setLayout(null);
		
		Label label_4 = new Label("Nome");
		label_4.setBounds(10, 10, 202, 24);
		panel.add(label_4);
		
		Label label_6 = new Label("E-mail");
		label_6.setBounds(10, 72, 202, 24);
		panel.add(label_6);
		
		Label label_7 = new Label("Idade");
		label_7.setBounds(10, 141, 53, 24);
		panel.add(label_7);
		
		Label label_8 = new Label("Peso (Kg)");
		label_8.setBounds(93, 141, 85, 24);
		panel.add(label_8);
		
		Label label_9 = new Label("Raz\u00E3o I/C");
		label_9.setBounds(184, 141, 120, 24);
		panel.add(label_9);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 165, 51, 26);
		panel.add(textField_2);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(93, 165, 51, 26);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(184, 165, 51, 26);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 96, 332, 26);
		panel.add(textField_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 40, 332, 26);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Editar Usu\u00E1rio", null, panel_1, null);
		panel_1.setLayout(null);
		
		Label label_10 = new Label("Nome");
		label_10.setBounds(15, 10, 202, 24);
		panel_1.add(label_10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(15, 40, 332, 26);
		panel_1.add(comboBox_1);
		
		Label label_11 = new Label("Nome");
		label_11.setBounds(15, 82, 202, 24);
		panel_1.add(label_11);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(15, 112, 332, 26);
		panel_1.add(textField_9);
		
		Label label_12 = new Label("E-mail");
		label_12.setBounds(15, 144, 202, 24);
		panel_1.add(label_12);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(15, 174, 332, 26);
		panel_1.add(textField_10);
		
		Label label_13 = new Label("Idade");
		label_13.setBounds(15, 213, 127, 24);
		panel_1.add(label_13);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(15, 243, 51, 26);
		panel_1.add(textField_11);
		
		Label label_14 = new Label("Peso (Kg)");
		label_14.setBounds(98, 213, 85, 24);
		panel_1.add(label_14);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(98, 243, 51, 26);
		panel_1.add(textField_12);
		
		Label label_15 = new Label("Raz\u00E3o I/C");
		label_15.setBounds(189, 213, 120, 24);
		panel_1.add(label_15);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(189, 243, 51, 26);
		panel_1.add(textField_13);
		
		JButton button = new JButton("Salvar");
		button.setBounds(15, 285, 115, 29);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Novo Usu\u00E1rio", null, panel_2, null);
		panel_2.setLayout(null);
		
		Label label = new Label("Nome");
		label.setBounds(15, 10, 202, 24);
		panel_2.add(label);
		
		Label label_1 = new Label("E-mail");
		label_1.setBounds(15, 72, 202, 24);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Peso (Kg)");
		label_2.setBounds(98, 141, 85, 24);
		panel_2.add(label_2);
		
		Label label_3 = new Label("Raz\u00E3o I/C");
		label_3.setBounds(189, 141, 120, 24);
		panel_2.add(label_3);
		
		Label label_5 = new Label("Idade");
		label_5.setBounds(15, 141, 127, 24);
		panel_2.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(15, 40, 332, 26);
		panel_2.add(textField_3);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setBounds(15, 230, 115, 29);
		panel_2.add(button_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(15, 102, 332, 26);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(15, 171, 51, 26);
		panel_2.add(textField_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 171, 51, 26);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 171, 51, 26);
		panel_2.add(textField_1);
	}

}
