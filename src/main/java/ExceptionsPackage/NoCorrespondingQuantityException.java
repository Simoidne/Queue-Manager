package ExceptionsPackage;

public class NoCorrespondingQuantityException extends Exception {
    @Override
    public String getMessage() {
        return "The size of the product list and product quantity list do not match for this order";
    }
}
