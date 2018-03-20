/* REFERENCE - Documentazione ufficiale
 * 
 * https://it.mathworks.com/help/matlab/matlab_external/java-api-summary.html
 *
 *
 *
 *
 *--> Passare dati MATLAB <=> JAVA
 * 
 * https://it.mathworks.com/help/matlab/matlab_external/create-matlab-structure.html
 * 
 * https://it.mathworks.com/help/matlab/matlab_oop/handle-objects.html (Handle Objects)
 * https://it.mathworks.com/help/matlab/matlab_external/using-matlab-handle-objects.html (handle Objects)
 * https://it.mathworks.com/help/matlab/matlab_oop/comparing-handle-and-value-classes.html (Comparison)
 * 
 * 
 * 
 * 
 * 
 */

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.RejectedExecutionException;

import com.mathworks.engine.*;
import com.mathworks.matlab.types.HandleObject;
import com.mathworks.matlab.types.Struct;


public class MatlabTest {

	
	// Crea una Struct in Java e la passa al Matlab Engine
	public static void passStructToMatlab(MatlabEngine eng) throws RejectedExecutionException, EngineException, InterruptedException, ExecutionException {
		
		StringWriter writer = new StringWriter();
		String p2 = "ciao";
		double[] p3 = {1.0, 2.0, 3.0, 4.0, 5.0};
		int num = 5;
        
		// Creo un oggetto Struct e lo passo a Matlab - Solo le proprietà con accesso PUBLIC
		Struct s = new Struct("p2", p2, "p3", p3);
        
		
		// 1° MODO - Creo un oggetto nel workspace
		eng.eval("myObj = MySimpleClass("+num+")");
		// Recupero l'oggetto
		HandleObject h1 = eng.getVariable("myObj");
		
		
		// 2° MODO - Creo direttamente un oggetto e lo referenzio con h
		HandleObject h = eng.feval("MySimpleClass",0);
		
		// Setto entrambi gli oggetti con le stesse caratteristiche
		eng.feval("set", h, s);
		eng.feval("set", h1, s);
        
		
		// Semplice output
        eng.eval("whos myObj{1,1}", writer, null);
        System.out.println(writer.toString());
		
	}
	
	
	// Crea un OGGETTO in Matlab e la passa a Java come Struct
	public static void passStructToJava(MatlabEngine eng) throws RejectedExecutionException, EngineException, InterruptedException, ExecutionException {
		
		int num = 13;
		eng.eval("cd");
		HandleObject h = eng.feval("MySimpleClass",num);
		Struct s = eng.feval("getStruct", h);
	    for(String str : s.keySet()) {
	    		System.out.println(str+" = "+s.get(str));
	    }
		
		/* DEFAULT
		 HandleObject h = eng.feval("axes");
	     Struct s = eng.feval("get", h);
	     Object fontName = s.get("FontName");
	     System.out.println("The font name is " + fontName.toString());
	     try {
	         s.put("FontName", "Times");
	     }catch(UnsupportedOperationException e){
	         e.printStackTrace();
	     }
	     eng.close();
	     */
	}
	
	
	public static void ruotaTerna(MatlabEngine eng) throws MatlabExecutionException, MatlabSyntaxException, EngineException, InterruptedException, ExecutionException {
		
		double[] vect = {1, 2, 2};
		int[] vect2 = {3, 6, 2};
		double[] angles = {30, 0, 90};	// Degrees of Radiants
		
		Object obj = eng.feval(1, "ruotaTerna", vect, angles, "deg");
        System.out.println(obj);
	}
	
	
	public static void variableVisibility(MatlabEngine eng, StringWriter writer) throws MatlabExecutionException, MatlabSyntaxException, CancellationException, EngineException, InterruptedException, ExecutionException {
		eng.eval("global sumVar");
        eng.eval("sumVar = 10;");
        // esegue un intero Script
        eng.eval("VariablesVisibility", writer, null);
        System.out.println(writer);
        
        // Salvo tutte le variabili del workspace in un file .mat
        //matlab.eval("save('workspaceVars');");
        //matlab.eval("whos -f workspaceVars.mat;", writer, null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalStateException, InterruptedException, RejectedExecutionException, ExecutionException {

		
		System.out.println("Inizializzo il MATLAB Engine...");
		
		//   ========== Start MATLAB Session ==========
		MatlabEngine matlab = MatlabEngine.startMatlab();
		StringWriter writer = new StringWriter();
		matlab.eval("cd matlab_scripts");
        matlab.eval("clearMem;");
		
        
        
        //   ========== FUNZIONI ==========
        
        //	RUOTA TERNA 
        //MatlabTest.passStructToJava(matlab);
        
		
        // VARIABLES VISIBILITY 
        //MatlabTest.variableVisibility(matlab, writer);
		
        
        // PASS Struct from MATLAB to JAVA
        //MatlabTest.passStructToJava(matlab);
        
        // PASS Struct from JAVA to MATLAB
        MatlabTest.passStructToMatlab(matlab);
        
        
        
        
        // Close MATLAB Session
        matlab.close();    
	}
}
