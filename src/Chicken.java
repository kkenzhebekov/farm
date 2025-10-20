class Chicken extends Animal {
    Chicken(String n, int a) {
        super(n, a);
        type = AnimalType.CHICKEN;
    }

    ProductType produce() {
        return ProductType.EGG;
    }
}