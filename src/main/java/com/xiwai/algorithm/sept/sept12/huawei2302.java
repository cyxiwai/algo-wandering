package com.xiwai.algorithm.sept.sept12;

import java.util.Arrays;
import java.util.Scanner;

public class huawei2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movement m = new Movement();
        while (true) {
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            if (strs[0].equals("insert")) {
                m.insert(strs[1]);
            }
            if (strs[0].equals("move")) {
                int cnt = Integer.parseInt(strs[1]);
                m.move(cnt);
            }
            if (strs[0].equals("delete")) {
                int len = Integer.parseInt(strs[1]);
                if (len < 0) {
                    continue;
                }
                m.delete(len);
            }
            if (strs[0].equals("copy")) {
                m.copy();
            }
            if (strs[0].equals("end")) {
                break;
            }
        }
        m.showCase();
    }
}

class Movement {
    private char[] fi_str = new char[16001];
    public StringBuffer sb = new StringBuffer();

    private int index = 0;
    private int size = 1;

    public void showCase() {
        char[] temp = Arrays.copyOfRange(fi_str, 0, size);
        System.out.println(new String(temp));
    }

    public void insert(String s) {
        char[] s_toChar = s.toCharArray();
        for (int i = s.length() + size - 1; i > size && i >= s.length(); i--) {
            fi_str[i] = fi_str[i - s.length()];
        }
        for (int i = index; i < index + s.length(); i++) {
            fi_str[i] = s_toChar[i - index];
        }
        index += s.length();
        fi_str[index] = '|';
        size += s.length();
    }

    public void move(int cnt) {
        if (cnt + index >= size || cnt + index < 0) {
            return;
        } else {
            if (cnt > 0) {
                for (int i = index; i < index + cnt; i++) {
                    fi_str[i] = fi_str[i + 1];
                }
            } else {
                for (int i = index; i > index + cnt; i--) {
                    fi_str[i] = fi_str[i - 1];
                }
            }
            index += cnt;
            fi_str[index] = '|';
        }
    }

    public void delete(int len) {
        if (len < 0) {
            return;
        }
        if (index-len < 0) {
            return;
        } else {
            char[] temp = Arrays.copyOfRange(fi_str, index, size);
            index -= len;
            for (int i = index; i < size - len; i++) {
                fi_str[i] = temp[i - index];
            }
            for (int i = size - len; i < size; i++) {
                fi_str[i] = ' ';
            }
            size -= len;
        }
    }

    public void copy() {
        for (int i = index + size - 1; i > size; i--) {
            fi_str[i] = fi_str[i - index];
        }
        for (int i = index + 1; i < index + 1 + index; i++) {
            fi_str[i] = fi_str[i - index - 1];
        }
        size += index;
    }
}

