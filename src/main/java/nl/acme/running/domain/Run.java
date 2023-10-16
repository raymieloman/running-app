package nl.acme.running.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Run implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String start;
	private String finish;
	private int distance;


	public long getId(){ 
		return this.id;
	}

	public void setId(long id){ 
		this.id=id;
	}

	public String getStart(){ 
		return this.start;
	}

	public void setStart(String start){ 
		this.start=start;
	}

	public String getFinish(){ 
		return this.finish;
	}

	public void setFinish(String finish){ 
		this.finish=finish;
	}

	public int getDistance(){ 
		return this.distance;
	}

	public void setDistance(int distance){ 
		this.distance=distance;
	}

}
