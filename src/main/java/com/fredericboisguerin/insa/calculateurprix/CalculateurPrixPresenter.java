package com.fredericboisguerin.insa.calculateurprix;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComputeButtonClicked(String montantArticleAsText, String quantiteArticleAsText) {
        float montantArticleAsFloat = Float.parseFloat(montantArticleAsText);
        int quantiteArticleAsInt = Integer.parseInt(quantiteArticleAsText);

        float montantHTAsFloat = montantArticleAsFloat * quantiteArticleAsInt;

        String montantHTAsText = String.valueOf(montantHTAsFloat);

        calculateurPrixView.afficherMontantHorsTaxe(montantHTAsText);

        calculateurPrixView.afficherErreur(montantHTAsText);





    }
}
