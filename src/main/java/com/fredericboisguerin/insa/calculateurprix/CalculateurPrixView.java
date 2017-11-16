package com.fredericboisguerin.insa.calculateurprix;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CalculateurPrixView extends JFrame {

    private final CalculateurPrixPresenter presenter;

    private JLabel prixArticleLabel = new JLabel("Prix d'un article (€) : ");
    private JTextField prixArticleTextField = new JTextField(10);

    private JLabel nombreArticleLabel = new JLabel("Quantité : ");
    private JTextField nombreArticleTextField = new JTextField(10);

    private JLabel montantHTLabel = new JLabel("Montant HT : ");
    private JFormattedTextField montantHTTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());

    private JLabel montantTTCLabel = new JLabel("Montant TTC : ");
    private JFormattedTextField montantTTCTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());

    private JLabel paysLabel = new JLabel("Pays");
    private JComboBox<String> paysCombo;

    private JButton computeButton = new JButton("Calculer");

    private JPanel contentPane = new JPanel();

    private JPanel labelPane = new JPanel();
    private GridLayout labelPaneGridLayout = new GridLayout(0, 1);

    private JPanel fieldPane = new JPanel();
    private GridLayout fieldPaneGridLayout = new GridLayout(0, 1);



    public CalculateurPrixView() throws HeadlessException {
        super("Calculateur de prix");
        this.presenter = new CalculateurPrixPresenter(this);

        prixArticleLabel.setLabelFor(prixArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici le montant d'un article");


        nombreArticleLabel.setLabelFor(nombreArticleTextField);
        nombreArticleTextField.setToolTipText("Entrez ici la quantité d'article voulue ");


        String[] pays = {"Belgique","Danemark","Allemagne","Grèce","Espagne","France","Irlande","Italie","Chypre","Luxenbourg","Pays_Bas","Autriche","Portugal","Suède"};
        paysLabel.setLabelFor(paysCombo);
        paysCombo = new JComboBox<>(pays);
        paysCombo.setToolTipText("Sélectionnez ici le pays de votre achat");
        paysCombo.setSelectedIndex(5);


        montantHTTextField.setValue(0);
        montantHTTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantHTTextField);

        montantTTCTextField.setValue(0);
        montantTTCTextField.setEditable(false);
        montantTTCLabel.setLabelFor(montantTTCTextField);





        computeButton.addActionListener(e -> this.presenter.onComputeButtonClicked(prixArticleTextField.getText(), nombreArticleTextField.getText(), paysCombo.getItemAt(paysCombo.getSelectedIndex())));

        setContentPane(contentPane);

        labelPaneGridLayout.setHgap(5);
        fieldPaneGridLayout.setHgap(5);

        labelPane.setLayout(labelPaneGridLayout);
        fieldPane.setLayout(fieldPaneGridLayout);


        labelPane.add(prixArticleLabel);
        labelPane.add(nombreArticleLabel);
        labelPane.add(paysLabel);
        labelPane.add(montantHTLabel);
        labelPane.add(montantTTCLabel);



        fieldPane.add(prixArticleTextField);
        fieldPane.add(nombreArticleTextField);
        fieldPane.add(paysCombo);
        fieldPane.add(montantHTTextField);
        fieldPane.add(montantTTCTextField);

        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, WEST);
        add(fieldPane, EAST);
        add(computeButton, SOUTH);

        prixArticleTextField.requestFocus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void afficherErreur(String message) {
        showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
    }

    public void afficherMontantHorsTaxe(float leMontantHTAsFloat){

        montantHTTextField.setValue(leMontantHTAsFloat);

    }

    public void afficherMontantTouteTaxeComprise(float leMontantTTCAsFloat){

        montantTTCTextField.setValue(leMontantTTCAsFloat);

    }


    public void display() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
