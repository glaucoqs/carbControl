package carbControl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Alimento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alimento frame = new Alimento();
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
	public Alimento() {
		setResizable(false);
		setTitle("Gerenciar Alimentos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 523, 431);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Editar Alimento", null, panel, null);
		panel.setLayout(null);
		
		Label label = new Label("Categoria do Alimento");
		label.setBounds(10, 10, 202, 24);
		panel.add(label);
		
		Choice choice = new Choice();
		choice.setEnabled(false);
		choice.setBounds(10, 37, 289, 26);
		panel.add(choice);
		
		Label label_1 = new Label("Alimento");
		label_1.setBounds(10, 65, 202, 24);
		panel.add(label_1);
		
		Choice choice_1 = new Choice();
		choice_1.setEnabled(false);
		choice_1.setBounds(10, 95, 289, 26);
		panel.add(choice_1);
		
		JButton button = new JButton("Ok");
		button.setEnabled(false);
		button.setBounds(316, 37, 57, 22);
		panel.add(button);
		
		JButton button_1 = new JButton("Ok");
		button_1.setEnabled(false);
		button_1.setBounds(316, 95, 57, 22);
		panel.add(button_1);
		
		Label label_2 = new Label("Nome");
		label_2.setBounds(10, 145, 202, 24);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(10, 175, 289, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		Label label_3 = new Label("Categoria");
		label_3.setBounds(10, 207, 202, 24);
		panel.add(label_3);
		
		Choice choice_2 = new Choice();
		choice_2.setEnabled(false);
		choice_2.setBounds(10, 237, 289, 26);
		panel.add(choice_2);
		
		Label label_4 = new Label("Peso da por\u00E7\u00E3o");
		label_4.setBounds(10, 269, 120, 24);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 299, 105, 26);
		panel.add(textField_1);
		
		Label label_5 = new Label("Kcal por por\u00E7\u00E3o");
		label_5.setBounds(159, 269, 120, 24);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 299, 105, 26);
		panel.add(textField_2);
		
		Label label_6 = new Label("Medida Caseira");
		label_6.setBounds(316, 145, 127, 24);
		panel.add(label_6);
		
		Choice choice_3 = new Choice();
		choice_3.setEnabled(false);
		choice_3.setBounds(316, 175, 173, 26);
		panel.add(choice_3);
		
		Label label_7 = new Label("Carb. por por\u00E7\u00E3o");
		label_7.setBounds(316, 269, 133, 24);
		panel.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(316, 299, 105, 26);
		panel.add(textField_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 352, 115, 29);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Novo Alimento", null, panel_1, null);
		panel_1.setLayout(null);
		
		Label label_8 = new Label("Nome");
		label_8.setBounds(15, 10, 202, 24);
		panel_1.add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(15, 40, 289, 26);
		panel_1.add(textField_4);
		
		Label label_9 = new Label("Categoria");
		label_9.setBounds(15, 72, 202, 24);
		panel_1.add(label_9);
		
		Choice choice_4 = new Choice();
		choice_4.setEnabled(false);
		choice_4.setBounds(15, 102, 289, 26);
		panel_1.add(choice_4);
		
		Label label_10 = new Label("Peso da por\u00E7\u00E3o");
		label_10.setBounds(15, 134, 120, 24);
		panel_1.add(label_10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(15, 164, 105, 26);
		panel_1.add(textField_5);
		
		JButton button_3 = new JButton("Salvar");
		button_3.setBounds(15, 217, 115, 29);
		panel_1.add(button_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(164, 164, 105, 26);
		panel_1.add(textField_6);
		
		Label label_11 = new Label("Kcal por por\u00E7\u00E3o");
		label_11.setBounds(164, 134, 120, 24);
		panel_1.add(label_11);
		
		Label label_12 = new Label("Carb. por por\u00E7\u00E3o");
		label_12.setBounds(321, 134, 133, 24);
		panel_1.add(label_12);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(321, 164, 105, 26);
		panel_1.add(textField_7);
		
		Label label_13 = new Label("Medida Caseira");
		label_13.setBounds(321, 10, 127, 24);
		panel_1.add(label_13);
		
		Choice choice_5 = new Choice();
		choice_5.setEnabled(false);
		choice_5.setBounds(321, 40, 173, 26);
		panel_1.add(choice_5);
	}
}
