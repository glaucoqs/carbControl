package carbControl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Categoria extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categoria frame = new Categoria();
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
	public Categoria() {
		setTitle("Gerenciar Categorias");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 517, 169);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		tabbedPane.addTab("Editar Categoria", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 40, 212, 26);
		panel.add(comboBox);
		
		Label label = new Label("Categorias");
		label.setBounds(10, 10, 202, 24);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 84, 212, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(250, 83, 115, 29);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nova Categoria", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(8, 48, 217, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(250, 47, 115, 29);
		panel_1.add(btnAdicionar);
		
		Label label_1 = new Label("Nova Categoria");
		label_1.setBounds(8, 10, 200, 24);
		panel_1.add(label_1);
	}
}
