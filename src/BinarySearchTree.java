public class BinarySearchTree {

    /**
     * An object of type TreeNode represents one node in a binary tree of type Person.
     */
    private static class TreeNode {
        Person personData;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.
        TreeNode(Person person) {
                // Constructor.  Make a node containing the specified person.
                // Note that left and right pointers are initially null.
            this.personData = person;
        }
    }


    static TreeNode root;  // Pointer to the root node in a binary tree.
                                   // This tree is used in this program as a 
                                   // binary search tree.  When the tree is empty, 
                                   // root is null (as it is initially).


    /**
     * Add the item to the binary search tree to which the global variable 
     * "root" refers.
     */
    static void treeInsert(Person newPerson) {
        if ( root == null ) {
                // The tree is empty.  Set root to point to a new node containing
                // the new item.  This becomes the only node in the tree.
            root = new TreeNode( newPerson );
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newPerson.
        runner = root;   // Start at the root.
        while (true) {
            if ( newPerson.getName().compareTo(runner.personData.getName()) < 0 ) {
                    // Since the new item is less than the item in runner,
                    // it belongs in the left subtree of runner.  If there
                    // is an open space at runner.left, add a new node there.
                    // Otherwise, advance runner down one level to the left.
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newPerson );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.left;
            }
            else {
                    // Since the new item is greater than or equal to the item in
                    // runner it belongs in the right subtree of runner.  If there
                    // is an open space at runner.right, add a new node there.
                    // Otherwise, advance runner down one level to the right.
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newPerson );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.right;
            }
        }
    }


    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points.   Return false if not.
     */
    static Person treeContains( TreeNode root, String name ) {
        if ( root == null ) {
                // Tree is empty, so it certainly doesn't contain item.
            return null;
        }
        else if ( name.equals(root.personData.getName()) ) {
                // Yes, the item has been found in the root node.
            return root.personData;
        }
        else if ( name.compareTo(root.personData.getName()) < 0 ) {
                // If the item occurs, it must be in the left subtree.
            return treeContains( root.left, name );
        }
        else {
                // If the item occurs, it must be in the right subtree.
            return treeContains( root.right, name );
        }
    }

    /**
     * Print the items in the tree in inorder, one item to a line.  
     * Since the tree is a sort tree, the output will be in increasing order.
     */
    static void treeList(TreeNode node) {
        if ( node != null ) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println(node.personData);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    }
}