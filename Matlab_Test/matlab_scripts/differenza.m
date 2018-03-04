function d = differenza(arr, arr2)

endIndex = min(size(arr,2), size(arr2,2));

for i=1:endIndex
    d(i) = double(arr(i)-arr2(i));
end

end
