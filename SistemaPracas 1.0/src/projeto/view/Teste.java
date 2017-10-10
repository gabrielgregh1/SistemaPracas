package projeto.view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import projeto.model.Praca;
import java.util.Scanner;
import projeto.model.Comercial;
import projeto.model.Concessionaria;
import projeto.model.Passeio;

public class Teste {
    static Concessionaria consc = new Concessionaria("","");
    static Comercial comercialNovo = new Comercial("","","");
    static Passeio passeioNovo = new Passeio("","","");
    static Praca praca = new Praca("",0);
    static Scanner leitor=new Scanner(System.in);
    
  
public static void Cadastro(){
       int totalPraca = 10,numeroPracas=0,codigoPraca,numeroEixos;
       String placa,data,hora,categoriaVeiculo;
      
       //Praca pracas = new Praca(); 

       //Menu de op��es
       do{
            System.out.println("\n1 - Cadastrar uma Pra�a de Ped�gio");
            System.out.println("2 - Cadastrar um ve�culo de categoria Passeio/Utilit�rio");
            System.out.println("3 - Cadastrar um ve�culo de categoria Comercial");
            System.out.println("4 - Consultar faturamento para Prefeitura");
            System.out.println("5 - Consultar registro de ve�culos");
            System.out.println("0 - Sair");
            System.out.println("\nDigite uma op��o: ");
            int opcao=leitor.nextInt();
            
            switch(opcao){
                case 1:
                    cadastrarPraca();
                    break;
                case 2:
                    cadastrarVeiculoCatA();
                    break;
                    
                case 3:
                    cadastrarVeiculoCatB(); 
                    break;
                    
                case 4:   
                    faturamentoDaPrefeitura();
                    break;
                case 5:
                    consultaRegistro();
                    break;
             
   default: System.out.println("incorreto");
            System.out.println("");
                    
              }
            
       }while(true);
    }
    
    public static void main(String[] args){
         Scanner input=new Scanner(System.in);

        Cadastro();
    }
    
    /*
     * cadastrarPraca servir� para armazenarmos informa��es de novas pra�as
     */
    private static void cadastrarPraca(){  
        System.out.println("Digite o Valor por eixo: ");
        double valorEixo = leitor.nextDouble();
       
        System.out.println("Digite o endere�o da nova Pra�a:");
        String endereco = leitor.next();     
        
        praca=new Praca(endereco,valorEixo);
        consc.CadastrarPraca(praca);

    }
    
    /*
     * Aqui cadastraremos todos os ve�culos de categoria passeio em nosso vetor, armazenando
     * suas informa��es
     */
    private static void cadastrarVeiculoCatA(){
        /**
         * inserir data e hora nas variaveis "Data , Time"
         */
        String data, time;
        
        
        //pega a data do sistema
        GregorianCalendar hoje = new GregorianCalendar();        
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        data = out.format(hoje.getTimeInMillis());
        
        
        //pegando a hora do sistema
       SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
       time = dateFormat.format(new Date());
        
        
        
        
        System.out.println("Informe o c�digo da pra�a onde deseja cadastrar o veiculo: ");
        int codigoPraca = leitor.nextInt();
        //Tratamento de ERROS com Valor de codigo MAL INFORMADO
        if(codigoPraca > consc.getQtdCadastrosP() || codigoPraca < 1){
            System.out.println("\n\nERRO!Voc� informou um condigo de pra�a que n�o existe\n");
            System.out.println("ATUALMENTE EXISTE "+consc.getQtdCadastrosP());
            System.out.println("lembre-se de come�ar pelo 1\n\n");
            return;
        }
        
        System.out.println("Informe a placa do veiculo: ");
        String placa = leitor.next();
                  
        passeioNovo = new Passeio(placa,data,time);
                              
        consc.getVetPraca()[codigoPraca].CadastrarVeiculo(passeioNovo,1);
    }
    
    /*
     * Armazenamos os ve�culos de categoria comercial com suas informa��es e a quantidade
     * de eixos pertencentes ao ve�culo
     */
    private static void cadastrarVeiculoCatB(){
        /**
         * inserir data e hora nas variaveis "Data , Time"
         */
        String data, time;
        
        
        //pega a data do sistema
        GregorianCalendar hoje = new GregorianCalendar();        
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        data = out.format(hoje.getTimeInMillis());
        
        
        //pegando a hora do sistema
       SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
       time = dateFormat.format(new Date());
        
        System.out.println("Informe o c�digo da pra�a onde o ve�culo esta localizado: ");
        int codigoPraca = leitor.nextInt();
       
        //Tratamento de ERROS com Valor de codigo MAL INFORMADO
        if(codigoPraca > consc.getQtdCadastrosP() || codigoPraca < 1){
            System.out.println("\n\nERRO!Voc� informou um condigo de pra�a que n�o existe\n");
            System.out.println("ATUALMENTE EXISTE "+consc.getQtdCadastrosP());
            System.out.println("lembre-se de come�ar pelo 1\n\n");
            return;
        }
                    
        System.out.println("Informe a placa do veiculo: ");
        String placa = leitor.next();
                    
        
        System.out.println("Informe o n�mero de eixos");
        int numeroEixos = leitor.nextInt();      
                    
        comercialNovo = new Comercial(placa,data,time);
        consc.getVetPraca()[codigoPraca].CadastrarVeiculo(comercialNovo, numeroEixos);
    }
    
