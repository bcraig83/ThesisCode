package ie.lyit.analysis.factory;

/**
 * The Interface Factory.
 *
 * @param <T> the generic type
 */
public interface Factory<T> {
	
	/**
	 * Creates an instance of the generic type, T.
	 *
	 * @return the t
	 */
	public T create();
}
