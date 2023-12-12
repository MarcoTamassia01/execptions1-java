package model.exceptions;

public class DomainExcepetion extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainExcepetion(String msg) {
		super(msg);
	}
}
