package br.com.cotacaoDeMoedas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(381, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 356, 40);
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
		lblMoeda.setBounds(127, 62, 46, 14);
		contentPane.add(lblMoeda);
		
		JLabel lblCotao = new JLabel("Cota\u00E7\u00E3o:");
		lblCotao.setBounds(127, 122, 46, 14);
		contentPane.add(lblCotao);
		
		JLabel lblFonte = new JLabel("Fonte:");
		lblFonte.setBounds(127, 179, 46, 14);
		contentPane.add(lblFonte);
		
		textField = new JTextField();
		textField.setBounds(184, 59, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 119, 178, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 173, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox cbxMoeda = new JComboBox();
		cbxMoeda.setModel(new DefaultComboBoxModel(new String[] {"Dolar", "Euro", "Peso Argentino", "Libra Esterlina", "Bitcoin"}));
		cbxMoeda.setBounds(5, 225, 112, 20);
		contentPane.add(cbxMoeda);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisar.setBounds(127, 224, 89, 23);
		contentPane.add(btnPesquisar);
	}
}
