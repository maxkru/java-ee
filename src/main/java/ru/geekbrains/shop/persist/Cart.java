package ru.geekbrains.shop.persist;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Entity
public class Cart implements Serializable {

    @OneToMany(orphanRemoval = true)
    private final List<LineItem> items;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToMany
//    private HashMap<LineItem, Integer> itemQtyHashMap;

    public Cart(Integer id, List<LineItem> items) {
        this.id = id;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @OneToMany
//    public List<LineItem> getItems() {
//        itemQtyHashMap.clear();
//        for (LineItem item : items) {
//            itemQtyHashMap.put(item, item.getQty());
//        }
//        return items;
//    }
//
//    public void setItems(List<LineItem> items) {
//        this.items = items;
//        itemQtyHashMap.clear();
//        for (LineItem item : items) {
//            itemQtyHashMap.put(item, item.getQty());
//        }
//    }
//
//    public HashMap<LineItem, Integer> getItemQtyHashMap() {
//        return itemQtyHashMap;
//    }
}
