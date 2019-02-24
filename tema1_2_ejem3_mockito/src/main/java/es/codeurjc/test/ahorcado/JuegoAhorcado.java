package es.codeurjc.test.ahorcado;

import java.util.Random;

public class JuegoAhorcado {

	private String[] palabras = { "ALBANIA", "ALEMANIA", "ANDORRA", "ARMENIA", "AUSTRIA",
			"AZERBAIYAN", "BELGICA", "BIELORRUSIA", "BOSNIA Y HERZEGOVINA", "BULGARIA",
			"REPUBLICA CHECA", "CROACIA", "DINAMARCA", "ESLOVAQUIA", "ESLOVENIA", "ESPAÑA",
			"ESTONIA", "FINLANDIA", "FRANCIA", "GEORGIA", "GRECIA", "HUNGRIA", "IRLANDA",
			"ISLANDIA", "ITALIA", "LETONIA", "LIECHTENSTEIN", "LITUANIA", "LUXEMBURGO",
			"REPUBLICA DE MACEDONIA", "MALTA", "MOLDAVIA", "MONACO", "MONTENEGRO", "NORUEGA",
			"PAISES BAJOS", "POLONIA", "PORTUGAL", "REINO UNIDO", "RUMANIA", "RUSIA", "SAN MARINO",
			"SERBIA", "SUECIA", "SUIZA", "UCRANIA", "VATICANO", "ANTIGUA V BARBUDA", "ARGENTINA",
			"BAHAMAS", "BARBADOS", "BELICE", "BOLIVIA", "BRASIL", "CANADA", "CHILE", "COLOMBIA",
			"COSTA RICA", "CUBA", "DOMINICA", "REPUBLICA DOMINICANA", "ECUADOR", "EL SALVADOR",
			"ESTADOS UNIDOS", "GRANADA", "GUATEMALA", "GUYANA", "HAITI", "HONDURAS", "JAMAICA",
			"MEXICO", "NICARAGUA", "PANAMA", "PARAGUAY", "PERU", "PUERTO RICO",
			"SAN CRISTOBAL Y NIEVES", "SANTA LUCIA", "SAN VICENTE Y LAS GRANADINAS", "SURINAM",
			"TRINIDAD Y TOBAGO", "URUGUAY", "VENEZUELA", "AFGANISTAN", "ARABIA SAUDITA", "BAREIN",
			"BANGLADES", "BRUNEI", "BUTAN", "CAMBOYA", "CHINA", "CHIPRE", "COREA DEL NORTE",
			"COREA DEL SUR", "EMIRATOS ARABES UNIDOS", "FILIPINAS", "INDIA", "INDONESIA", "IRAN",
			"IRAQ", "ISRAEL", "JAPON", "JORDANIA", "KAZAJISTAN", "KIRGUISTAN", "KUWAIT", "LAOS",
			"LIBANO", "MALASIA", "MALDIVAS", "MONGOLIA", "MYANMAR", "NEPAL", "OMAN", "PAKISTAN",
			"PALESTINA", "QATAR", "SINGAPUR", "SIRIA", "SRI LANKA", "TAILANDIA", "TAIWAN",
			"TAYIKISTAN", "TIMOR ORIENTAL", "TURKMENISTAN", "TURQUIA", "UZBEKISTAN", "VIETNAM",
			"YEMEN", "ANGOLA", "ARGELIA", "BENIN", "BOTSUANA", "BURKINA FASO", "BURUNDI",
			"CABO VERDE", "CAMERUN", "REPUBLICA CENTROAFRICANA", "CHAD", "COMORAS",
			"REPUBLICA DEL CONGO", "REPUBLICA DEMOCRATICA DEL CONGO", "COSTA DE MARFIL", "EGIPTO",
			"ERITREA", "ETIOPIA", "GABON", "GAMBIA", "GHANA", "GUINEA", "GUINEA-BISSAU",
			"GUINEA ECUATORIAL", "KENIA", "LESOTO", "LIBERIA", "LIBIA", "MADAGASCAR", "MALAUI",
			"MALI", "MARRUECOS", "MAURICIO", "MAURITANIA", "MOZAMBIQUE", "NAMIBIA", "NIGER",
			"NIGERIA", "REPUBLICA SAHARAUI", "RUANDA", "SANTO TOME Y PRINCIPE", "SENEGAL",
			"SEYCHELLES", "SIERRA LEONA", "SOMALIA", "SUAZILANDIA", "SUDAFRICA", "SUDAN DEL NORTE",
			"SUDAN DEL SUR", "TANZANIA", "TOGO", "TUNEZ", "UGANDA", "YIBUTI", "ZAMBIA", "ZIMBABUE",
			"AUSTRALIA", "FIYI", "KIRIBATI", "ISLAS MARSHALL", "MICRONESIA", "NAURU",
			"NUEVA ZELANDA", "PALAOS", "PAPUA NUEVA GUINEA", "ISLAS SALOMON", "SAMOA", "TONGA",
			"TUVALU", "VANUATU" };

	private Consola consola;
	private Random random = new Random();

	public JuegoAhorcado(Consola consola) {
		this.consola = consola;
	}

	public void jugar(Jugador jugador) {
		
		consola.println("Bienvenido al juego del ahorcado");

		jugador.leeNombre();
		
		boolean otraPartida;
		do {

			PartidaAhorcado partida = this.crearNuevaPartida(jugador);
			
			partida.jugarPartida(jugador);

			consola.print("Quieres jugar otra partida? ");
			otraPartida = consola.leerString().equalsIgnoreCase("S");

		} while (otraPartida);

		consola.println("Hasta pronto!");
	}
	
	private PartidaAhorcado crearNuevaPartida(Jugador jugador) {
		consola.println("Nueva partida");
		String palabra = palabras[random.nextInt(palabras.length)];
		return new PartidaAhorcado(palabra);
	}
}