   /*
    * Para imprimirmos as informa��es de todas as pra�as, assim como as dos carros que por
    * elas passaram, corremos todo o vetor mostrando todos os dados contidos
    */
    private static void faturamentoDaPrefeitura(){
            System.out.println("                                   FATURAMENTO                                       ");
        for(int i=1;i<=consc.getQtdCadastrosP();i++){
            System.out.println("\n___________________________________________________________________________________");
            System.out.println("Pra�a de Ped�gio"+i);
            System.out.println("C�digo: " + consc.getVetPraca()[i].getCodigo()+ "                     Local:"+consc.getVetPraca()[i].getEndereco());
            System.out.println("___________________________________________________________________________________");
            System.out.println("Ve�culos Categoria 1:");
            for(int x=1; x<=consc.getVetPraca()[i].getQtdCadastrosV(); x++){
                if (consc.getVetPraca()[i].getCar()[x].getCategoria().equals("2")){
                System.out.println("Placa:"+consc.getVetPraca()[i].getCar()[x].getPlaca()+" Data: "+consc.getVetPraca()[i].getCar()[x].getData()+ " Hora: "+consc.getVetPraca()[i].getCar()[x].getHora());  
                }
            }
            System.out.println("___________________________________________________________________________________");
            System.out.println("Ve�culos Categoria 2:");
            for (int x=1; x<=consc.getVetPraca()[i].getQtdCadastrosV(); x++){
                if (consc.getVetPraca()[i].getCar()[x].getCategoria().equalsIgnoreCase("3")){
                System.out.println("Placa:"+consc.getVetPraca()[i].getCar()[x].getPlaca()+" Data: "+consc.getVetPraca()[i].getCar()[x].getData()+ " Hora: "+consc.getVetPraca()[i].getCar()[x].getHora()); 
                }
            }
            System.out.println("___________________________________________________________________________________");
            
            double ValorPraca;
            ValorPraca=0;
            
            //Aqui ocorre o calculo de quanto cada pra�a arrecadou
            for(int y=1; y<=consc.getVetPraca()[i].getQtdCadastrosV();y++){
                ValorPraca+=consc.getVetPraca()[i].getCar()[y].getPgmt();                      
            }   
            System.out.println("Total arrecadado na pra�a "+i+": "+ValorPraca);
         }
        
         System.out.println("___________________________________________________________________________________");
         
         //Calcula Valor Total de todas as Pra�as
         double ValorTotal = 0;
         for(int i=1;i<=consc.getQtdCadastrosP();i++){
            for(int y=1; y<=consc.getVetPraca()[i].getQtdCadastrosV(); y++){
                ValorTotal+=consc.getVetPraca()[i].getCar()[y].getPgmt();                      
            }      
         }
         System.out.println("Total arrecadado: "+ValorTotal);
         
         //Valor recebido pela Prefeitura ser� 30% do valor total
         double valorPre=ValorTotal*0.3;   
         System.out.println("Valor a ser recebido pela prefeitura: "+valorPre);
                    
    }

    /*
     * consultaRegistro nos mostra se determinado ve�culo passou em alguma pra�a, e se passou,
     * nos mostrara o hor�rio e a data em que passou por meio da placa do carro.
     */
    private static void consultaRegistro(){
    	int achou=0;
        System.out.println("Informe a placa do ve�culo a ser consultado: ");
    	String placa = leitor.next();
    	for (int i = 1; i<=consc.getQtdCadastrosP(); i++){
    		for (int x = 1; x<=consc.getVetPraca()[i].getQtdCadastrosV(); x++){
    		     if (placa.equalsIgnoreCase(consc.getVetPraca()[i].getCar()[x].getPlaca())){
    		    	 System.out.println("______________________________________________________________________________________________________________________");
    		    	 System.out.println("Pra�a de Ped�gio"+i);
    		         System.out.println("C�digo: " + consc.getVetPraca()[i].getCodigo()+ "                     Local:"+consc.getVetPraca()[i].getEndereco());
    		    	 System.out.println("Data: "+consc.getVetPraca()[i].getCar()[x].getData()+ " \nHora: "+consc.getVetPraca()[i].getCar()[x].getHora());
    		    	 System.out.println("_______________________________________________________________________________________________________________________");
                         achou=1;
                     }	
    	        }
    	}
    	/*
    	 * Caso a placa do carro n�o esteja registrada em nenhuma pra�a, uma mensagem, de
    	 * que est� placa n�o foi encontrada ser� exibida
    	 */
    	if(achou==0)
            System.out.println("\n\nPlaca Inexistente.\n\n");
        
        }
}