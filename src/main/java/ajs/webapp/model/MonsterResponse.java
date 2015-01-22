package ajs.webapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Maria
 *
 */
public class MonsterResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3986904288474571373L;

	private List<Monster> monster;

	private Errors errors;

	private Integer totalRows;

	public MonsterResponse() {
		super();
	}

	public MonsterResponse(List<Monster> monster, Errors errors,
			Integer totalRows) {
		super();
		this.monster = monster;
		this.errors = errors;
		this.totalRows = totalRows;
	}

	public List<Monster> getMonster() {
		return monster;
	}

	public void setMonster(List<Monster> monster) {
		this.monster = monster;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

}
