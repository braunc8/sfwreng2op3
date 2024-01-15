/* Assignment 10 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (50 marks in total)
    Use mutils.BinarySearchTree as a basic structure to implement a TreeMap for <String, Integer>.
    You cannot use JCF provided map.
 */

import mutils.BinarySearchTree;
import java.util.ArrayList;
import mutils.Node;


public class Q1_TreeMapByBST {

    // use m_bst as the basic data structure for the treemap of <String, Integer>
    static BinarySearchTree m_bst = new BinarySearchTree();

    // Question 1.1 (5 marks): implement method size().
    // Returns the number of elements in this map (its cardinality).
    // You can ONLY modify the body of this method including the return statement.
    public int size() {int val = size(m_bst.root); return val;}

    public int size(Node n) {
        if(n==null){
            return 0;
        }
        return size(n.left) + 1 + size(n.right);
    }

    // Question 1.2 (5 marks): implement method isEmpty().
    // Returns true if this map contains no elements, otherwise return false.
    // You can ONLY modify the body of this method including the return statement.
    public boolean isEmpty() {
        if (m_bst.root==null){
            return true;
        }
        return false;
    }

    // Question 1.3 (15 marks) implement method get().
    // If key is contained in the map, return the value of the key.
    // If key is not contained in the map, return -1.
    // You can ONLY modify the body of this method including the return statement.
    public int get(String key){
        Node new_node= new Node(key, 1);
        return get(new_node, m_bst.root);}

    public int get(Node key,Node n) {
        if(n==null){
            return -1;
        }
        if(n.compareTo(key)>0){
            return get(key,n.left);
        }else if(n.compareTo(key)<0){
            return get(key,n.right);
        }else{
            return n.freq;
        }
    }

    // Question 1.4 (15 marks) implement method put().
    // If the key is already contained in the map, overwrite the old value and return -1;
    // If the key is not contained in the map, add a new <key,value> entry to the map and return 1;
    // You can ONLY modify the body of this method including the return statement.
    public int put(String key,int value){
        Node new_node=new Node(key,value);
        if(get(key)==-1){
            m_bst.insert(new_node);
            return 1;
        }
        //should only run if the key already exists in the tree
        return put(new_node,value,m_bst.root);
    }

    public int put(Node key, int value,Node n) {
        if (n.compareTo(key) > 0) {
            return put(key, value,n.left);
        }else if (n.compareTo(key) < 0) {
            return put(key, value,n.right);
        }else{
            n.freq+=value;//i wasnt sure if this was exactly what was wanted, but this works better for Q2 since the frequency would include previous instances
            return -1;
        }
    }

    // Question 1.5 (10 marks) implement method getKeysInAlphabeticalOrder().
    // return the keys of this map as an ArrayList<String> in Alphabetical order.
    // You can ONLY modify the body of this method including the return statement.
    public ArrayList<String> getKeysInAlphabeticalOrder(){
        ArrayList<String> keys = new ArrayList<String>();
        getKeysInAlphabeticalOrder(m_bst.root,keys);
        return keys;
    }
    public void getKeysInAlphabeticalOrder(Node n,ArrayList<String> keys){
        if(n==null){return;}
        getKeysInAlphabeticalOrder(n.left,keys);
        keys.add(n.data);
        getKeysInAlphabeticalOrder(n.right,keys);

    }
}
