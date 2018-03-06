/* REFERENCE - Documentazione ufficiale
 * 
 * https://it.mathworks.com/help/matlab/matlab_external/java-api-summary.html
 *
 */

<<<<<<< HEAD


=======
import java.io.StringWriter;
>>>>>>> branch 'master' of https://github.com/AppleInside/MATLAB-Simple-Script.git
import java.util.concurrent.ExecutionException;

import java.util.concurrent.RejectedExecutionException;

import com.mathworks.engine.*;


public class MatlabTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalStateException, InterruptedException, RejectedExecutionException, ExecutionException {
		
		System.out.println("Inizializzo MATLAB Engine...");
		
		// Start MATLAB Session
		MatlabEngine matlab = MatlabEngine.startMatlab();
		
		StringWriter writer = new StringWriter();
		
		matlab.eval("cd matlab_scripts");
        //matlab.eval("cd");
        //matlab.eval("ls");
        
        matlab.eval("clearMem;");
		
        /*	RUOTA TERNA
        double[] vect = {1, 2, 2};
		int[] vect2 = {3, 6, 2};
		double[] angles = {30, 0, 90};	// Degrees of Radiants
		
		Object obj = matlab.feval("ruotaTerna",vect, angles, "deg");
        */
        
		
        
        /* VARIABLES VISIBILITY */
		matlab.eval("global sumVar");
        matlab.eval("sumVar = 10;");
        
        matlab.feval(0,"sommaNum", 0);
         
        
        
        
        // Salvo tutte le variabili del workspace in un file .mat
        
        //matlab.eval("save('workspaceVars');");
        //matlab.eval("whos -f workspaceVars.mat;", writer, null);
        
        
        // Close MATLAB Session
        matlab.close();
        
	}

}
