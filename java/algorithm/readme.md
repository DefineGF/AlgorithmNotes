#### 最长递增子序列
##### leetcode-300
`[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。`
代码如下：
```c
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    if (n == 1) return 1;
    int len = 1;
    int[] dp = new int[n];
    dp[0] = nums[0];

    for (int i = 1; i < n; ++i) {
        int target = nums[i];
        if (target > dp[len - 1]) {
            dp[len++] = target;
        } else {
            int search = Arrays.binarySearch(dp, 0, len, target);
            if (search < 0) {
                search = -1 * (search + 1);
                dp[search] = target;
            }
        }
    }
    return len;
}
```
##### 进阶 leetcode-1713
> 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。 
> 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。

分析: <br>
最终结果可以看做是 target.length - len(target在arr中的最长公共子序列); <br>
算法思想：
- 在 HashMap 记录target数组中元素的索引；
- 遍历 arr 数组，并判断是否是 target 中的元素：
    - 如果可以继续构成子序列，则添加；
    - 如果当前元素虽然可以构成，但是偏小，则覆盖掉之前偏大的索引(用以满足未来更多的元素)；
将`leetcode300`代码修改如下即可:
```java
public int minOperations(int[] target, int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < target.length; ++i) {
        map.put(target[i], i);
    }
    int N = arr.length;
    int[] dp = new int[N];
    int len = 0;
    for (int n : arr) {
        int index = map.getOrDefault(n, -1);
        if (index != -1) {
            if (len == 0 || index > dp[len - 1]) {
                dp[len++] = index;
            } else {
                // 二分法查找
                int insertIndex = Arrays.binarySearch(dp, 0, len, index);
                if (insertIndex < 0) {
                    int t = -1 * (insertIndex + 1);
                    dp[t] = index;
                }
            }
        }
    }
    return target.length - len;
}
```

