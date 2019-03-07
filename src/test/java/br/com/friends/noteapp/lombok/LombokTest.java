package br.com.friends.noteapp.lombok;

import org.junit.Test;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LombokTest {

	@Test
	public void testData() {
		Automovel auto = new Automovel();
		auto.setCor("Vermelho");
		auto.setPortas(2);
		auto.setRodas(4);
		auto.setVelocidade(200);
		log.info(auto.toString());

		AutomovelNovo autoN = AutomovelNovo.builder().cor("azul").portas(4).rodas(3).velocidade(150D).build();
		log.info(autoN.toString());
	}

	@Test
	public void testBuild() {
		try {
			AutomovelNovo autoN = Fabrica.construir(null, 4, 6, null);
			log.info(autoN.toString());
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
	}
}

@UtilityClass
class Fabrica {

	@SneakyThrows
	public AutomovelNovo construir(String cor, Integer rodas, Integer portas, Double velocidade) {
		if (cor == null) {
			throw new Exception("Cor Obrigatoria");
		}
		return AutomovelNovo.builder().cor(cor).rodas(rodas).portas(portas).velocidade(velocidade).build();
	}
}

@Data
class Automovel {
	private int rodas;
	private int portas;
	private double velocidade;
	private String cor;
}

@Value
@Builder(toBuilder = true)
class AutomovelNovo {
	@NonNull
	Integer rodas;
	@NonNull
	Integer portas;
	@NonNull
	Double velocidade;
	@NonNull
	String cor;
}