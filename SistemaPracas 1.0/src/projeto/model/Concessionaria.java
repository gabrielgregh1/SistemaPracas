package projeto.model;


public class Concessionaria {
    private String nome;
    private String endereco;
    private Praca[] vetPraca = new Praca[10];
    private int qtdCadastrosP=0;
    
    //Construtor da classe concession�ria
    public Concessionaria(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    /*QtdCadastro servir� para sabermos quantas pra�as foram cadastradas, facilitando a 
    *utiliza��o na hora de executarmos o progama
    */
    public int getQtdCadastrosP() {
        return qtdCadastrosP;
    }
    
    //M�todos get e set da classe concessionaria
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
    
    //Este m�todo fornecer� acesso ao vetor Praca contido nesta classe
    public Praca[] getVetPraca() {
        return vetPraca;
    }
    
    //M�todo para salvar novas pra�as no vetor, somando a qtd de pra�as cadastradas
    public boolean CadastrarPraca(Praca novo){
        qtdCadastrosP++;
        if(vetPraca.length>qtdCadastrosP){
           vetPraca[qtdCadastrosP]=novo;
           return true;
       }
        return false;
    }

}
