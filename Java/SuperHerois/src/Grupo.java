class Grupo {
    private int tamanho;
    private int vitorias;
    private Personagem[] integrantes;
    private int contadorIntegrantes;
    
    public Grupo(int tamanho) {
        this.tamanho = tamanho;
        this.vitorias = 0;
        this.integrantes = new Personagem[tamanho];
        this.contadorIntegrantes = 0;
    }
    
    public void adicionarVitoria() {
        vitorias++;
    }
    
    public boolean adicionarIntegrante(Personagem integrante) {
        if (contadorIntegrantes < tamanho) {
            integrantes[contadorIntegrantes] = integrante;
            contadorIntegrantes++;
            return true;
        }
        return false;
    }
    
    public boolean removerIntegrante(Personagem integrante) {
        for (int i = 0; i < contadorIntegrantes; i++) {
            if (integrantes[i] == integrante) {
                integrantes[i] = null;
                // Reorganiza o array
                for (int j = i; j < contadorIntegrantes - 1; j++) {
                    integrantes[j] = integrantes[j + 1];
                }
                integrantes[contadorIntegrantes - 1] = null;
                contadorIntegrantes--;
                return true;
            }
        }
        return false;
    }
    
    public Personagem getIntegrante(int indice) {
        if (indice >= 0 && indice < contadorIntegrantes) {
            return integrantes[indice];
        }
        return null;
    }
    
    public int getVitorias() {
        return vitorias;
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public void mostrarIntegrantes() {
        System.out.println("Integrantes do grupo:");
        for (int i = 0; i < contadorIntegrantes; i++) {
            if (integrantes[i] != null) {
                System.out.println("Nome: " + integrantes[i].getNome() + 
                                 ", Poder Total: " + integrantes[i].getPoderTotal());
            }
        }
    }
}