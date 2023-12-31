
##### 广度优先搜索

伪代码：

```c++
bool visited[node_count]; // false
void BFSTraverse(Graph G) {
		for (int i = 0; i < G.node_count; i++) {
			if (!visited[node_count]) {
				BFS(i);
			}
		}
}

void BFS(int v) {
    visit(v); // set visited true
    queue.push(v);
    while (!queue.is_empty()) {
        queue.pop();
        for (int w = first_negihbor(v); w >= 0; w = next_neighbor(v, w)) {
            if(!visited[w]) {
                visit(w);
                queue.push(w);
            }
        }
    }
}
```

时间复杂度：

- 邻接表存储：每个定点 - O(|V|) + 每条边 - O(|E|)；故时间复杂度为：O(|V| + |E|)
- 邻接矩阵：查找每个相邻点 - O(|V|)，每个顶点均需查找，故时间复杂度：O(|V|<sup>2</sup>)

空间复杂度：

- 使用队列，最坏情况下：O(|V|)

延伸：

计算最短路径，条件：

- 单源
- 路径代价 = 1；



##### 深度优先搜索

伪代码：

```c++
bool visited[node_count]; // false
void DFSTraverse(Graph G) {
	for (int i = 0; i < G.node_count; i++) {
		if (!visited[node_count]) {
			BFS(i);
		}
	}
}
void DFS(Graph G, int v) {
	visit(v); // visited[v] = true;
    for (w = FirstNeighbor(G, v); w >= 0; w = NextNeighbor(G, v, w)) {
    	if (!visited[w]) {
    		DFS(G, w);
    	}
    }
}
```

时间复杂度：

- 邻接表：O(|V| + |E|)
- 邻接矩阵：O(|V|<sup>2</sup>)

空间复杂度：

需要一个递归栈：O(|V| )



##### 应用

判断图的连通性；
