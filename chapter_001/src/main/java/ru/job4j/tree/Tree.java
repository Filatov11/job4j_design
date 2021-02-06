package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {

    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean res = false;
        Optional<Node<E>> par = findBy(parent);
        if (par.isPresent()) {
            Optional<Node<E>> chld = findBy(child);
            if (chld.isEmpty()) {
                par.get().children.add(new Node<>(child));
                res = true;
            }
        }
        return res;
    }

    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
           data.addAll(el.children);
        }
        return rsl;
    }






}

class Node<E> {
    final E value;
    final List<Node<E>> children = new ArrayList<>() ;
    public Node(E value) {
        this.value = value;
    }

}
