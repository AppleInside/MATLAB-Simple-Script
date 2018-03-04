function [s1,s2] = somma(arr, arr2)
s1 = 0;
s2 = 0;
for i=1:size(arr,2)
    s1 = s1+arr(i);
end
for j=1:size(arr2,2)
    s2 = s2+arr2(i);
end

end
