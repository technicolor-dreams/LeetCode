package io.github.technicolordreams.question.of.the.day.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * <h1><a href="https://leetcode.com/problems/design-a-number-container-system/description/">2349. Design a Number Container System</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-08</h3>
 */
public class NumberContainers {

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }

    private final Map<Integer, Integer> map;
    private final Map<Integer, Set<Integer>> indexMap;

    public NumberContainers() {
        this.map = new HashMap<>();
        this.indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        System.out.println("change index: " + index + " number: " + number);
        System.out.println("map: " + this.map);
        System.out.println("indexMap: " + this.indexMap);
        if (this.map.containsKey(index)) {
            this.indexMap.computeIfPresent(this.map.get(index), (k, v) -> {
                v.remove(index);
                return v;
            });

            if (this.indexMap.get(this.map.get(index)).isEmpty()) {
                this.indexMap.remove(this.map.get(index));
            }
        }

        this.map.put(index, number);
        this.indexMap.putIfAbsent(index, new TreeSet<>());
        this.indexMap.computeIfPresent(number, (k, v) -> {
            v.add(index);
            return v;
        });
    }

    public int find(int number) {
        System.out.println("find number: " + number);
        System.out.println("map: " + this.map);
        System.out.println("indexMap: " + this.indexMap);
        return this.indexMap.getOrDefault(number, Set.of(-1)).stream().findFirst().orElse(-1);
    }
}
