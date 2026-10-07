class Cadeia {
    private static Cadeia instancia;
    private int capacidade;
    private Prisioneiro[] prisioneiros;
    private int contadorPrisioneiros;
    
    private Cadeia() {
        contadorPrisioneiros = 0;
    }
    
    public static Cadeia getInstancia() {
        if (instancia == null) {
            instancia = new Cadeia();
        }
        return instancia;
    }
    
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
        this.prisioneiros = new Prisioneiro[capacidade];
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    
    public boolean adicionarPrisioneiro(Prisioneiro prisioneiro) {
        if (contadorPrisioneiros < capacidade) {
            prisioneiros[contadorPrisioneiros] = prisioneiro;
            contadorPrisioneiros++;
            return true;
        }
        return false;
    }
    
    public boolean removerPrisioneiro(Prisioneiro prisioneiro) {
        for (int i = 0; i < contadorPrisioneiros; i++) {
            if (prisioneiros[i] == prisioneiro) {
                prisioneiros[i] = null;
                // Reorganiza o array
                for (int j = i; j < contadorPrisioneiros - 1; j++) {
                    prisioneiros[j] = prisioneiros[j + 1];
                }
                prisioneiros[contadorPrisioneiros - 1] = null;
                contadorPrisioneiros--;
                return true;
            }
        }
        return false;
    }
    
    public int removerTodos() {
        int removidos = contadorPrisioneiros;
        for (int i = 0; i < contadorPrisioneiros; i++) {
            prisioneiros[i] = null;
        }
        contadorPrisioneiros = 0;
        return removidos;
    }
    
    public void mostrarPrisioneiros() {
        System.out.println("Prisioneiros na cadeia:");
        for (int i = 0; i < contadorPrisioneiros; i++) {
            if (prisioneiros[i] != null) {
                System.out.println("Nome: " + prisioneiros[i].getNomePrisioneiro());
            }
        }
    }
}