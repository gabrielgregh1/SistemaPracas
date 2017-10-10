package projeto.model;

public abstract class Veiculo {
    protected String categoria;
    private String Placa, data, hora;
    private double pgmt;

    //Construtor da classe Veiculo
    public Veiculo(String Placa, String data, String hora) {
        this.Placa = Placa;
        this.data = data;
        this.hora = hora;
    }
    
    //m�todos getters e setters da classe
    public String getPlaca() {
        return Placa;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getCategoria() {
        return categoria;
    }


    public double getPgmt() {
        return pgmt;
    }

    public void setPgmt(double pgmt) {
        this.pgmt = pgmt;
    }
    
    
}
