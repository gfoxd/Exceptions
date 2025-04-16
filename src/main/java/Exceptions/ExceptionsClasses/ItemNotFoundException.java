package Exceptions.ExceptionsClasses;

public class ItemNotFoundException extends RuntimeException {
  public ItemNotFoundException(String message) {
    super(message);
  }
}
