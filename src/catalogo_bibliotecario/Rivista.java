package catalogo_bibliotecario;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Rivista extends Lettura implements Serializable{
	private Frequenza periodicità;

	// Constructor
	public Rivista() {
	}

	public Rivista(Frequenza per) {
		super();
		this.periodicità = per;
	}

	// getter & setter
	public Frequenza getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Frequenza per) {
		this.periodicità = per;
	}

	@Override
	public String toString() {
		return "Rivista [periodicità=" + periodicità + "]";
	}
}
