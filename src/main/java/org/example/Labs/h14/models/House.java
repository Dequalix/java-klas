package org.example.Labs.h14.models;

import lombok.Data;
import org.example.Labs.h10.models.Human;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


@Data
public class House<T extends Human> implements Collection<T> {
    private ArrayList<T> inhabitants;

    public House(T inhabitant) {
        this.inhabitants = new ArrayList<>();
    }


    @Override
    public int size() {
        return inhabitants.size();
    }

    @Override
    public boolean isEmpty() {
        return inhabitants.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return inhabitants.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return inhabitants.iterator();
    }

    @Override
    public Object[] toArray() {
        return inhabitants.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return inhabitants.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return inhabitants.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return inhabitants.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return inhabitants.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return inhabitants.retainAll(c);
    }

    @Override
    public void clear() {
        inhabitants.clear();
    }
}
