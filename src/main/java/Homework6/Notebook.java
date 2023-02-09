package Homework6;

public class Notebook {
    String id;
    String model;
    String processor;
    String ram;
    String hdd;
    String color;

    public Notebook(String id, String model, String processor,
                     String ram, String hdd, String color) {
        this.id = id;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.color = color;
    }

    public String toString() {
        return String.format("\nid:%s\nModel:%s\nProcessor:%s\nRAM:%s\nHDD:%s\nColor:%s",
                id, model, processor, ram, hdd, color);
    }

    public String GetInfo(String filter) {
        if (filter == "id") {
            return id;
        } else if (filter == "Model") {
            return model;
        } else if (filter == "Processor") {
            return processor;
        } else if (filter == "RAM") {
            return ram;
        } else if (filter == "HDD") {
            return hdd;
        } else if (filter == "Color") {
            return color;
        } else {
            return "id продукта - " + id;
        }
    }
}
