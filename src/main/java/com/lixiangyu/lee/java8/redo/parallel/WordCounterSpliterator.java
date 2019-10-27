package com.lixiangyu.lee.java8.redo.parallel;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-30 21:23
 **/
public class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //处理当前的字符
        action.accept(string.charAt(currentChar++));
        //如果还有字符要处理，则返回TRUE
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10) {
            //返回空表示要解析的string已经足够小，可以顺序处理
            return null;
        }
        //让拆分位置前进直到下一个空格
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            if(Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                //将这个WordCounterSpliterator得起始位置设为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return Spliterator.ORDERED + Spliterator.SIZED + Spliterator.SUBSIZED + Spliterator.NONNULL + Spliterator.IMMUTABLE;
    }
}
