package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/three-sum/
*/

public class ThreeSum {
    List<List<Integer>> ret = new ArrayList<>();

    //works, doesnt run fast enough
    public List<List<Integer>> threeSum2(int[] nums) {
        ret = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        helper(list, new ArrayList<>());

        return ret;
    }

    void helper(List<Integer> nums, List<Integer> triplets) {
        if (triplets.size() == 3) {
            if (triplets.stream().reduce(Integer::sum).orElse(-1) == 0) {
                var alreadyPresent = ret.stream().anyMatch(l -> twoListsAreSame(l, triplets));
                if (!alreadyPresent) ret.add(triplets);
            }
            return;
        }

        ArrayList<Integer> cloneNums = new ArrayList<>(nums);

        for (int num : new ArrayList<>(cloneNums)) {
            cloneNums.remove(Integer.valueOf(num));
            ArrayList<Integer> cloneTriplets = new ArrayList<>(triplets);
            cloneTriplets.add(num);
            helper(cloneNums, cloneTriplets);
        }
    }

    static boolean twoListsAreSame(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) return false;

        var l1Copy = new ArrayList<>(l1);
        var l2Copy = new ArrayList<>(l2);

        Collections.sort(l1Copy);
        Collections.sort(l2Copy);

        for (int i = 0; i < l1.size(); i++) {
            if (!l1Copy.get(i).equals(l2Copy.get(i))) return false;
        }
        return true;
    }

    // doesnt work
    public List<List<Integer>> threeSum3(int[] nums) {

        List<List<Integer>> triplets = new ArrayList<>();

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                var sum = nums[i] + nums[j];
                List<Integer> list = Arrays.asList(nums[i], nums[j]);
                Collections.sort(list);
                map.putIfAbsent(sum, Collections.singletonList(list));
                map.computeIfPresent(sum, (integer, lists) -> {
                    var l = new ArrayList<>(lists);
                    if (!l.contains(list)) {
                        l.add(list);
                    }
                    return l;
                });
            }
        }

        for (int num : nums) {
            var key = num * -1;
            if (map.containsKey(key)) {
                var lists = map.get(key);
                lists.forEach(list -> {
                    var copy = new ArrayList<>(list);
                    copy.add(num);
                    triplets.add(copy);
                });

            }
        }
        return triplets;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        int target = 0;

        if (nums.length < 3) return Collections.emptyList();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            var current = nums[i];


            while (left < right) {
                int sum = current + nums[left] + nums[right];
                if (sum == target) {
                    ret.add(Arrays.asList(current, nums[left], nums[right]));

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(ret);
    }

}
