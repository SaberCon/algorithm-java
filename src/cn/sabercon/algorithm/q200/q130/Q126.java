package cn.sabercon.algorithm.q200.q130;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Word Ladder II
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        wordList.add(beginWord);
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String key = word.substring(0, j) + '*' + word.substring(j + 1);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(i);
            }
        }
        int beginIndex = wordList.size() - 1;
        int endIndex = wordList.indexOf(endWord);
        if (endIndex < 0) {
            return result;
        }
        BitSet beginSet = new BitSet(wordList.size());
        BitSet endSet = new BitSet(wordList.size());
        beginSet.set(beginIndex);
        endSet.set(endIndex);
        Map<Integer, List<List<String>>> beginMap = new HashMap<>();
        List<List<String>> tempLists = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add(wordList.get(beginIndex));
        tempLists.add(tempList);
        beginMap.put(beginIndex, tempLists);
        Map<Integer, List<List<String>>> endMap = new HashMap<>();
        tempLists = new ArrayList<>();
        tempList = new ArrayList<>();
        tempList.add(wordList.get(endIndex));
        tempLists.add(tempList);
        endMap.put(endIndex, tempLists);
        boolean match = false;
        while (!beginMap.isEmpty() && !endMap.isEmpty()) {
            Map<Integer, List<List<String>>> tempBeginMap = new HashMap<>();
            for (Map.Entry<Integer, List<List<String>>> entry : beginMap.entrySet()) {
                String word = wordList.get(entry.getKey());
                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i) + '*' + word.substring(i + 1);
                    for (Integer e : map.get(key)) {
                        if (beginSet.get(e)) continue;
                        if (endSet.get(e)) {
                            addResult(result, entry.getValue(), endMap.get(e));
                            match = true;
                        }
                        if (!tempBeginMap.containsKey(e)) {
                            tempBeginMap.put(e, new ArrayList<>());
                        }
                        tempBeginMap.get(e).addAll(entry.getValue().stream().map(l -> {
                            List<String> list = new ArrayList<>(l.size() + 1);
                            list.addAll(l);
                            list.add(wordList.get(e));
                            return list;
                        }).collect(Collectors.toList()));
                    }
                }
            }
            beginMap = tempBeginMap;
            if (match) {
                break;
            }
            for (Integer integer : beginMap.keySet()) {
                beginSet.set(integer);
            }
            Map<Integer, List<List<String>>> tempEndMap = new HashMap<>();
            for (Map.Entry<Integer, List<List<String>>> entry : endMap.entrySet()) {
                String word = wordList.get(entry.getKey());
                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i) + '*' + word.substring(i + 1);
                    for (Integer e : map.get(key)) {
                        if (endSet.get(e)) continue;
                        if (beginSet.get(e)) {
                            addResult(result, beginMap.get(e), entry.getValue());
                            match = true;
                        }
                        if (!tempEndMap.containsKey(e)) {
                            tempEndMap.put(e, new ArrayList<>());
                        }
                        tempEndMap.get(e).addAll(entry.getValue().stream().map(l -> {
                            List<String> list = new ArrayList<>(l.size() + 1);
                            list.addAll(l);
                            list.add(wordList.get(e));
                            return list;
                        }).collect(Collectors.toList()));
                    }
                }
            }
            endMap = tempEndMap;
            if (match) {
                break;
            }
            for (Integer integer : endMap.keySet()) {
                endSet.set(integer);
            }
        }
        return result;
    }

    private void addResult(List<List<String>> result, List<List<String>> beginLists, List<List<String>> endLists) {
        beginLists.forEach(beginList -> {
            endLists.forEach(endList -> {
                List<String> list = new ArrayList<>(beginList.size() + endList.size());
                list.addAll(beginList);
                for (int i = endList.size() - 1; i >= 0; i--) {
                    list.add(endList.get(i));
                }
                result.add(list);
            });
        });

    }

    public static void main(String[] args) {
        Q126 q126 = new Q126();
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(q126.findLadders("hit", "cog", Arrays.stream(strings).collect(Collectors.toList())));
    }
}
