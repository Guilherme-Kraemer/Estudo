public abstract class Personagem {
    private String nome;
    private String nomeVidaReal;
    private Superpoder[] superpoderes;
    private int contadorSuperpoderes;

    public Personagem(String nome, String nomeVidaReal) {
        this.nome = nome;
        this.nomeVidaReal = nomeVidaReal;
        this.superpoderes = new Superpoder[5];
        // Pra caso precise iniciar:
        // for (int i = 0; i < 5; i++) {
        //     this.superpoderes[i] = new Superpoder(...);
        // }
    }

    public String getNome() {
        return nome;
    }

    public String getNomeVidaReal() {
        return nomeVidaReal;
    }

    public int getPoderTotal() {
        int total = 0;
        for (int i = 0; i < contadorSuperpoderes; i++) {
            total += superpoderes[i].getCategoria();
        }
        return total;
    }

    public Superpoder getSuperpoder(int indice) {
        return this.superpoderes[indice];
    }

    public boolean adicionarSuperpoder(Superpoder superpoder) {
        if (contadorSuperpoderes < superpoderes.length) {
            superpoderes[contadorSuperpoderes] = superpoder;
            contadorSuperpoderes++;
            return true;
        }
        return false;
    }
}
