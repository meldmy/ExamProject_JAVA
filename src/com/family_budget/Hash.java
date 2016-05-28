package com.family_budget;

/**
 * Created by Dmytro Melnychuk on 16/05/16.
 */
public class Hash {
    public int key;
    public String name;
    Hash(int key, String name) {
        this.key=key;
        this.name=name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return key + " ";
    }
}
