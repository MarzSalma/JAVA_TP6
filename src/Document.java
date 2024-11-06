public class Document {
    protected String titre;
    protected int numid;
    protected int nbpage;

    public Document(String titre, int numid, int nbpage) {
        this.titre = titre;
        this.numid = numid;
        this.nbpage = nbpage;
    }

    public void Edition() {
        System.out.println("titre" + titre + "numero d'identification" + numid + "nombre de page" + nbpage);
    }
}
    class Article extends Document {
        private String nom_auteur;

        public Article(String titre, int numid, int nbpage, String nom_auteur) {
            super(titre, numid, nbpage);
            this.nom_auteur = nom_auteur;
        }

        public String getNom_auteur() {
            return this.nom_auteur;
        }

        public void Edition() {
            super.Edition();
            System.out.println("Nom d'auteur:" + nom_auteur);
        }
    }

    class Livre extends Article {
        private String nom_editeur;

        public Livre(String titre, int numid, int nbpage, String nom_auteur, String nom_editeur) {
            super(titre, numid, nbpage, nom_auteur);
            this.nom_editeur = nom_editeur;
        }

        public String getNom_editeur() {
            return this.nom_editeur;
        }

        public void Edition() {
            super.Edition();
            System.out.println("Nom de l'editeur" + nom_editeur);
        }
    }

    class Periodiques extends Document {
        private int frequence;

        public Periodiques(String titre, int numid, int nbpage, int frequence) {
            super(titre, numid, nbpage);
            System.out.println("La frequence de parution" + frequence);
        }

        public int getfrequence() {
            return this.frequence;
        }

        public void Edition() {
            super.Edition();
            System.out.println("La frequence de parution" + frequence);
        }
    }

    class Bibliotheque {
        public  Document[] listDoc;
        private int nbDoc = 0;
        private int capacite;

        public Bibliotheque(int capacite) {
            this.capacite = capacite;
            listDoc = new Document[capacite];
        }

        int getCapacite() {
            return this.capacite;
        }

        void ajoutDoc(Document D) {
            if (nbDoc < capacite) {
                listDoc[nbDoc] = D;
                nbDoc++;
                for (int i = 0; i < nbDoc; i++) {
                    for (int j = i + 1; j < nbDoc; j++) {
                        if (listDoc[i].numid < listDoc[j].numid) {
                            Document x = listDoc[i];
                            listDoc[j] = listDoc[i];
                            listDoc[i] = x;
                        }
                    }
                }
            } else {
                System.out.println("La Capacite atteinte" + capacite);
            }
        }

        void Supprim_doc(int num) {
            boolean test = false;
            int i = 0;
            while (i < nbDoc) {
                if (listDoc[i].numid == num) {
                    for (int j = i; j < nbDoc - 1; j++) {
                        listDoc[j] = listDoc[j + 1];
                    }
                    nbDoc--;
                    test = true;
                    break;
                } else {
                    i++;
                }
                if (!test) {
                    System.out.println("Document non trouvé");
                }
            }
        }

        public int getNombre_doc() {
            return nbDoc;
        }

        Bibliotheque liste_livre() {
            Bibliotheque livres = new Bibliotheque(capacite);
            for (int i = 0; i < nbDoc; i++) {
                Document D = listDoc[i];
                if (D instanceof Livre) {
                    livres.ajoutDoc(D);
                }
            }
            return livres;
        }

        Bibliotheque liste_article() {
            Bibliotheque articles = new Bibliotheque(capacite);
            for (int i = 0; i < nbDoc; i++) {
                Document D = listDoc[i];
                if (D instanceof Article) {
                    articles.ajoutDoc(D);
                }
            }
            return articles;

        }

        Bibliotheque liste_docsimples() {
            Bibliotheque docsimple = new Bibliotheque(nbDoc);
            for (int i = 0; i < nbDoc; i++) {
                Document D = listDoc[i];
                if (D instanceof Document) {
                    docsimple.ajoutDoc(D);
                }
            }
            return docsimple;
        }

        Bibliotheque liste_periodique() {
            Bibliotheque periodiques = new Bibliotheque(nbDoc);
            for (int i = 0; i < nbDoc; i++) {
                Document D = listDoc[i];
                if (D instanceof Periodiques) {
                    periodiques.ajoutDoc(D);
                }
            }
            return periodiques;
        }
}



