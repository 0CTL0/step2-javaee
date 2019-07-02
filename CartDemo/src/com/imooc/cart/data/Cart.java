package com.imooc.cart.data;

/**
 *
 * 购物车
 * 理解：应该指的是购车中的单个订单，这里有点误导人,这视频的人的对象逻辑搞得我有点乱
 *
 * @version 1.0
 */
public class Cart {

    public Cart(Long id, Long productId, String name, int price, int count) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = price * count;
    }

    private Long id;

    private Long productId;

    private String name;

    private int price;

    private int count;

    private int totalPrice;

    //添加一次购物车，订单数量+1
    public void incrCount() {
        count++;
        this.totalPrice = price * count;
    }
    //减少商品的订单数量
    public boolean decrCount() {
        count--;
        this.totalPrice = price * count;
        if (0 == count) {
            return true;
        }
        return false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


}
