
### AllPathsFromSourceToTarget
    
    DFS recursive ->
        recursion base condition = reached target = add to main result
        keep adding to path so far
        DFS
        removing from path 

### Find strongly connected components: 
    1. DFS =========================================> O(V+E)
    2. Tarjan's ->   ===============================> O(V+E)
        maintain discovery[] and low[] array
        back edges, ancestors
    3. union find ===================================> O(E * α(n)) [BEST]


### Union Find
    maintain 
        root[]
        rank[]
        
    find(i) 
        if i == root[i] return i;
        else root[i] = find(root[i])

    union(x,y)
        rootX = find(x)
        rootY = find(y)
        
        if(rootX != rootY)  
            if rank[rootX] > rank[rootY]  //compare ranks
                root[rootY] = rootX
            else if rank[rootY] > rank[rootX]  //compare ranks
                root[rootX] = rootY
            else ranks are same
                //make anyone as parent and update rank
                root[rootY] = rootX
                rank[rootX]++


            
    