package br.com.cotacaoDeMoedas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import br.com.cotacaoDeMoedas.controller.ControllerCotacao;
import br.com.cotacaoDeMoedas.model.Moeda;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	public JTextField txtValorMoeda;
	private JTextField txtCotacao;
	private JTextField txtFonte;
	
	private ControllerCotacao controller;
	
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormPrincipal frame = new FormPrincipal();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	

	
	public FormPrincipal() {
		
		try {
			controller = new ControllerCotacao();
			controller.carregarBd();
		} catch (JSONException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o BD" + e1.getMessage());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(431, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Centraliza o form
		setLocationRelativeTo(null);		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 405, 40);
		panel.setBackground(new Color(51, 153, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COTAÇÃO DE MOEDAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 191, 23);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(5, 56, 112, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImgMoeda = new JLabel("Imagem\n da\n Moeda");
		lblImgMoeda.setBounds(10, 11, 92, 115);
		panel_1.add(lblImgMoeda);
		lblImgMoeda.setBackground(SystemColor.controlLtHighlight);
		lblImgMoeda.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMoeda = new JLabel("Moeda:");
		lblMoeda.setBounds(127, 62, 64, 14);
		contentPane.add(lblMoeda);
		
		JLabel lblCotao = new JLabel("Cota\u00E7\u00E3o:");
		lblCotao.setBounds(127, 122, 64, 14);
		contentPane.add(lblCotao);
		
		JLabel lblFonte = new JLabel("Fonte:");
		lblFonte.setBounds(127, 179, 64, 14);
		contentPane.add(lblFonte);
		
		txtValorMoeda = new JTextField();
		txtValorMoeda.setEnabled(false);
		txtValorMoeda.setBounds(201, 59, 209, 20);
		contentPane.add(txtValorMoeda);
		txtValorMoeda.setColumns(10);
		
		txtCotacao = new JTextField();
		txtCotacao.setEnabled(false);
		txtCotacao.setBounds(201, 119, 210, 20);
		contentPane.add(txtCotacao);
		txtCotacao.setColumns(10);
		
		txtFonte = new JTextField();
		txtFonte.setEnabled(false);
		txtFonte.setBounds(201, 173, 209, 20);
		contentPane.add(txtFonte);
		txtFonte.setColumns(10);
		
		JComboBox cbxMoeda = new JComboBox();
		cbxMoeda.setModel(new DefaultComboBoxModel(new String[] {"Dolar", "Euro", "Peso Argentino", "Libra Esterlina", "Bitcoin"}));
		cbxMoeda.setBounds(90, 238, 112, 31);
		contentPane.add(cbxMoeda);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			//Ação ao clicar no botão de pesquisa
			public void actionPerformed(ActionEvent arg0) {
				
				int indexMoeda = cbxMoeda.getSelectedIndex();			
				
				try {
					Object moeda = controller.pesquisar(indexMoeda);
					
					System.out.println(moeda);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				

			}
		});
		btnPesquisar.setBounds(212, 237, 112, 32);
		contentPane.add(btnPesquisar);
	}
}
