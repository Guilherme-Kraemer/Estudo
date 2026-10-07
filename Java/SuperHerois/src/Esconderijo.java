public class Esconderijo {
    private int capacidade;
    private Personagem[] personagens;
    private int num_capacidade;

    public int getCapacidade() {
        return (this.capacidade);
    }

    public boolean adicionarPersonagem(Personagem personagem) {
        if (num_capacidade < capacidade) {
            personagens[num_capacidade] = personagem;
            num_capacidade++;
            return (true);
        }
        return (false);
    }

    public boolean removerPersonagem(Personagem personagem) {
        for (int x = 0; x < num_capacidade; x++) {
            if (personagem == personagens[x]) {
                personagens[x] = null;
                // Reorganiza o array
                for (int j = x; j < num_capacidade - 1; j++) {
                    personagens[j] = personagens[j + 1];
                }
                personagens[num_capacidade - 1] = null;
                num_capacidade--;
                return true;
            }
        }
        return (false);
    }

    public int removerTodos() {

        int j = 0;

        for (int x = 0; x < num_capacidade; x++) {
            personagens[x] = null;
            j++;
        }

        return (j);
    }

    public void mostrarPersonagens() {
        System.out.println("Personagens no esconderijo:");
        for (int i = 0; i < num_capacidade; i++) {
            if (personagens[i] != null) {
                System.out.println("Nome: " + personagens[i].getNome());
            }
        }
    }

    public Esconderijo(int capacidade) {
        this.capacidade = capacidade;
        personagens = new Personagem[capacidade];
        num_capacidade = 0;
    }
}
