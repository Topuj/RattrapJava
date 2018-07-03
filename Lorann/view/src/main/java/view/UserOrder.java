package view;

import controller.Order;

public class UserOrder implements IUserOrder {
    private final int   player;
    private final Order order;

    public UserOrder(final int player, final Order order) {
        this.player = player;
        this.order = order;
        // TODO Auto-generated constructor stub
    }

    public Order getOrder() {
        return this.order;
    }

    public int getPlayer() {
        return this.player;
    }

}
