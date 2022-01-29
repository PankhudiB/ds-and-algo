        2         4
     /    \     /   \ 
    3      4   3     2

MAX_HEAPIFY(arr, i) :

    Left = 2*i + 1
    Right = 2*i + 2
    if(Left exists && arr[Left] > arr[i])
        largest = Left;
    else    
        largest = i;
    if (Right exists && arr[Right] > arr[lergest])
        largest = right;
    if(largest != i)
        swap (arr[largest], arr[i])
        MAX_HEAPIFY(arr,largest)

    
    
