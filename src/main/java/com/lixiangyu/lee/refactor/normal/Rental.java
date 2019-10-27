package com.lixiangyu.lee.refactor.normal;

/**
 * @program: leecode
 * @description: 租赁
 * @author: lixiangyu
 * @create: 2019-07-26 10:49
 **/
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }



    public double getCharge() {
        int result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR :
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return result;
    }
}
