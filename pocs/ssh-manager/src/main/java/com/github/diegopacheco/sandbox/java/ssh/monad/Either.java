package com.github.diegopacheco.sandbox.java.ssh.monad;

import java.util.Optional;

/**
 * Monadic implementation of Left/Right monad in java.
 * 
 * @author diegopacheco
 *
 * @param <T> Could be ANY type.
 */
public class Either<T> {

	private Optional<T> right;
	private Optional<T> left;

	public Either(T right, T left) {
		super();
		this.right = Optional.ofNullable(right);
		this.left = Optional.ofNullable(left);
	}
	
  public static <U> Either<U> ok(U value) {
    return new Either<>(value, null);
  }

  public static <U> Either<U> right(U value) {
    return new Either<>(value, null);
  }
  
  public static <U> Either<U> error(U error) {
    return new Either<U>(null, error);
  }
  
  public static <U> Either<U> left(U error) {
    return new Either<U>(null, error);
  }
	
	public boolean hasError() {
		return left.isPresent();
	}

	public T getValue() {
		return right.get();
	}
	
  public T getError() {
    return left.get();
  }
	
}
