package com.day04_more;

import java.util.Scanner;

/**
 * @PackageName: com.day04_more
 * @ClassName: Test04
 * @Author: Wangzhengbo
 * @Date: 2019/10/31 19:22
 * @Description:
 * 提示用户键盘录入一个包含数字和字母的字符串（不做是否包含数字和字母的判断），
 * 遍历字符串分别筛选出数字和字母，按照数字在前字母在后的规则组成一个新的字符串并打印在控制台
 */
public class Test04 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //输出提示信息,提示用户键盘录入一个包含数字和字母的字符串
        System.out.println("请输入一个字符串包含字母和数字:");
        //定义str接收键盘录入的字符串
//        StringBuilder str = new StringBuilder(sc.nextLine());
        String str = sc.nextLine();
        //创建StringBuilder类的变量numSb存储字符串str中的数字
        StringBuilder numSb = new StringBuilder();
        //创建StringBuilder类的变量letterSb存储字符串str中的字母
        StringBuilder letterSb = new StringBuilder();
        //for循环遍历字符串中元素,筛选出数字和字母
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                numSb.append(str.charAt(i));
            }else{
                letterSb.append(str.charAt(i));
            }
        }
        numSb.append(letterSb);
        System.out.println(numSb);
    }
}
