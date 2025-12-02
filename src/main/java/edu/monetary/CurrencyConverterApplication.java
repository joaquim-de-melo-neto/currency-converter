package edu.monetary;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.monetary.domain.ConversionData;
import edu.monetary.service.ExchangeConverter;

/**
 * Main application class for the Currency Converter.
 * It handles user interaction and orchestrates the conversion process.
 * @author Joaquim Neto
 * @version 1.0
 */
public class CurrencyConverterApplication {

	public static void main(String[] args) {

		ConversionData data = new CurrencyConverterMenu().render();

		ExchangeConverter conversor = new ExchangeConverter(data);
		
		try {

			BigDecimal montanteFinal = conversor.convert();
			System.out.printf("\n🤑 -> Valor convertido: %s %s equivalem a %s %s.\n\n", data.getBaseCode(), data.getAmount().setScale(2,RoundingMode.DOWN).toPlainString(), data.getTargetCode() , montanteFinal.setScale(2, RoundingMode.DOWN).toPlainString());
		
		} catch (InterruptedException ie) {
			System.out.println("The operation was interrupted: " + ie.getMessage());	
		}
		
		catch (JsonProcessingException jme) {
			System.out.println("An unexpected error occurred: " + jme.getMessage());
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
