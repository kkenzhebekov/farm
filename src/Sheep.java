class Sheep extends Animal {
    Sheep(String n, int a) {
        super(n, a);
        type = AnimalType.SHEEP;
    }

    ProductType produce() {
        return ProductType.WOOL;
    }
}