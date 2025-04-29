class Person1 {
    protected String name;
    protected String id;

    public Person1(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person1 implements Worker {
    public Chef(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is cooking delicious meals!");
    }
}

class Waiter extends Person1 implements Worker {
    public Waiter(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers!");
    }
}

class RestaurantDemo {
    public static void main(String[] args) {
        Worker chef = new Chef("Gordon", "C001");
        Worker waiter = new Waiter("Alice", "W001");

        chef.performDuties();
        waiter.performDuties();
    }
}