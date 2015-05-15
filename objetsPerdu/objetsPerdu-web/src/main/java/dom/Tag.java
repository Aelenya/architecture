package dom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Entity
//@Table(name = "TAGLIST")
@JsonPropertyOrder({"value"})
public class Tag implements Serializable{

	private static final long serialVersionUID = -686694274703872720L;

	@Id
	@NotNull
	@Column(length = 64)
	@JsonProperty("value")
	private String value;
	@NotNull
	@Column
	private int importance;
	
	@JsonProperty("value")
	public void setValue(String value){
		this.value = value;
	}
	@JsonProperty("value")
	public String getValue(){
		return value;
	}
	public void setImportance(int importance){
		this.importance = importance;
	}
	public int getImportance(){
		return importance;
	}
}
