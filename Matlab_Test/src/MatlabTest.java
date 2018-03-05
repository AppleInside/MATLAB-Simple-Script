/* REFERENCE
 * 
 * https://it.mathworks.com/help/matlab/matlab_external/java-api-summary.html
 *
 */

import java.util.concurrent.ExecutionException;

import java.util.concurrent.RejectedExecutionException;

import com.mathworks.engine.*;


public class MatlabTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalStateException, InterruptedException, RejectedExecutionException, ExecutionException {
		
		System.out.println("Inizializzo MATLAB Engine...");
		MatlabEngine matlab = MatlabEngine.startMatlab();
		double[] vect = {1, 2, 2};
		int[] vect2 = {3, 6, 2};
		double[] angles = {30, 0, 90};	// Degrees of Radiants
		
		matlab.eval("cd matlab_scripts");
        matlab.eval("cd");
        
        
        //Object obj1 = matlab.feval("differenza",vect, vect2);
        //Object obj1 = matlab.feval("ruotaTerna",vect, angles, "deg");
        
        matlab.eval("sumVar = 10;");
        // Chiama 10 volte questa funzione 
        Object obj1 = null;
        //for (int i =0; i<10; i++)
        	//obj1 = matlab.feval("somma", i);
        
        matlab.feval("somma", 10);
        
        
        // Verifico il risultato finale
        obj1 = matlab.getVariable("sumVar");
        System.out.println("obj1.class : "+obj1.getClass().getSimpleName());
        
	}

}
