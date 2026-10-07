public class Vilao extends Personagem implements Prisioneiro{
    public String getNomePrisioneiro(){
        return (super.getNome());
    }

    public Vilao(String nome, String nomeVidaReal){
        super (nome, nomeVidaReal);
    }
}
