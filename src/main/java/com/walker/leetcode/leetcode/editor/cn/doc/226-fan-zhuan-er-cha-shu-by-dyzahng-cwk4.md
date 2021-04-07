### 解题思路
解法1：前序遍历（中序、后序类似），递归

解法2：前序遍历（中序、后序类似），迭代，栈

解法3：层序遍历，BFS，队列

### 代码
解法1：递归
```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#define MAX_SIZE 10000

struct TreeNode* invertTree(struct TreeNode* root){
    if (!root) {
        return NULL;
    }
    
    struct TreeNode *tmp = root->left;
    root->left = root->right;
    root->right = tmp;

    invertTree(root->left);
    invertTree(root->right);
    return root;
}
```

解法2：迭代
```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#define MAX_SIZE 10000

struct TreeNode* invertTree(struct TreeNode* root){
    if (!root) {
        return NULL;
    }
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * MAX_SIZE);
    int top = -1;
    stack[++top] = root;
    while (top != -1) {
        struct TreeNode* p = stack[top--];

        struct TreeNode* tmp = p->left;
        p->left = p->right;
        p->right = tmp;

        if (p->left) {
            stack[++top] = p->left;
        }
        if (p->right) {
            stack[++top] = p->right;
        }
    }
    return root;
}
```

解法3：BFS
```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#define MAX_SIZE 10000
struct TreeNode* invertTree(struct TreeNode* root) {
    if (!root) {
        return NULL;
    }
    struct TreeNode** queue = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * MAX_SIZE);
    int head = 0, rear = 0;
    queue[rear++] = root;
    while (head < rear) {
        int szie = rear - head;
        for (int i = 0; i < szie; i++) {
            struct TreeNode* p = queue[head++];

            struct TreeNode* tmp = p->left;
            p->left = p->right;
            p->right = tmp;

            if (p->left) {
                queue[rear++] = p->left;
            }
            if (p->right) {
                queue[rear++] = p->right;
            }
        }
    }
    return root;
}
```