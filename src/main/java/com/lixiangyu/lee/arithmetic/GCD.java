package com.lixiangyu.lee.arithmetic;

/**
 * @program: leecode
 * @description: 最大公约数
 * @author: lixiangyu
 * @create: 2018-12-20 21:59
 **/
public class GCD {

    /**
     * 若q是0，则最大公约数是p。否则，将p除以q得到余数r,p和q的最大公约数即为q和r的最大公约数
     * @param p
     * @param q
     * @return
     */
    private static int gcd(int p, int q) {

        if(q == 0) {
            return p;
        }
        int r = p % q;

        return gcd(q , r);

    }

    public static void main(String[] args) {
        System.out.println(gcd(10 , 6));
    }

}
