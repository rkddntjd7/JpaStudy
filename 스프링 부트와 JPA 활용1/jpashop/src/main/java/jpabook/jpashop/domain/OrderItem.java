package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) //연관관계 주인(1:n 관계에서 n 테이블에 fk 있는곳이 주인)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문 가격

    private int count; //주문 수량
}
