package io;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @packgeName: io
 * @ClassName: E17_CharactersInfo
 * @copyright: CopyLeft
 * @description:<描述>  统计字符出现次数，并排序
 * @author: lili
 * @date: 2017/9/9-12:12
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E17_CharactersInfo {

    public static void countWords(final String fileName) {

        Map<String, Integer> wordsStat = new HashMap<String, Integer>();
        //根据文本文件中的字符进行拆分
        for (String word : new TextFile(fileName, "\\W+")) {
            Integer freq = wordsStat.get(word);
            wordsStat.put(word, freq == null ? 1 : freq + 1);
        }
        List<String> keys = Arrays.asList(wordsStat.keySet().toArray(new String[0]));
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + " =====> " + wordsStat.get(key));
        }
    }

    public static void countChars(final String fileName) {

        Map<Character, Integer> charsStat = new HashMap<Character, Integer>();

        for (String word : new TextFile(fileName, "\\W+")) {
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                Integer freq = charsStat.get(c);
                charsStat.put(c, freq == null ? 1 : freq + 1);
            }
        }
        List<Character> keys = Arrays.asList(charsStat.keySet().toArray(new Character[0]));
        Collections.sort(keys);
        for (Character key : keys) {
            System.out.println(key + " =====> " + charsStat.get(key));
        }
    }

    public static void main(String[] args) {

        String path = "D:\\MavenSpace\\thinkinjava\\solutions\\src\\main\\java\\io\\E17_CharactersInfo.java";
        countWords(path);
        System.out.println("------------------------------------");
        countChars(path);

    }

}
