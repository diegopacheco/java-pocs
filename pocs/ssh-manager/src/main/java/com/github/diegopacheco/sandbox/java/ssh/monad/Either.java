package com.github.diegopacheco.sandbox.java.ssh.monad;

import java.util.Optional;

/**
 * Monadic implementation of Left/Right monad in java.
 * 
 * @author diegopacheco
 *
 * @param <T,E> Could be ANY type.
 */
public class Either<T,E> {

	private Optional<T> right;
	private Optional<E> left;

	public Either(T right, E left) {
		super();
		this.right = Optional.ofNullable(right);
		this.left = Optional.ofNullable(left);
	}
	
  public static <U,X> Either<U,X> ok(U value) {
    return new Either<>(value, null);
  }

  public static <U,X> Either<U,X> right(U value) {
    return new Either<>(value, null);
  }
  
  public static <U,X> Either<U,X> error(X error) {
    return new Either<U,X>(null, error);
  }
  
  public static <U,X> Either<U,X> left(X error) {
    return new Either<U,X>(null, error);
  }
	
	public boolean hasError() {
		return left.isPresent();
	}

	public T getValue() {
		return right.get();
	}
	
  public E getError() {
    return left.get();
  }
  
  public void print() {
  	if(hasError())
  		System.out.println(getError());
  	else	
  		System.out.println(getValue());  	
  }
	
}
