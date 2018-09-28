package carbControl;

import java.awt.Button;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class iniciaAplicacao {
public static int razaoIC;
public static List<Object> categoria;
public static List<Object> alimento;
public static List<Object> medida_caseira;
public static String categoria_escolhida;
public static String alimento_escolhido;
public static String quantidade_escolhida;
public static String alimento_quantidade;
public static float porcao;
public static float total_carb;
public static float total_insulina;

public static Connection conectaBancoDeDados() throws SQLException {
	Connection conexao = null;
	conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/carbcontrol?useTimezone=true&serverTimezone=UTC", "root", "root1234");    //Conexão so BD MySQL;
	return conexao;
}

public static List<Object> executaSelect(Connection conexao, String query) throws SQLException {
	ArrayList<Object> retorno = new ArrayList<Object>();
	PreparedStatement ps = conexao.prepareStatement(query);
	ResultSet rs = ps.executeQuery();																					//Select BD MySQL (Retorno de Objetos);
	while(rs.next()){
		retorno.add(rs.getObject(2));
	}
	return retorno;		
}

public static float executaSelect2(Connection conexao, String query) throws SQLException {
	float retorno = 0;
	PreparedStatement ps = conexao.prepareStatement(query);
	ResultSet rs = ps.executeQuery();																					//Select BD MySQL (Retorno de float);
	while(rs.next()){
		retorno=(float) (rs.getObject(2));
	}
	return retorno;		
}



public static void executaUpdate(Connection conexao, String query) throws SQLException {
	PreparedStatement ps = conexao.prepareStatement(query);
	ps.executeUpdate(query);																					//Update BD MySQL;	
}









//Método Main;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {				
					janelaPrincipal();
					frmCarbcontrolControle.setVisible(true);
			}	
		});
}
	
static JFrame frmCarbcontrolControle;
	
