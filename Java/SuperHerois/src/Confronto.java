class Confronto {
    public ResultadoConfronto executar(SuperHeroi superheroi, Vilao vilao) {
        int poderHeroi = superheroi.getPoderTotal();
        int poderVilao = vilao.getPoderTotal();
        
        if (poderHeroi > poderVilao) {
            return ResultadoConfronto.superHeroiVencedor;
        } else if (poderVilao > poderHeroi) {
            return ResultadoConfronto.vilaoVencedor;
        } else {
            return ResultadoConfronto.empate;
        }
    }
}