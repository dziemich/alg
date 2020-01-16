package alg

data class Vertex(val name: String, val edges: List<Edge>)
data class Edge(val v1: String, val v2: String, val cost: Int)

class WeightedTree(val vertices: List<Vertex>, val edges: List<Edge>) {

  fun findLongestPathInTree(weightedTree: WeightedTree): Int {
    val result = arrayListOf<Int>()
    weightedTree.vertices.forEach {
      if (it.edges.size == 1) {
        val edge = it.edges[0]
        result.add(visitVertex(0, fetchVertex(edge, it)))
      }
    }
    return result.max()!!
  }

  fun visitVertex(pathCost: Int, vertex: Vertex): Int {
    var highestCost = pathCost
    if (vertex.edges.size == 1) {
      return pathCost
    }
    vertex.edges.forEach {
      val cost = visitVertex(pathCost + it.cost, fetchVertex(it, vertex))
      if (cost > pathCost) {
        highestCost = cost
      }
    }
    return highestCost
  }

  fun fetchVertex(edge: Edge, vertex: Vertex): Vertex {
    var v = edge.v1
    if (v == vertex.name){
      v = edge.v2
    }
    return vertices.first { it.name.equals(v) }
  }
}
