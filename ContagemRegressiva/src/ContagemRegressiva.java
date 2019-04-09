
public class ContagemRegressiva {

	public static void main(String[] args) {
		
		System.out.println ("Esperando 10 segundos - Regressiva");
		for (int i = 10; i > 0; i--) {
		    try { 
		    	Thread.sleep (1000); 
		    } catch (InterruptedException ex) {
		    	
		    }
		    System.out.print ("Passaram-se " +  i + " segundos..." + "\r");
		}
		System.out.println ("Os 60 segundos terminaram. Voltando ao trabalho.");
		
		System.out.println ("\nEsperando 10 segundos - Crescente");
		for (int i = 0; i < 10; i++) {
		    try { 
		    	Thread.sleep (1000); 
		    } catch (InterruptedException ex) {
		    	
		    }
		    System.out.print ("Passaram-se " +  i + " segundos..." + "\r");
		}
		System.out.println ("Os 60 segundos terminaram. Voltando ao trabalho.");
	}
}
