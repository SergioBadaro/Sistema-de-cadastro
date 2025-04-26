package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela2 extends JFrame {

    private JLabel lblRenda;
    private JLabel lblSenha;
    private JLabel lblSexo;
    private JLabel lblHobbies;
    private JLabel lblEstado;
    private JLabel lblVolume;
    private JTextField txtNome, txtRenda;
    private JPasswordField txtSenha;
    private JButton btnSalvar, btnSair;
    private JCheckBox chkCinema, chkEsportes, chkLeitura;
    private JRadioButton radMasculino, radFeminino;
    private ButtonGroup grupoSexo;
    private JComboBox<String> comboEstados;
    private JList<String> listaOpcoes;
    private JSlider sliderVolume;
    private JMenuBar menuBar;
    private JMenu menuArquivo, menuEditar;

    public Tela2() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setTitle("Formulário Completo - Swing");

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 10, 80, 30);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(110, 10, 200, 30);
        add(txtNome);

        // Renda
        lblRenda = new JLabel("Renda:");
        lblRenda.setBounds(30, 50, 80, 30);
        add(lblRenda);

        txtRenda = new JTextField();
        txtRenda.setBounds(110, 50, 100, 30);
        add(txtRenda);

        // Senha
        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(30, 90, 80, 30);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(110, 90, 200, 30);
        add(txtSenha);

        // CheckBoxes
        lblHobbies = new JLabel("Hobbies:");
        lblHobbies.setBounds(30, 130, 100, 30);
        add(lblHobbies);

        chkCinema = new JCheckBox("Cinema");
        chkCinema.setBounds(110, 130, 100, 30);
        add(chkCinema);

        chkEsportes = new JCheckBox("Esportes");
        chkEsportes.setBounds(210, 130, 100, 30);
        add(chkEsportes);

        chkLeitura = new JCheckBox("Leitura");
        chkLeitura.setBounds(310, 130, 100, 30);
        add(chkLeitura);

        // Radio Buttons
        lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 170, 80, 30);
        add(lblSexo);

        radMasculino = new JRadioButton("Masculino");
        radMasculino.setBounds(110, 170, 100, 30);
        radFeminino = new JRadioButton("Feminino");
        radFeminino.setBounds(210, 170, 100, 30);

        grupoSexo = new ButtonGroup();
        grupoSexo.add(radMasculino);
        grupoSexo.add(radFeminino);

        add(radMasculino);
        add(radFeminino);

        // ComboBox
        lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 210, 80, 30);
        add(lblEstado);

        comboEstados = new JComboBox<>(new String[]{"SP", "RJ", "MG", "RS", "BA"});
        comboEstados.setBounds(110, 210, 100, 30);
        add(comboEstados);

        // JList
        listaOpcoes = new JList<>(new String[]{"Opção A", "Opção B", "Opção C"});
        JScrollPane scrollLista = new JScrollPane(listaOpcoes);
        scrollLista.setBounds(30, 250, 150, 80);
        add(scrollLista);

        // Slider
        lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(30, 340, 80, 30);
        add(lblVolume);

        sliderVolume = new JSlider(0, 100, 50);
        sliderVolume.setBounds(110, 340, 200, 50);
        add(sliderVolume);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 400, 100, 30);
        add(btnSalvar);

        btnSair = new JButton("Sair");
        btnSair.setBounds(140, 400, 100, 30);
        add(btnSair);

        btnSair.addActionListener(e -> System.exit(0));

        // Menu
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuEditar = new JMenu("Editar");
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela2 tela = new Tela2();
            tela.setVisible(true);
        });
    }
}
