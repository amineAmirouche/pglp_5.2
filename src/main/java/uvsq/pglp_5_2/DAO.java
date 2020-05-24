package uvsq.pglp_5_2;

public interface DAO<T> {
	
	/*
	 * CRUD:
	 *  - Create
	 *  - Read
	 *  - Update
	 *  - Delete
	 */
	public boolean create(T obj);
	public boolean read(String id);
	public boolean update(T obj);
	public boolean delete(T obj);

}
