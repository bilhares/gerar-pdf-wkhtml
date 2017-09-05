package br.com.psg.entities;

public enum Artigo {
	ARTIGO_261(0, "261"),
	ARTIGO_263(1, "263"),
	ARTIGO_148(2, "148"),
	ARTIGO_165(3, "165"),
	ARTIGO_263I(4, "263-I"),
	ARTIGO_263II(5, "263-II");
	
	private int id;
	private String name;
	
	private Artigo(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
