import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);


    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);

    // preOrder(root);
    // System.out.println(max(root));

    Map<Integer, List<Integer>> tree = new HashMap<>();
    tree.put(33, List.of(24, 61,12));
    tree.put(17, List.of(5, 99));
    tree.put(158, List.of(73));
    tree.put(24, List.of(83, 6));
    tree.put(88, List.of(17, 58, 33));
    tree.put(5, List.of());
    tree.put(99, List.of());
    tree.put(73, List.of());
    tree.put(83, List.of());
    tree.put(6, List.of());
    tree.put(61, List.of());
    tree.put(12, List.of());
  

    mapPreOrder(tree, 88);


  }
  static void mapPreOrder(Map<Integer, List<Integer>> map, Integer current){
    if(!map.containsKey(current)){
      return;
    }

    System.out.println(current);

    for(int child : map.get(current)){
      mapPreOrder(map, child);
    }
  }
  static void preOrder(Node<?> node){
    if(node == null) return; 
    System.out.print(node.value + " ");
    for(Node<?> child: node.children){
      preOrder(child);
    }
  }
  static int max(Node<Integer> node){
    if(node == null) return Integer.MIN_VALUE;

    int max = node.value;
    for(Node<Integer> subtree: node.children){
      int subtreeMax = max(subtree);
      if (subtreeMax > max){
        max = subtreeMax;
      }
    }
    return max;
  }
  
}

