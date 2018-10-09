package carbControl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.sql.SQLException;
import java.util.List;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Categoria extends JFrame {
	
	private JPanel contentPane;
	private JTextField txt_nova_cat;
	private JTextField textField_1;
	public static List<Object> categoria;
	private String nomeCatAntiga;
	private String nomeCatNova;
	private String novaCategoria = "";

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
		setBounds(100, 100, 544, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 539, 196);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(null);
		tabbedPane.addTab("Editar Categoria", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		
		Choice comboBox = new Choice();
		
		
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBox.removeAll();
				
				try {
					categoria  = iniciaAplicacao.executaSelect(iniciaAplicacao.conectaBancoDeDados(), "SELECT * FROM categoria order by nome");
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
				
				for (Object categorias : categoria) {
					comboBox.add(categorias.toString());									//Carrega lista das Categorias.
					}	
				if (comboBox.getSelectedItem() != null){
				}
			}
			
		});
		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				
				textField_1.setText("");
				textField_1.setText(comboBox.getSelectedItem());	
				nomeCatAntiga = comboBox.getSelectedItem();
			}
		});
				
		
				
		
		
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nomeCatNova = textField_1.getText();
				
				
				StringBuffer strBuf = new StringBuffer();
				strBuf.append("UPDATE `carbcontrol`.`categoria` SET `nome` = '");
				strBuf.append(nomeCatNova);												//Concatenação fomando codigo select do mySQL.
				strBuf.append("' WHERE (`nome` = '");
				strBuf.append(nomeCatAntiga);
				strBuf.append("');");
				String updateBd = strBuf.toString();
				
				try {
					iniciaAplicacao.executaUpdate(iniciaAplicacao.conectaBancoDeDados(), updateBd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comboBox.removeAll();
				textField_1.setText("");
			}
		});
		btnSalvar.setBounds(250, 83, 115, 29);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nova Categoria", null, panel_1, null);
		panel_1.setLayout(null);
		
		txt_nova_cat = new JTextField();
		txt_nova_cat.setBounds(8, 48, 217, 26);
		panel_1.add(txt_nova_cat);
		txt_nova_cat.setColumns(10);
		
		JButton btnAdicionar_cat = new JButton("Adicionar");
		btnAdicionar_cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novaCategoria = txt_nova_cat.getText();	
				System.out.println(novaCategoria);
				if (txt_nova_cat.getText().length() == 0){
						JOptionPane.showMessageDialog(null, "Digite um nome para a Categoria!");
				}else {
						JOptionPane.showMessageDialog(null, "Categoria adicionada!");
				}
				
				StringBuffer strBuf = new StringBuffer();
				strBuf.append("INSERT INTO `carbcontrol`.`categoria` (`nome`) VALUES ('");
				strBuf.append(novaCategoria);												//Concatenação fomando codigo select do mySQL.
				strBuf.append("');");
				String insertBd = strBuf.toString();
				try {
					iniciaAplicacao.executaInsert(iniciaAplicacao.conectaBancoDeDados(), insertBd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txt_nova_cat.requestFocus();
				txt_nova_cat.setText("");
			}
		});
		btnAdicionar_cat.setBounds(250, 47, 115, 29);
		panel_1.add(btnAdicionar_cat);
		
		Label label_1 = new Label("Nova Categoria");
		label_1.setBounds(8, 10, 200, 24);
		panel_1.add(label_1);
	}
}
