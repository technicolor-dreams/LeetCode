package io.github.technicolordreams.question.of.the.day.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1><a href="https://leetcode.com/problems/product-of-the-last-k-numbers/description/">1352. Product of the Last K Numbers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-14</h3>
 */
public class ProductOfNumbers {

    private final List<Integer> prefix;

    public ProductOfNumbers() {
        this.prefix = new ArrayList<>();
        this.prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            this.prefix.clear();
            this.prefix.add(1);
        } else {
            this.prefix.add(this.prefix.getLast() * num);
        }
    }

    public int getProduct(int k) {
        int size = this.prefix.size();
        if (k >= size) {
            return 0; // If k is larger than available numbers (due to zero reset)
        }

        return this.prefix.getLast() / this.prefix.get(size - k - 1);
    }
}
