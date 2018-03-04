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
		
		MatlabEngine matlab = MatlabEngine.startMatlab();
		double[] vect = {1, 2, 2};
		int[] vect2 = {3, 6, 2};
		double[] angles = {30, 0, 90};
		double[][] matr = {{1, 2, 2},{11, 5, 9},{7, 4, 3}};
		matlab.eval("cd matlab_scripts");
        matlab.eval("cd");
        //Object obj1 = matlab.feval("differenza",vect, vect2);
        Object obj1 = matlab.feval("ruotaTerna",vect, angles, "deg");
        
        System.out.println("Class: "+obj1.getClass().getSimpleName().toString());
        //Object[] obj2 = matlab.feval(3,"somma",matr);
		
        //double[] vect = {1, 2, 2};
        //vett_r = RuotaTerna(vect, {0,0,0}, 'deg');
        
	}

}
