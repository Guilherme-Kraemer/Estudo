public class Jogo {
    public static void main(String[] args) {
        // Criar 4 super-heróis distintos
        SuperHeroi homemAranha = new SuperHeroi("Homem-Aranha", "Peter Park");
        homemAranha.adicionarSuperpoder(new Superpoder("soltar teia", 3));
        homemAranha.adicionarSuperpoder(new Superpoder("andar em paredes", 2));
        homemAranha.adicionarSuperpoder(new Superpoder("sentido apurado", 1));
        
        SuperHeroi superHomem = new SuperHeroi("Super-Homem", "Clark Kent");
        superHomem.adicionarSuperpoder(new Superpoder("voar", 3));
        superHomem.adicionarSuperpoder(new Superpoder("força", 5));
        superHomem.adicionarSuperpoder(new Superpoder("visão de raio X", 4));
        superHomem.adicionarSuperpoder(new Superpoder("sopro congelante", 4));
        
        SuperHeroi capitaoAmerica = new SuperHeroi("Capitão América", "Steven Rogers");
        capitaoAmerica.adicionarSuperpoder(new Superpoder("supersoldado", 3));
        capitaoAmerica.adicionarSuperpoder(new Superpoder("escudo", 3));
        
        SuperHeroi flash = new SuperHeroi("Flash", "Barry Allen");
        flash.adicionarSuperpoder(new Superpoder("velocidade", 5));
        
        // Adicionar super-heróis ao grupo liga
        Grupo liga = new Grupo(4);
        liga.adicionarIntegrante(homemAranha);
        liga.adicionarIntegrante(superHomem);
        liga.adicionarIntegrante(capitaoAmerica);
        liga.adicionarIntegrante(flash);
        
        // Criar 4 vilões distintos
        Vilao duendeVerde = new Vilao("Duende Verde", "Norman Osborne");
        duendeVerde.adicionarSuperpoder(new Superpoder("força", 5));
        
        Vilao lexLuthor = new Vilao("Lex Luthor", "Lex Luthor");
        lexLuthor.adicionarSuperpoder(new Superpoder("inteligência", 5));
        
        Vilao bizarro = new Vilao("Bizarro", "Bizarro");
        bizarro.adicionarSuperpoder(new Superpoder("voar", 3));
        bizarro.adicionarSuperpoder(new Superpoder("força", 5));
        bizarro.adicionarSuperpoder(new Superpoder("visão de raio X", 4));
        bizarro.adicionarSuperpoder(new Superpoder("sopro congelante", 4));
        
        Vilao octopus = new Vilao("Octopus", "Otto Octavius");
        octopus.adicionarSuperpoder(new Superpoder("tentáculos indestrutíveis", 5));
        octopus.adicionarSuperpoder(new Superpoder("velocidade", 1));
        
        // Adicionar vilões ao grupo horda
        Grupo horda = new Grupo(4);
        horda.adicionarIntegrante(duendeVerde);
        horda.adicionarIntegrante(lexLuthor);
        horda.adicionarIntegrante(bizarro);
        horda.adicionarIntegrante(octopus);
        
        // Confrontar cada super-herói com o correspondente vilão
        Confronto confronto = new Confronto();
        System.out.println("=== CONFRONTOS ===");
        
        for (int i = 0; i < 4; i++) {
            SuperHeroi heroi = (SuperHeroi) liga.getIntegrante(i);
            Vilao vilao = (Vilao) horda.getIntegrante(i);
            
            ResultadoConfronto resultado = confronto.executar(heroi, vilao);
            
            System.out.println("\nConfronto " + (i + 1) + ": " + heroi.getNome() + 
                             " (Poder: " + heroi.getPoderTotal() + ") vs " + 
                             vilao.getNome() + " (Poder: " + vilao.getPoderTotal() + ")");
            
            switch (resultado) {
                case superHeroiVencedor:
                    liga.adicionarVitoria();
                    System.out.println("Vencedor: " + heroi.getNome());
                    break;
                case vilaoVencedor:
                    horda.adicionarVitoria();
                    System.out.println("Vencedor: " + vilao.getNome());
                    break;
                case empate:
                    System.out.println("Resultado: Empate");
                    break;
            }
        }
        
        // Mostrar resultado final
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Liga - Vitórias: " + liga.getVitorias());
        System.out.println("Horda - Vitórias: " + horda.getVitorias());
        
        if (liga.getVitorias() > horda.getVitorias()) {
            System.out.println("\nGRUPO VENCEDOR: LIGA");
            liga.mostrarIntegrantes();
            
            // Horda derrotada - vilões para a cadeia
            Cadeia cadeia = Cadeia.getInstancia();
            cadeia.setCapacidade(10);
            System.out.println("\nTransferindo vilões para a cadeia...");
            for (int i = 0; i < 4; i++) {
                Vilao vilao = (Vilao) horda.getIntegrante(i);
                if (vilao != null) {
                    cadeia.adicionarPrisioneiro(vilao);
                }
            }
            cadeia.mostrarPrisioneiros();
            
        } else if (horda.getVitorias() > liga.getVitorias()) {
            System.out.println("\nGRUPO VENCEDOR: HORDA");
            horda.mostrarIntegrantes();
            
            // Horda venceu - vilões para esconderijo
            Esconderijo esconderijoViloes = new Esconderijo(10);
            System.out.println("\nMovendo vilões para esconderijo...");
            for (int i = 0; i < 4; i++) {
                Vilao vilao = (Vilao) horda.getIntegrante(i);
                if (vilao != null) {
                    esconderijoViloes.adicionarPersonagem(vilao);
                }
            }
            esconderijoViloes.mostrarPersonagens();
            
        } else {
            System.out.println("\nRESULTADO: EMPATE");
            System.out.println("Liga:");
            liga.mostrarIntegrantes();
            System.out.println("\nHorda:");
            horda.mostrarIntegrantes();
        }
        
        // Liga sempre vai para esconderijo
        Esconderijo esconderijoLiga = new Esconderijo(10);
        System.out.println("\nMovendo Liga para esconderijo...");
        for (int i = 0; i < 4; i++) {
            SuperHeroi heroi = (SuperHeroi) liga.getIntegrante(i);
            if (heroi != null) {
                esconderijoLiga.adicionarPersonagem(heroi);
            }
        }
        esconderijoLiga.mostrarPersonagens();
    }
}