// Single Responsibility Principle (SRP)
class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculatePrice();
        }
        return total;
    }
}

class OrderItem {
    private String product;
    private double price;
    private int quantity;

    public OrderItem(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculatePrice() {
        return price * quantity;
    }
}

// Open-Closed Principle (OCP)
interface Discount {
    double applyDiscount(double originalPrice);
}

class RegularDiscount implements Discount {
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.9; // 10% discount
    }
}

class PremiumDiscount implements Discount {
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.8; // 20% discount
    }
}

// Liskov Substitution Principle (LSP)
class RegularCustomer {
    public double calculateDiscount(Discount discount, double originalPrice) {
        return discount.applyDiscount(originalPrice);
    }
}

// Interface Segregation Principle (ISP)
interface OnlineOrder {
    void placeOnlineOrder();
}

interface OfflineOrder {
    void placeOfflineOrder();
}

class OnlineOfflineOrder implements OnlineOrder, OfflineOrder {
    @Override
    public void placeOnlineOrder() {
        // Implementation for placing an online order
    }

    @Override
    public void placeOfflineOrder() {
        // Implementation for placing an offline order
    }
}

// Dependency Inversion Principle (DIP)
interface MessageSender {
    void sendMessage(String message);
}

class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // Implementation to send an email
    }
}

class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // Implementation to send an SMS
    }
}

class NotificationService {
    private MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void sendNotification(String message) {
        sender.sendMessage(message);
    }
}
