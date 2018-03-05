%% ESEMPIO di codice per mostrare la differenza fra variabile GLOBALE e LOCALE

global X
X = 0;


for i=1:5
     fprintf('\n\n-> Al giro %i - X (persistent) = %d',i,sommaConReturn(X, 5));
     fprintf('\n-> Al giro %i - X (return) = %d',i,sommaConReturn(X, 5));
     somma(5);
     fprintf('\n-> Al giro %i - X (global) = %d',i,X);
     pause(2);
end


%% Utilizza una variabile GLOBALE
function somma(incr)
    % è globale
    global X
    X = X+incr;
end


%% Funzione che usa una variabile locale e la restituisce al chiamante con un return,
% Quando la funzione torna il suo WS si cancella
function x = sommaConReturn (base, incr)
    x = base+incr;
end


%% Le variabili persistenti vengono conservate tra una chiamata e la successiva,
%  ma solo all'interno della funzione che l'ha creata, sono comunque
%  variabili LOCALI.
function xl = sommaPersistent (incr)
    persistent x1
    if(x1~=0)
        x1 = x1+incr
    else
        x1 = incr
    end
end