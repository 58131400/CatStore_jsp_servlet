/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bean;

public class Role {
	private String id;
	private String name;
	private String description;
	
	public Role(String id, String name, String description) {
		super();
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
