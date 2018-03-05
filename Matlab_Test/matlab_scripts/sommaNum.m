%% Esempio di FUNCTION file da eseguire in Java.
% Le variabili definite, questa func prende una variable GLOBALE
% pre-definita e la incrementa.

function sommaNum(num)

    % Verifico quali variabili sono disponibili nel workspace
    %whos;
    global sumVar
    
    %if(exist('sum') == 1 && exist('s') == 0)
    %    s = sum+num;
    %    fprintf("\nSomma attuale: %d",s);
    %else
    %    disp('Variable S not defined');
    %    s = s+num;
    %end
    
    % Since every function has its own workspace, evalin allows to evaluate
    % a command into another workspace, ie: the "base" workspace
    %evalin('base', 'whos');
    
    
    if(exist('sumVar') ~= 0)
        sumVar = sumVar+num;
    else
        disp('Variable sumVar not defined');
        sumVar = 0;
    end 
end
