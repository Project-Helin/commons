package ch.helin.messages.dto;

public class ProductDto {

    private String name;

    private Double price;

    private Integer weightGramm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeightGramm() {
        return weightGramm;
    }
}
