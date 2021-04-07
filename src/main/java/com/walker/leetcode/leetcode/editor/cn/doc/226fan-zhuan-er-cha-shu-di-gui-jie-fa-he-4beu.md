
翻转一棵二叉树。

递归解法：

```c++
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return root;
        auto t = invertTree(root->left);
        root->left = invertTree(root->right);
        root->right = t;
        return root;
    }
```

非递归解法

```c++
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return root;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            swap(p->left, p->right);
            if (p->left) q.push(p->left);
            if (p->right) q.push(p->right);
        }
        return root;
    }
```

