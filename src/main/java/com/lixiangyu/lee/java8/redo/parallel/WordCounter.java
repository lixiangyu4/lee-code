package com.lixiangyu.lee.java8.redo.parallel;

/**
 * @program: leecode
 * @description: 实现自己的Spliterator
 * @author: lixiangyu
 * @create: 2019-05-30 20:59
 **/
public class WordCounter {

    private final int counter;
    private final boolean lastSapce;

    public WordCounter(int counter, boolean lastSapce) {
        this.counter = counter;
        this.lastSapce = lastSapce;
    }

    public WordCounter accumulate(Character c) {
        if(Character.isWhitespace(c)) {
            return lastSapce? this : new WordCounter(counter, true);
        } else {
            return lastSapce?new WordCounter(counter + 1, false):this;
        }
    }

    /**
     * 合并两个wordCounter,把其计数器加起来
     * @param wordCounter
     * @return
     */
    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSapce);
    }

    public int getCounter() {
        return counter;
    }

}