//Conteúdo da Janela;

	public static void janelaPrincipal() {
		
		ImageIcon imgicon = new ImageIcon("src/imagens/carbcontrol.png");
		
		
		frmCarbcontrolControle = new JFrame();
		frmCarbcontrolControle.setResizable(false);
		frmCarbcontrolControle.setTitle("carbControl - Controle de Carboidratos");
		frmCarbcontrolControle.setBounds(600, 200, 490, 567);
		frmCarbcontrolControle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarbcontrolControle.setIconImage(imgicon.getImage());
	
		JMenuBar barra_menu = new JMenuBar();
		frmCarbcontrolControle.setJMenuBar(barra_menu);						//Barra de Menus;
		
		JMenu menu_Arquivo = new JMenu("Arquivo");
		barra_menu.add(menu_Arquivo);
		
		JMenuItem mntmGerenciarAlimentos = new JMenuItem("Gerenciar Alimentos");
		mntmGerenciarAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alimento.main(null);
				
			}
		});
		menu_Arquivo.add(mntmGerenciarAlimentos);
		
		JMenuItem mntmGerenciarCategorias = new JMenuItem("Gerenciar Categorias");
		mntmGerenciarCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categoria.main(null);
			}
		});
		menu_Arquivo.add(mntmGerenciarCategorias);
		
		JMenuItem menu_botao_GerenciarUsuarios = new JMenuItem("Gerenciar Usu\u00E1rios");
		menu_botao_GerenciarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.main(null);
			}
		});
		menu_Arquivo.add(menu_botao_GerenciarUsuarios);
		
		JMenuItem menu_botao_Sair = new JMenuItem("Sair");
		menu_Arquivo.add(menu_botao_Sair);									//Arquivo -- Sair;
		
		menu_botao_Sair.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent arg0) {  
               System.exit(0);
            }  
        });
		
		JMenu menu_Ajuda = new JMenu("Ajuda");								//Ajuda;
		barra_menu.add(menu_Ajuda);
		
		JMenuItem menu_botao_Sobre = new JMenuItem("Sobre...");
		menu_Ajuda.add(menu_botao_Sobre);
		frmCarbcontrolControle.getContentPane().setLayout(null);                        //Ajuda --- Caixa de diálogo "Sobre"
				
		Choice escolha_categoria = new Choice();
		escolha_categoria.setEnabled(false);
		escolha_categoria.setBounds(10, 124, 289, 22);
		frmCarbcontrolControle.getContentPane().add(escolha_categoria);
		
		Choice escolha_alimento = new Choice();
		escolha_alimento.setEnabled(false);
		escolha_alimento.setBounds(10, 182, 289, 22);
		frmCarbcontrolControle.getContentPane().add(escolha_alimento);
		
		Label label_categoria = new Label("Categoria do Alimento");
		label_categoria.setBounds(10, 97, 202, 24);
		frmCarbcontrolControle.getContentPane().add(label_categoria);
		
		Label label_alimento = new Label("Alimento");
		label_alimento.setBounds(10, 152, 202, 24);
		frmCarbcontrolControle.getContentPane().add(label_alimento);
		
		Label label_razao = new Label("Raz\u00E3o Insulina/Carboidratos (I/C)");
		label_razao.setBounds(10, 20, 202, 24);
		frmCarbcontrolControle.getContentPane().add(label_razao);
		
		TextField entrada_razao_ic = new TextField();
		entrada_razao_ic.setBounds(10, 50, 46, 24);
		frmCarbcontrolControle.getContentPane().add(entrada_razao_ic);
						
		Label label_exemplo = new Label("Ex: 15");
		label_exemplo.setBounds(62, 50, 46, 24);
		frmCarbcontrolControle.getContentPane().add(label_exemplo);
		
		Label label_medida_caseira = new Label("Medida Caseira");
		label_medida_caseira.setBounds(10, 210, 202, 24);
		frmCarbcontrolControle.getContentPane().add(label_medida_caseira);
		
		Choice escolha_quantidade = new Choice();
		escolha_quantidade.setEnabled(false);
		escolha_quantidade.setBounds(10, 240, 116, 22);
		frmCarbcontrolControle.getContentPane().add(escolha_quantidade);
		
		Label label_itens = new Label("Itens Adicionados:");
		label_itens.setBounds(10, 285, 202, 24);
		frmCarbcontrolControle.getContentPane().add(label_itens);
		
		Label label_insulina = new Label("Unidades de Insulina a ser aplicada:");
		label_insulina.setBounds(226, 359, 223, 24);
		frmCarbcontrolControle.getContentPane().add(label_insulina);
		
		Label label_unidades = new Label("");
		label_unidades.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		label_unidades.setBounds(236, 389, 213, 47);
		frmCarbcontrolControle.getContentPane().add(label_unidades);
		
		JButton botao_sair = new JButton("Sair");
		botao_sair.setBounds(133, 454, 79, 25);
		frmCarbcontrolControle.getContentPane().add(botao_sair);
			
		JButton botaook_categoria = new JButton("Ok");
		botaook_categoria.setEnabled(false);
		botaook_categoria.setBounds(316, 124, 57, 22);
		frmCarbcontrolControle.getContentPane().add(botaook_categoria);
		
		JButton botaook_alimento = new JButton("Ok");
		botaook_alimento.setEnabled(false);
		botaook_alimento.setBounds(316, 182, 57, 22);
		frmCarbcontrolControle.getContentPane().add(botaook_alimento);
		
		Button botao_calcular = new Button("Calcular");
		botao_calcular.setEnabled(false);
		botao_calcular.setBounds(226, 329, 79, 24);
		frmCarbcontrolControle.getContentPane().add(botao_calcular);
				
		JSpinner spinner_quantidade = new JSpinner();
		spinner_quantidade.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(10), new Float(1)));
		spinner_quantidade.setEnabled(false);
		spinner_quantidade.setBounds(141, 240, 39, 20);
		frmCarbcontrolControle.getContentPane().add(spinner_quantidade);
		
		JButton botao_adicionar = new JButton("Adicionar");
		botao_adicionar.setEnabled(false);
		botao_adicionar.setBounds(191, 240, 93, 22);
		frmCarbcontrolControle.getContentPane().add(botao_adicionar);
		
		java.awt.List lista_total = new java.awt.List();
		lista_total.setBounds(10, 315, 202, 121);
		frmCarbcontrolControle.getContentPane().add(lista_total);
		
		JButton botaook_razaoIC = new JButton("Ok");
		botaook_razaoIC.setToolTipText("");
		botaook_razaoIC.setBounds(114, 50, 57, 22);
		frmCarbcontrolControle.getContentPane().add(botaook_razaoIC);
		
		Button botao_zerar = new Button("Limpar");
		botao_zerar.setBounds(10, 454, 79, 24);
		frmCarbcontrolControle.getContentPane().add(botao_zerar);
		
		botao_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df =  new DecimalFormat("0.0");
				total_insulina = total_carb/razaoIC;
				label_unidades.setVisible(true);
				label_unidades.setText(String.valueOf(String.valueOf(df.format(total_insulina)) + " Unidade(s)"));
			}
		});

		botao_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lista_alimento = alimento_quantidade;
				StringBuffer strBuf = new StringBuffer();
				strBuf.append("select carbcontrol.alimento.idalimento, carbcontrol.alimento.carb_porcao  from carbcontrol.alimento  where alimento.nome = '");
				strBuf.append(alimento_quantidade);												//Concatenação fomando codigo select do mySQL.
				strBuf.append("';");
				alimento_escolhido = strBuf.toString();
								
						try {
							porcao = executaSelect2(conectaBancoDeDados(),alimento_escolhido);
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					
					total_carb = total_carb + (porcao *(float)spinner_quantidade.getValue());
					botao_calcular.setEnabled(true);				
					entrada_razao_ic.setEnabled(false);
					botaook_razaoIC.setEnabled(false);
					escolha_categoria.requestFocus();
					escolha_alimento.removeAll();
					escolha_alimento.setEnabled(false);
					botaook_alimento.setEnabled(false);
					escolha_quantidade.removeAll();
					escolha_quantidade.setEnabled(false);
					spinner_quantidade.setEnabled(false);
					botao_adicionar.setEnabled(false);
					lista_total.add(lista_alimento);
					lista_alimento = "";
			}
		});
		
		botao_sair.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent arg0) {  
               System.exit(0);
            }  
        });
	
		botaook_razaoIC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					do{
						razaoIC = Integer.parseInt(entrada_razao_ic.getText());	
						if (razaoIC <= 0 || razaoIC >25){
							JOptionPane.showMessageDialog(null, "Digite um número entre 1 e 25!");
							entrada_razao_ic.setText("");												//Validação de entrada Razão IC.
							entrada_razao_ic.requestFocus();
						}
					}while(razaoIC <= 0 || razaoIC >25);
								
				escolha_categoria.setEnabled(true);
				try {
					categoria  = executaSelect(conectaBancoDeDados(), "SELECT * FROM categoria order by nome");
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				escolha_categoria.removeAll();
				for (Object categorias : categoria) {
					escolha_categoria.add(categorias.toString());										//Carrega lista das Categorias.
					}	
				
				if (escolha_categoria.getSelectedItem() != null){
					botaook_categoria.setEnabled(true);
				}
			}
		});
		
		botaook_categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				categoria_escolhida = escolha_categoria.getSelectedItem();
													
				StringBuffer strBuf = new StringBuffer();
				strBuf.append("select carbcontrol.alimento.idalimento, carbcontrol.alimento.nome from carbcontrol.alimento join carbcontrol.categoria on (alimento.categoria_idcategoria = categoria.idcategoria) where categoria.nome = '");
				strBuf.append(categoria_escolhida);												//Concatenação fomando codigo select do mySQL.
				strBuf.append("';");
				categoria_escolhida = strBuf.toString();
				try {
					alimento = executaSelect(conectaBancoDeDados(), categoria_escolhida);			//Conecta novamente ao banco de dados e retorna os alimentos da categoria.
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				escolha_alimento.setEnabled(true);
				escolha_alimento.removeAll();
				for (Object alimentos : alimento) {
					escolha_alimento.add(alimentos.toString());										//Carrega lista dos Alimentos.
					}	
				
				if (escolha_alimento.getSelectedItem() != null){
					botaook_alimento.setEnabled(true);
				}
			}
		});
		
		botao_zerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada_razao_ic.setEnabled(true);
				entrada_razao_ic.setText("");
				entrada_razao_ic.requestFocus();
				botaook_razaoIC.setEnabled(true);
				escolha_categoria.removeAll();
				escolha_categoria.setEnabled(false);
				botaook_categoria.setEnabled(false);
				escolha_alimento.removeAll();
				escolha_alimento.setEnabled(false);
				botaook_alimento.setEnabled(false);
				escolha_quantidade.removeAll();
				escolha_quantidade.setEnabled(false);
				//spinner_quantidade.set
				spinner_quantidade.setEnabled(false);
				botao_adicionar.setEnabled(false);
				lista_total.removeAll();
				botao_calcular.setEnabled(false);
				label_unidades.setText("");
				label_unidades.setVisible(false);
				razaoIC = 0;
				total_carb = 0;
				porcao = 0;
				
			}
		});
		
		botaook_alimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				alimento_escolhido = escolha_alimento.getSelectedItem();		
				alimento_quantidade = alimento_escolhido;
				StringBuffer strBuf = new StringBuffer();
				strBuf.append("select carbcontrol.medida_caseira.idmedida_caseira, carbcontrol.medida_caseira.medida  from carbcontrol.alimento join carbcontrol.medida_caseira on (alimento.medida_caseira_idmedida_caseira = medida_caseira.idmedida_caseira)  where alimento.nome = '");
				strBuf.append(alimento_escolhido);												//Concatenação fomando codigo select do mySQL.
				strBuf.append("';");
				alimento_escolhido = strBuf.toString();
				
				try {
					medida_caseira = executaSelect(conectaBancoDeDados(), alimento_escolhido);		//Conecta novamente ao banco de dados e retorna os alimentos da categoria.
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}			
				
				escolha_quantidade.setEnabled(true);
				
				escolha_quantidade.removeAll();
				for (@SuppressWarnings("unused") Object quantidades : medida_caseira) {
					escolha_quantidade.add(medida_caseira.toString());										//Carrega lista das Quantidades.
					}	
				
				if (escolha_quantidade.getSelectedItem() != null){
					spinner_quantidade.setEnabled(true);
					botao_adicionar.setEnabled(true);
				}
			}
		});

		menu_botao_Sobre.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent arg0) { 
            	ImageIcon icon = new ImageIcon("src/imagens/carbcontrol.png");
            	JOptionPane.showMessageDialog( null, "Desenvolvido por: \n\n*Glauco Soares \n\n"
            			+ "Curso de Análise e Desenvolvimento de Sistemas - USJ", "Sobre carbControl", JOptionPane.INFORMATION_MESSAGE, icon);
            	
            }  
        });

	}	
	
	
}













