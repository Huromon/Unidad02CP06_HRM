import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Integer numero1= 10;
                FibonaziHebra.numeroFibonacci = numero1;
                if(FibonaziHebra.numeroFibonacci== 0) {
                    System.out.println(0);
                }else if(FibonaziHebra.numeroFibonacci==1) {
                    System.out.println(2);
                }else{
                    Controlador controlador = new Controlador();
                    CalcularFibonacci  calculo = new CalcularFibonacci(controlador);
                    LinkedList<Thread> hebras = new LinkedList<>();
                    for(int k = 1; k < FibonaziHebra.numeroFibonacci;k++) {
                        hebras.add(new Thread (new FibonaziHebra(k,controlador,calculo)));
                    }
                    for(Thread e : hebras) {
                      e.start();
                    }
                    Thread g = new Thread (calculo);
                    g.start();
                    try {
                        for (Thread e : hebras) {
                            e.start();

                        }
                    }catch (IllegalThreadStateException e){

                    }



                }


    }
}
