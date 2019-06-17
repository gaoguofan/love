package com.bkn.browser.utils;

import java.util.Arrays;

public class SortingAlgorithmUtils {

    private static Integer[] sorts = {5,2,6,7,1,4};
    
   /**
    * 经典插入排序法
    * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
    * --排序扑克牌
   * @author 高国藩
   * @date 2017年3月17日 下午12:42:58
   * @return
    */
    public static int[] insertSort() {
        for (int i = 1; i < sorts.length; i++) {
            int j = i;
            int temp = sorts[i];
            while (j > 0 && sorts[j-1] > temp) {
                sorts[j] = sorts[j-1];
                j--;
            }
            sorts[j] = temp;
            System.out.println(Arrays.asList(sorts).toString());
        }
        return null;
    }
    
    /**
     * 经典冒泡排序
    * @author 高国藩
    * @date 2017年3月17日 上午11:59:52
    * @return
     */
    public static int[] bubbleAlor() {
        
        for (int i = 0; i < sorts.length; i++) {
            for (int j = 1; j < sorts.length - i; j++) {
                int temp = sorts[j-1];
                if (sorts[j] < sorts[j-1]){
                    sorts[j-1] = sorts[j];
                    sorts[j] = temp;
                    System.out.println(Arrays.asList(sorts).toString());
                }
            }
        }
        return null;
    }
    
    /**
     * 简单选择排序
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换； 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。 
    * @author 高国藩
    * @date 2017年3月17日 下午2:01:52
    * @return
     */
    public static int[] sampileSelect() {
        
        for (int i = 0; i < sorts.length-1; i++) {
            int j = i + 1;
            int temp = sorts[i];
            for (; j < sorts.length-1; j++) {
                if (temp > sorts[j]) temp = sorts[j];
            }
            sorts[j] = sorts[i];
            sorts[i] = temp;
            System.out.println(Arrays.asList(sorts).toString());
        }
        
        return null;
    }
    
    
    /**
     * 快速排序,分治数组
     * 1.把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；交换了以后再和小的那端比，比它小不交换，比他大交换。
     * 2.这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
     * 
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(Integer[] numbers, int low, int high) {
        int temp = numbers[low];            // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];   // 比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low];   // 比中轴大的记录移到高端
        }
        numbers[low] = temp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }
    
    /**
     * 快速排序递归调用
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(Integer[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);  // 对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
        }
    }
    
    public static void main(String[] args) {
        quickSort(sorts, 0, sorts.length-1);
        System.out.println(Arrays.asList(sorts).toString());
    }
    
}
