public class TestBibliotheque {
    public static void main(String[] args) {
        Bibliotheque b = new Bibliotheque(10);
        Livre l1 = new Livre("A" , 101, 500, "E", "H");
        Livre l2 = new Livre("B", 102, 350, "F", "K");
        Article ar1 = new Article("C", 201, 15, "G");
        Periodiques per1 = new Periodiques("D", 301, 60, 12);

        b.ajoutDoc(l1);
        b.ajoutDoc(l2);
        b.ajoutDoc(ar1);
        b.ajoutDoc(per1);
        int b1 =  b.getNombre_doc();
        System.out.println("Nombre de documents dans la bibliothèque : " +b);

        Bibliotheque livres = b.liste_livre();
        System.out.println("Livres dans la bibliothèque :");
        for (int i = 0; i < livres.getNombre_doc(); i++) {
            livres.listDoc[i].Edition();
        }

        Bibliotheque articles = b.liste_article();
        System.out.println("\nArticles dans la bibliothèque :");
        for (int i = 0; i < articles.getNombre_doc(); i++) {
            articles.listDoc[i].Edition();
        }

        Bibliotheque periodiques = b.liste_periodique();
        System.out.println("\nPériodiques dans la bibliothèque :");
        for (int i = 0; i < periodiques.getNombre_doc(); i++) {
            periodiques.listDoc[i].Edition();
        }

        b.Supprim_doc(101);
        System.out.println("\nAprès suppression du document avec ID 101:");
        System.out.println("Nombre de documents dans la bibliothèque : " + b.getNombre_doc());

        livres = b.liste_livre();
        System.out.println("\nLivres dans la bibliothèque après suppression :");
        for (int i = 0; i < livres.getNombre_doc(); i++) {
            livres.listDoc[i].Edition();
        }
    }
}
