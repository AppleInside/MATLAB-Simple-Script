%% Esempio di FUNCTION file da eseguire in Java.
% Le variabili definite, questa func prende una variable GLOBALE
% pre-definita e la incrementa.

function somma(num)
    %if(exist('sum') == 1 && exist('s') == 0)
    %    s = sum+num;
    %    fprintf("\nSomma attuale: %d",s);
    %else
    %    disp('Variable S not defined');
    %    s = s+num;
    %end
    if(exist('sumVar'))
        disp(exist('sumVar'));
    else
        disp('Variable sum not defined');
    end 
end
