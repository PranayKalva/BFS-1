class LevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int currentHeight) {
        if (root == null) {
            return;
        }

        if (currentHeight == result.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        } else {
            result.get(currentHeight).add(root.val);
        }
        dfs(root.left, currentHeight + 1);
        dfs(root.right, currentHeight + 1);
    }
}
