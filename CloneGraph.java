// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> newNodesMap = new HashMap<Integer, Node>();
        List<Node> visitedNodes = new ArrayList<Node>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        Node currentNode;
        while(!stack.isEmpty()) {
            currentNode = stack.pop();
            visitedNodes.add(currentNode);
            
            if(!newNodesMap.containsKey(currentNode.val)) {
                Node copyNode = new Node(currentNode.val);
                newNodesMap.put(currentNode.val, copyNode);
            }

            ArrayList<Node> neighbors = new ArrayList<Node>();

            for(Node neighborNode : currentNode.neighbors) {
                if(!newNodesMap.containsKey(neighborNode.val)) {
                    Node copyNeighborNode = new Node(neighborNode.val);
                    newNodesMap.put(neighborNode.val, copyNeighborNode);
                }
                
                Node newNode = newNodesMap.get(neighborNode.val);
                neighbors.add(newNode);
                if(!visitedNodes.contains(neighborNode)) {
                    stack.push(neighborNode);
                }
            }
            Node newRootNode = newNodesMap.get(currentNode.val);
            newRootNode.neighbors = neighbors;
        }
        return newNodesMap.get(node.val);
    }
}

