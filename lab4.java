public class ProductionOrder implements Runnable {

    private String orderId;
    private int quantity;
    private int availableStock;

    ProductionOrder(String orderId, int quantity, int availableStock) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }

    public void processOrder() throws Exception {

        if (quantity <= 0) {
            throw new Exception("Invalid order quantity!");
        }

        if (quantity > availableStock) {
            throw new Exception(
                "Insufficient stock for Order " + orderId +
                ". Required: " + quantity +
                ", Available: " + availableStock
            );
        }

        System.out.println(
            Thread.currentThread().getName() +
            " started processing Order " + orderId
        );

        Thread.sleep(1000);

        availableStock -= quantity;

        System.out.println(
            Thread.currentThread().getName() +
            " completed Order " + orderId
        );

        System.out.println(
            "Remaining Stock for " + orderId +
            ": " + availableStock
        );

        System.out.println("--------------------------------");
    }

    @Override
    public void run() {

        try {
            processOrder();

        } catch (Exception e) {

            System.out.println(
                Thread.currentThread().getName() +
                " Error: " + e.getMessage()
            );

            System.out.println("--------------------------------");
        }
    }
}

public class lab4 {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   OPERATIONS MANAGEMENT SYSTEM");
        System.out.println("========================================");

        ProductionOrder order1 =
            new ProductionOrder("ORD101", 30, 100);

        ProductionOrder order2 =
            new ProductionOrder("ORD102", 50, 80);

        ProductionOrder order3 =
            new ProductionOrder("ORD103", 120, 100);

        ProductionOrder order4 =
            new ProductionOrder("ORD104", -10, 50);

        Thread t1 = new Thread(order1, "Production Thread 1");
        Thread t2 = new Thread(order2, "Production Thread 2");
        Thread t3 = new Thread(order3, "Production Thread 3");
        Thread t4 = new Thread(order4, "Production Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {

            System.out.println(
                "Main thread interrupted: " + e.getMessage()
            );
        }

        System.out.println("========================================");
        System.out.println("All production orders processed.");
        System.out.println("========================================");
    }
} {
    
}
