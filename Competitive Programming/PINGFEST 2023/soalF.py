import heapq

def shortest_path(graph, start, end):
    distances = {vertex: float('infinity') for vertex in graph}
    distances[start] = 0
    priorityQueue = [(0, start)]

    while priorityQueue:
        currentDistance, currentVertex = heapq.heappop(priorityQueue)

        if currentDistance > distances[currentVertex]:
            continue

        for neighbor, weight in graph[currentVertex].items():
            distance = currentDistance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priorityQueue, (distance, neighbor))

    return distances[end]

V, E, a, b = map(int, input().split())
graph = {i: {} for i in range(1, V + 1)}

for _ in range(E):
    x, y, z = map(int, input().split())
    graph[x][y] = z
    graph[y][x] = z

result = shortest_path(graph, a, b)

print(result)