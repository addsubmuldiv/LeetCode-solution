package easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 23:58 2017/10/13
 * @Modified_by:
 */
public class Keyboard_Row_500 {
    /**
     * 和我想法一样，但是写法要聪明不少，把部分费力的功夫用循环和一些已有的库函数来实现了，还有最后的toArray方法，
     * 可以将List转成想要类型的数组，值得学习
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }
}

/*
        非常牛逼的写法，用了Stream API，代码无比优美，但是奇慢无比……
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
 */

/*
        自己想出来的写法，一开始把所有的字幕全部添加到一个哈希表里，
        在键盘上是同一行的具有相同的值，所以每次保存单词的第一个字母的
        在哈希表中对应的值，然后把剩余的字母扫描一遍，看他们对应的值是否一致
        如果一致则添加到列表中，然后转换成数组返回，虽然只打败了30%多，但比使用
        Stream API的装逼写法快的多
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(new Character('q'), new Integer(1));
        map.put(new Character('w'), new Integer(1));
        map.put(new Character('e'), new Integer(1));
        map.put(new Character('r'), new Integer(1));
        map.put(new Character('t'), new Integer(1));
        map.put(new Character('y'), new Integer(1));
        map.put(new Character('u'), new Integer(1));
        map.put(new Character('i'), new Integer(1));
        map.put(new Character('o'), new Integer(1));
        map.put(new Character('p'), new Integer(1));
        map.put(new Character('a'), new Integer(2));
        map.put(new Character('s'), new Integer(2));
        map.put(new Character('d'), new Integer(2));
        map.put(new Character('f'), new Integer(2));
        map.put(new Character('g'), new Integer(2));
        map.put(new Character('h'), new Integer(2));
        map.put(new Character('j'), new Integer(2));
        map.put(new Character('k'), new Integer(2));
        map.put(new Character('l'), new Integer(2));
        map.put(new Character('z'), new Integer(3));
        map.put(new Character('x'), new Integer(3));
        map.put(new Character('c'), new Integer(3));
        map.put(new Character('v'), new Integer(3));
        map.put(new Character('b'), new Integer(3));
        map.put(new Character('n'), new Integer(3));
        map.put(new Character('m'), new Integer(3));


        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            int flag = map.get(new Character(words[i].toLowerCase().charAt(0))).intValue();
            boolean ifok = true;
            for (int j = 1; j < length; j++) {
                if (flag != map.get(words[i].toLowerCase().charAt(j)).intValue()) {
                    ifok = false;
                    break;
                }
            }
            if (ifok)
                res.add(words[i]);
        }
        String[] strings = new String[res.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = res.get(i);
        }
        return strings;
*/
