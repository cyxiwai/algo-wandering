package com.xiwai.algorithm.augu1;

public class num59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();

        int[][] ans = solution59.generateMatrix(40);
        print2DArray(ans);

    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) { // 遍历每一行
            for (int j = 0; j < array[i].length; j++) { // 遍历每一列
                System.out.print(array[i][j] + " "); // 打印当前元素，并在后面加一个空格
            }
            System.out.println(); // 打印完一行后换行
        }
    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int offset = 0;

        int loop = n / 2;
        int count = 1;
        int[][] abc = new int[n][n];
        int i = 0;
        int j = 0;
        while ((loop--) > 0) {
            i = offset;
            j = offset;
            offset++;
            //上层左闭右闭循环
            for (; j < n - offset; j++) {
                abc[i][j] = count++;
            }
            //右层左闭右闭循环
            for (; i < n - offset; i++) {
                abc[i][j] = count++;
            }
            //下层左闭右闭循环
            for (; j >= offset; j--) {
                abc[i][j] = count++;
            }
            //左层左闭右闭循环
            for (; i >= offset; i--) {
                abc[i][j] = count++;
            }
        }
        if (n % 2 != 0) {
            int middle = n / 2;
            abc[middle][middle] = n * n;
        }
        return abc;
    }
}


//明天将是训练营正式开始第二天，day2 的任务：https://docs.qq.com/doc/DUHdxS2FNTlNTVGps  （任务是提前一天发布，方便已经工作的录友早上通勤可以先看题）
//
//刷题的时候，遇到了疑问，可以@卡哥助手 进行答疑，当然我也会看大家们的问题。
//
//相同语言的录友，可以多交流，毕竟本群大家都是相同刷题进度。
//
//43期打卡名单：https://docs.qq.com/sheet/DUFRZeVVwR2lxd3Zr?tab=BB08J2 （没在名单里的录友可以自己补一下），大家可以相互监督，看谁坚持到了最后，打卡坚持到最后有惊喜！（什么是惊喜当然是最后一天才能说），每天我们会统计打卡情况，为了照顾海外录友，一般是当天晚上统计前天的打卡情况。 是可以补卡的，所以有突发情况 大家记得补上卡。
//
//博客以及打卡方式：https://docs.qq.com/doc/DUEdmb1JCaEtlZWFx ，希望训练营可以帮大家养成写博客的习惯，会受益终生。
//
//每日精华：https://www.yuque.com/chengxuyuancarl/wnx1np/ktwax2 （每日更新），先看看刷题建议和如何debug，以及往期录友们的博客，学习一下如何写博客。 大家在群里讨论的问题，每天都会做总结，然后放在每日精华里，方便大家回顾。
//
//以上 一共有 四个链接，大家可以固定在电脑浏览器上，都是每日更新的，刷新一下就好。
//
//最后，训练营为期60天，希望训练营录友们可以坚持下去，迎来两个月后的脱变，加油💪