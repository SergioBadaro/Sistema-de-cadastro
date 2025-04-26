package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Aplicativo extends JFrame implements ActionListener {

    private JPanel pnlCampos, pnlTabela, pnlBotoes, pnlNome, pnlTelefone, pnlCidade, pnlEmail, pnlCpf;
    private TitledBorder tituloPnlCampos, tituloPnlTabela, tituloPnlBotoes;
    private JLabel lblNome, lblTelefone, lblCidade, lblEmail, lblCpf;
    private JTextField txtNome, txtEmail;
    private JFormattedTextField txtTelefone, txtCpf;
    private MaskFormatter mskTelefone, mskCpf;
    private JComboBox<String> cmbCidades;
    private JTable tblClientes;
    private DefaultTableModel tblClientesModel;
    private JButton btnAdicionar, btnLimpar;

    public Aplicativo() {
        definirJanela();

        pnlCampos = new JPanel(new GridLayout(5, 1));
        tituloPnlCampos = BorderFactory.createTitledBorder("Cadastro de Clientes");
        pnlCampos.setBorder(tituloPnlCampos);

        pnlBotoes = new JPanel(new FlowLayout());
        tituloPnlBotoes = BorderFactory.createTitledBorder("Botões");
        pnlBotoes.setBorder(tituloPnlBotoes);

        pnlTabela = new JPanel(new BorderLayout());
        tituloPnlTabela = BorderFactory.createTitledBorder("Tabela de Dados");
        pnlTabela.setBorder(tituloPnlTabela);

        lblNome = new JLabel("Nome");
        lblTelefone = new JLabel("Telefone");
        lblCidade = new JLabel("Cidade");
        lblEmail = new JLabel("Email");
        lblCpf = new JLabel("CPF");

        txtNome = new JTextField(30);
        txtEmail = new JTextField(30);

        try {
            mskTelefone = new MaskFormatter("(##)#####-####");
            mskTelefone.setPlaceholderCharacter('_');
            txtTelefone = new JFormattedTextField(mskTelefone);

            mskCpf = new MaskFormatter("###.###.###-##");
            mskCpf.setPlaceholderCharacter('_');
            txtCpf = new JFormattedTextField(mskCpf);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro nas máscaras");
        }

        cmbCidades = new JComboBox<>(new String[]{
                "São Paulo", "Rio de Janeiro", "Campinas", "Belo Horizonte", "Curitiba",
                "Salvador", "Fortaleza", "Recife", "Porto Alegre", "Manaus"
        });

        pnlNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlNome.add(lblNome);
        pnlNome.add(txtNome);

        pnlTelefone = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlTelefone.add(lblTelefone);
        pnlTelefone.add(txtTelefone);

        pnlCidade = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCidade.add(lblCidade);
        pnlCidade.add(cmbCidades);

        pnlEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlEmail.add(lblEmail);
        pnlEmail.add(txtEmail);

        pnlCpf = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCpf.add(lblCpf);
        pnlCpf.add(txtCpf);

        pnlCampos.add(pnlNome);
        pnlCampos.add(pnlTelefone);
        pnlCampos.add(pnlCidade);
        pnlCampos.add(pnlEmail);
        pnlCampos.add(pnlCpf);

        btnAdicionar = new JButton("Adicionar à tabela");
        btnLimpar = new JButton("Limpar campos");

        btnAdicionar.addActionListener(this);
        btnLimpar.addActionListener(this);

        pnlBotoes.add(btnAdicionar);
        pnlBotoes.add(btnLimpar);

        String[] colunas = {"Nome", "Telefone", "Cidade", "Email", "CPF"};
        tblClientesModel = new DefaultTableModel(colunas, 0);
        tblClientes = new JTable(tblClientesModel);
        JScrollPane scrTabela = new JScrollPane(tblClientes);

        pnlTabela.add(scrTabela, BorderLayout.CENTER);

        add(pnlCampos, BorderLayout.NORTH);
        add(pnlBotoes, BorderLayout.CENTER);
        add(pnlTabela, BorderLayout.SOUTH);
    }

    private void definirJanela() {
        setTitle("Aplicação de Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre maximizado
        setLocationRelativeTo(null);              // Centralizado
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Aplicativo app = new Aplicativo();
            app.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdicionar) {
            String[] linha = {
                    txtNome.getText(),
                    txtTelefone.getText(),
                    cmbCidades.getSelectedItem().toString(),
                    txtEmail.getText(),
                    txtCpf.getText()
            };
            tblClientesModel.addRow(linha);
            JOptionPane.showMessageDialog(this, "Dados adicionados com sucesso!");
        } else if (e.getSource() == btnLimpar) {
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente limpar os campos?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
                txtCpf.setText("");
                cmbCidades.setSelectedIndex(0);
                txtNome.requestFocus();
            }
        }
    }
}
