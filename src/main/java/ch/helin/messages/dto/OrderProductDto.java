package ch.helin.messages.dto;

public class OrderProductDto {

    private ProductDto product;
    private Integer amount;
    private Double totalPrice;

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProductDto)) return false;

        OrderProductDto that = (OrderProductDto) o;

        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return totalPrice != null ? totalPrice.equals(that.totalPrice) : that.totalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
