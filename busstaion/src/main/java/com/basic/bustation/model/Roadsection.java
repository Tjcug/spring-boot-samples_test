package com.basic.bustation.model;

/**
 * Roadsection entity. @author MyEclipse Persistence Tools
 */

public class Roadsection implements java.io.Serializable {

	// Fields

	private Long id;
	private Roadstation roadstationByEndid;
	private Roadstation roadstationByStartid;
	private String name;
	private Double elapsedtime;

	// Constructors

	/** default constructor */
	public Roadsection() {
	}

	/** full constructor */
	public Roadsection(Roadstation roadstationByEndid,
			Roadstation roadstationByStartid, String name, Double elapsedtime) {
		this.roadstationByEndid = roadstationByEndid;
		this.roadstationByStartid = roadstationByStartid;
		this.name = name;
		this.elapsedtime = elapsedtime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roadstation getRoadstationByEndid() {
		return this.roadstationByEndid;
	}

	public void setRoadstationByEndid(Roadstation roadstationByEndid) {
		this.roadstationByEndid = roadstationByEndid;
	}

	public Roadstation getRoadstationByStartid() {
		return this.roadstationByStartid;
	}

	public void setRoadstationByStartid(Roadstation roadstationByStartid) {
		this.roadstationByStartid = roadstationByStartid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getElapsedtime() {
		return this.elapsedtime;
	}

	public void setElapsedtime(Double elapsedtime) {
		this.elapsedtime = elapsedtime;
	}

}
