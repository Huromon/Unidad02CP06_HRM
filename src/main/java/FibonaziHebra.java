import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FibonaziHebra implements  Runnable {
    static Integer numeroFibonacci;
    private Integer numeroHebra;
    private Long Valor;
   static Integer[] sucesion = {0,1};
    static LinkedList<Integer> sucesionList = new LinkedList<>();

    private final CalcularFibonacci calcularFibonacci;
    private final Controlador controlador;
        FibonaziHebra(Integer numero ,Controlador controlador,CalcularFibonacci calcularFibonacci){
        this.numeroHebra = numero;
        sucesionList.add(numeroHebra);
        this.controlador = controlador;
        this.calcularFibonacci = calcularFibonacci;
    }


   synchronized public Integer calcular() {
       Integer n1 = sucesion[0];
       Integer n2 = sucesion[1];
            Integer resultado =(n1+n2);
            System.out.println(n1+" + "+ n2 +" = "+ resultado);
            actualizar(resultado);
             return  resultado;
    }

   synchronized private void actualizar(Integer resultado) {
        setuno(sucesion[1]);
        setdos(resultado);
    }
    synchronized public void setuno(Integer numero ) {
        sucesion[0] = numero;
    }
    synchronized public void setdos(Integer numero) {
        sucesion[1] = numero;
    }


    @Override
    public void run() {
            calcularFibonacci.añadirHebra(this);
            try{
                controlador.esperar();
            }catch (InterruptedException e){
                System.out.println(e);

            }

    }

}
