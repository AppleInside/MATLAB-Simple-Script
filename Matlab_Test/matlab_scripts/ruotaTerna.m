%% Semplice funzione che ruota una terna degli angoli specificati, sull'asse indicato
% angoli è espresso come [alpha, beta, gamma], ognuno rispetto al suo asse
% angoli è un vettore di 3 elementi, uno per ogni asse [x, y ,z] 
% ref è il riferimento perm gli angoli, 'deg' o 'rad'
function nuovaTerna = ruotaTerna(t, angoli, ref)
    %controllo se le dimensioni sono corrette
    
    tupla = [t 1];
    disp(tupla);
    
    if(strcmp(ref,'deg')==1)
        disp('Angoli espressi in GRADI');
        ang = (angoli*pi)./180;
    else
        ang = angoli;
        disp('Angoli espressi in RADIANTI');
    end
    disp(ang);
    
    
    alpha = ang(1);
    beta = ang(2);
    gamma = ang(3);
    R = [1 0 0 0; 0 1 0 0; 0 0 1 0; 0 0 0 1];
    
    if ang(1)~=0 % Ruoto su X di un angolo ALPHA
        R = R*[1 0 0 0; 0 cos(alpha) -sin(alpha) 0; 0 sin(alpha) cos(alpha) 0; 0 0 0 1];
    end
    
    if ang(2)~=0 % Ruoto su Y di un angolo BETA
        R = R*[cos(beta) 0 sin(beta) 0; 0 1 0 0; -sin(beta) 0 cos(beta) 0; 0 0 0 1];
    end
    
    if ang(3)~=0 % Ruoto su Z di un angolo GAMMA
        R = R*[cos(gamma) -sin(gamma) 0 0; sin(gamma) cos(gamma) 0 0; 0 0 1 0 ; 0 0 0 1];
    end
    
    
    disp(R);
    if(size(tupla,2)>size(tupla,1))
        t_tmp = (R*tupla');
        nuovaTerna = t_tmp(1:3, 1);
    else
        t_tmp = (R*tupla);
        nuovaTerna = t_tmp(1, 1:3);
    end
end
