package es.codeurjc.test.ahorcado;

public class Horca {

	private int partesCuerpo = 0;
	private String[] ahorcados = new String[7];

	public Horca() {

		//formatter_off
		
		ahorcados[0] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[1] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[2] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|     [ ]      \n" + 
				"|     [_]      \n" + 
				"|              \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[3] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|  x--[ ]      \n" + 
				"|     [_]      \n" + 
				"|              \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[4] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|  x--[ ]--x   \n" + 
				"|     [_]      \n" + 
				"|              \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[5] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|  x--[ ]--x   \n" + 
				"|     [_]      \n" + 
				"|    _|        \n" + 
				"|              \n" + 
				"+--------------";
		
		ahorcados[6] = 
				"+------+       \n" +
				"|      |       \n" + 
				"|      #       \n" + 
				"|     (_)      \n" + 
				"|  x--[ ]--x   \n" + 
				"|     [_]      \n" + 
				"|    _| |_     \n" + 
				"|              \n" + 
				"+--------------";
		
		//formatter_on
	}

	public void aniadirParteCuerpo() {
		partesCuerpo++;
	}

	public void reiniciar() {
		partesCuerpo = 0;
	}

	public boolean haPerdido() {
		return partesCuerpo == 6;
	}

	public String toString() {
		return ahorcados[partesCuerpo];
	}
	
}
