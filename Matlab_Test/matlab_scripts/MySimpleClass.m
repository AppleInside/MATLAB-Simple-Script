classdef MySimpleClass  < matlab.mixin.SetGet
     
    properties(Constant)
        c_1 = 500;       
    end
    
    % Quando il GetAccess è public, posso vedere il valore delle variabili
    % dal pannello Workspace
    properties(GetAccess = 'public', SetAccess = 'private')
        p1;
    end
    
    properties(GetAccess = 'public', SetAccess = 'public')
        p2;
        p3;
    end
    
    properties(GetAccess = 'private', SetAccess = 'private')
        p4;    
    end
    
    
    
    
    
    
    %% Setters/Getter
    methods
    
        function val = get.p3(obj)
            val = obj.p3;
        end
        
        function val = get.p2(obj)
            val = obj.p2;
        end
    end
    
    
        
    %% Costruttore
    methods
        
        function object = MySimpleClass(num)
            object.p3 = 100;
            object.p2 = 'CIAO';
            object.p1 = num;
        end         
    end 
    
    
    
    methods (Access = public)
        
        function increment(obj)
            obj.p3 = obj.p3 + obj.c_1;
        end
    end
    
    
    methods
        % MATLAB Object ----> Struct
        function str = getStruct(obj)
            str = struct(obj);
        end

        
        % Struct ---> MATLAB Object
        function object = setStruct(classname, str)
           %converts structure s to an object of class classname.
           %assumes classname has a constructor which takes no arguments
           object = eval(classname);  %create object
           for fn = fieldnames(s)'    %enumerat fields
              try
                  object.(fn{1}) = s.(fn{1});   %and copy
              catch
                  warning('Could not copy field %s', fn{1});
              end
           end 
        end
    end
    
    
end
