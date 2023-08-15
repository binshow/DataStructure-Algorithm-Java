package backtracking._集合划分问题;

public class _698划分成K个相等的子集 {


    // 分成k个桶，每个数都可以放到每个桶中
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        // k个桶
        int[] bucket = new int[k];
        return dfs(nums , 0 , sum / k , bucket);
    }

    private boolean dfs(int[] nums, int start, int target, int[] bucket) {
        if (start == nums.length) {
            // 检查每个桶是否满足要求
            for (int tem : bucket){
                if (tem != target) return false;
            }
            return true;
        }

        // 遍历每个桶
        for (int i = 0 ; i < bucket.length ; i++){
            // 剪枝1：放入球后超过 target 的值，选择一下桶
            if (bucket[i] + nums[start] > target) continue;

            // 剪枝2：// 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if(i > 0 && bucket[i] == bucket[i-1]) continue;

            // 当前数放入桶中
            bucket[i] += nums[start];
            if (dfs(nums , start+1 , target , bucket)) return true;
            bucket[i] -= nums[start];

        }

        return false;
    }


    // 球选择桶
    private boolean backtrack(int[] nums, int start, int[] bucket, int k, int target, boolean[] used) {
        // k 个桶均装满
        if (k == 0) return true;
        // 当前桶装满了，开始装下一个桶
        if (bucket[k] == target) {
            // 注意：桶从下一个开始；球从第一个开始
            return backtrack(nums, 0, bucket, k - 1, target, used);
        }
        // 第 k 个桶开始对每一个球选择进行选择是否装入
        for (int i = start; i < nums.length; i++) {
            // 如果当前球已经被装入，则跳过
            if (used[i]) continue;
            // 如果装入当前球，桶溢出，则跳过
            if (bucket[k] + nums[i] > target) continue;

            // 装入 && 标记已使用
            bucket[k] += nums[i];
            used[i] = true;

            // 开始判断是否选择下一个球
            // 注意：桶依旧是当前桶；球是下一个球
            // 注意：是 i + 1
            if (backtrack(nums, i + 1, bucket, k, target, used)) return true;

            // 拿出 && 标记未使用
            bucket[k] -= nums[i];
            used[i] = false;
        }
        // 如果所有球均不能使所有桶刚好装满
        return false;
    }

}
