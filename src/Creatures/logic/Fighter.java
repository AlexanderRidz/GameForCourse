package Creatures.logic;

public interface Fighter<T> {
    void damage(T target);
    void getDamage(T target);
}
