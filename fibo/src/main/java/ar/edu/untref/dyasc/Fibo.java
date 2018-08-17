package ar.edu.untref.dyasc;
public class Fibo {
    /* Dado un numero devuelve el valor de la sucesion de Fibonacci
     * correspondiente a ese numero
     */
    private int fibo(int n){
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }
    
    /* Dado una cantidad numerica, devuelve el calculo de la sucesion
     * de fibonacci con una cantidad de iteraciones igual al valor ingresado
     * por parametro
     */
    public String getSerie(int quantity){
        String result = String.format("fibo<%d>:", quantity);
        for(int i=0; i < quantity; i++){
            result += String.format(" %d", fibo(i));
        }
        return result;
    }
    
    public static void main(String args[]) {
        Fibo fibo = new Fibo();
        int inputValue = Integer.valueOf(args[0]);
        System.out.println(fibo.getSerie(inputValue));
    }
}