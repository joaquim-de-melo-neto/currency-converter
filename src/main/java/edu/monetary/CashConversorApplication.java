package edu.monetary;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.monetary.domain.ConversionData;
import edu.monetary.domain.Conversor;

public class CashConversorApplication {

	public static void main(String[] args) {

		ConversionData data = new CurrencyConverterMenu().render();

		Conversor conversor = new Conversor(data);
		
		try {

			BigDecimal montanteFinal = conversor.calculate();
			print("\n🤑 -> Valor convertido: " + data.getTargetCode() + " " + montanteFinal.setScale(2, RoundingMode.DOWN).toPlainString());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void print(String string) {
		System.out.println(string);
	}

}
