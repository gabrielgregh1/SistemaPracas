package projeto.model;


public class Praca {
    private static int cont=0;
    private int codigo;
    private Veiculo[] car = new Veiculo[10];
    private double ValorEixo;
    private String endereco;
    int qtdCadastrosV=0;
    
    //construtor da classe Praca
    public Praca(String endereco,double ValorEixo) {
        this.ValorEixo = ValorEixo;
        this.endereco=endereco;
        this.codigo = cont;
        Praca.cont++;
    }
    
    //Este m�todo fornecer� acesso ao vetor de ve�culos contido nesta classe
    public Veiculo[] getCar() {
        return car;
    }

    //m�todo para sabermos a quantidade de ve�culos j� cadastrados
    public int getQtdCadastrosV() {
        return qtdCadastrosV;
    }
    
    //m�todos getters e setters da classe Praca
    public int getCodigo() {
        return codigo;
    }

    public double getValorEixo() {
        return ValorEixo;
    }


    public String getEndereco() {
        return endereco;
    }
    
    //M�todo para cadastrar Novo Veiculo com base em sua categoria e quantidade de eixos
    public boolean CadastrarVeiculo(Veiculo novo, int qtdEixos){
        
        if(car.length>qtdCadastrosV){
           qtdCadastrosV++;
           car[qtdCadastrosV]=novo;
           
           //categorial 2 == Passeio
           if(car[qtdCadastrosV].getCategoria().equals("2")){
               car[qtdCadastrosV].setPgmt(ValorEixo);
              
           }//categoria 3 == Comercial
           else if(car[qtdCadastrosV].getCategoria().equals("3")){
               car[qtdCadastrosV].setPgmt(ValorEixo*qtdEixos);
               
           }
           return true;
       }
        return false;
    }
         
}
