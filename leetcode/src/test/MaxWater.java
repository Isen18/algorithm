/**
 * @author Isen
 * @date 2020/9/16 0:14
 * @since 1.0
 */
public class MaxWater {

    public static int maxArea(int[] height) {
        int s = 0;
        int t = height.length - 1;
        int res = 0;
        int minIdx;
        int tmpRes;
        while(s < t) {
            minIdx = height[s] < height[t] ? s : t;
            tmpRes = height[minIdx] * (t - s);
            if (res < tmpRes) {
                res = tmpRes;
            }
            if (minIdx == s) {
                while (s < t && height[s + 1] < height[s]) {
                    s++;
                }
                if (minIdx == s) {
                    s++;
                }
            } else {
                while (s < t && height[t - 1] < height[t]) {
                    t--;
                }
                if (minIdx == t) {
                    t--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};

        int res = maxArea(arr);

        System.out.println(res);
    }
}
