package edu.monetary;

import edu.monetary.domain.ConversionData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * CurrencyConverterMenu
 * Esta classe simula a interface de seleção de moedas para um aplicativo de conversor.
 * Ela armazena os códigos de moeda e permite ao usuário selecionar duas moedas.
 * O código gerado é completo e pronto para ser executado no console.
 */
public class CurrencyConverterMenu {

    // Mapa para armazenar os códigos de moeda e seus detalhes (Nome da Moeda (País))
    private static final Map<String, String> CURRENCIES = new HashMap<>();

    // Bloco estático para popular o mapa com todos os dados fornecidos
    static {
        // Formato: Código | Nome da Moeda (País)
        CURRENCIES.put("AED", "UAE Dirham (United Arab Emirates)");
        CURRENCIES.put("AFN", "Afghan Afghani (Afghanistan)");
        CURRENCIES.put("ALL", "Albanian Lek (Albania)");
        CURRENCIES.put("AMD", "Armenian Dram (Armenia)");
        CURRENCIES.put("ANG", "Netherlands Antillian Guilder (Netherlands Antilles)");
        CURRENCIES.put("AOA", "Angolan Kwanza (Angola)");
        CURRENCIES.put("ARS", "Argentine Peso (Argentina)");
        CURRENCIES.put("AUD", "Australian Dollar (Australia)");
        CURRENCIES.put("AWG", "Aruban Florin (Aruba)");
        CURRENCIES.put("AZN", "Azerbaijani Manat (Azerbaijan)");
        CURRENCIES.put("BAM", "Bosnia and Herzegovina Mark (Bosnia and Herzegovina)");
        CURRENCIES.put("BBD", "Barbados Dollar (Barbados)");
        CURRENCIES.put("BDT", "Bangladeshi Taka (Bangladesh)");
        CURRENCIES.put("BGN", "Bulgarian Lev (Bulgaria)");
        CURRENCIES.put("BHD", "Bahraini Dinar (Bahrain)");
        CURRENCIES.put("BIF", "Burundian Franc (Burundi)");
        CURRENCIES.put("BMD", "Bermudian Dollar (Bermuda)");
        CURRENCIES.put("BND", "Brunei Dollar (Brunei)");
        CURRENCIES.put("BOB", "Bolivian Boliviano (Bolivia)");
        CURRENCIES.put("BRL", "Brazilian Real (Brazil)");
        CURRENCIES.put("BSD", "Bahamian Dollar (Bahamas)");
        CURRENCIES.put("BTN", "Bhutanese Ngultrum (Bhutan)");
        CURRENCIES.put("BWP", "Botswana Pula (Botswana)");
        CURRENCIES.put("BYN", "Belarusian Ruble (Belarus)");
        CURRENCIES.put("BZD", "Belize Dollar (Belize)");
        CURRENCIES.put("CAD", "Canadian Dollar (Canada)");
        CURRENCIES.put("CDF", "Congolese Franc (Democratic Republic of the Congo)");
        CURRENCIES.put("CHF", "Swiss Franc (Switzerland)");
        CURRENCIES.put("CLP", "Chilean Peso (Chile)");
        CURRENCIES.put("CNY", "Chinese Renminbi (China)");
        CURRENCIES.put("COP", "Colombian Peso (Colombia)");
        CURRENCIES.put("CRC", "Costa Rican Colon (Costa Rica)");
        CURRENCIES.put("CUP", "Cuban Peso (Cuba)");
        CURRENCIES.put("CVE", "Cape Verdean Escudo (Cape Verde)");
        CURRENCIES.put("CZK", "Czech Koruna (Czech Republic)");
        CURRENCIES.put("DJF", "Djiboutian Franc (Djibouti)");
        CURRENCIES.put("DKK", "Danish Krone (Denmark)");
        CURRENCIES.put("DOP", "Dominican Peso (Dominican Republic)");
        CURRENCIES.put("DZD", "Algerian Dinar (Algeria)");
        CURRENCIES.put("EGP", "Egyptian Pound (Egypt)");
        CURRENCIES.put("ERN", "Eritrean Nakfa (Eritrea)");
        CURRENCIES.put("ETB", "Ethiopian Birr (Ethiopia)");
        CURRENCIES.put("EUR", "Euro (European Union)");
        CURRENCIES.put("FJD", "Fiji Dollar (Fiji)");
        CURRENCIES.put("FKP", "Falkland Islands Pound (Falkland Islands)");
        CURRENCIES.put("FOK", "Faroese Króna (Faroe Islands)");
        CURRENCIES.put("GBP", "Pound Sterling (United Kingdom)");
        CURRENCIES.put("GEL", "Georgian Lari (Georgia)");
        CURRENCIES.put("GGP", "Guernsey Pound (Guernsey)");
        CURRENCIES.put("GHS", "Ghanaian Cedi (Ghana)");
        CURRENCIES.put("GIP", "Gibraltar Pound (Gibraltar)");
        CURRENCIES.put("GMD", "Gambian Dalasi (The Gambia)");
        CURRENCIES.put("GNF", "Guinean Franc (Guinea)");
        CURRENCIES.put("GTQ", "Guatemalan Quetzal (Guatemala)");
        CURRENCIES.put("GYD", "Guyanese Dollar (Guyana)");
        CURRENCIES.put("HKD", "Hong Kong Dollar (Hong Kong)");
        CURRENCIES.put("HNL", "Honduran Lempira (Honduras)");
        CURRENCIES.put("HRK", "Croatian Kuna (Croatia)");
        CURRENCIES.put("HTG", "Haitian Gourde (Haiti)");
        CURRENCIES.put("HUF", "Hungarian Forint (Hungary)");
        CURRENCIES.put("IDR", "Indonesian Rupiah (Indonesia)");
        CURRENCIES.put("ILS", "Israeli New Shekel (Israel)");
        CURRENCIES.put("IMP", "Manx Pound (Isle of Man)");
        CURRENCIES.put("INR", "Indian Rupee (India)");
        CURRENCIES.put("IQD", "Iraqi Dinar (Iraq)");
        CURRENCIES.put("IRR", "Iranian Rial (Iran)");
        CURRENCIES.put("ISK", "Icelandic Króna (Iceland)");
        CURRENCIES.put("JEP", "Jersey Pound (Jersey)");
        CURRENCIES.put("JMD", "Jamaican Dollar (Jamaica)");
        CURRENCIES.put("JOD", "Jordanian Dinar (Jordan)");
        CURRENCIES.put("JPY", "Japanese Yen (Japan)");
        CURRENCIES.put("KES", "Kenyan Shilling (Kenya)");
        CURRENCIES.put("KGS", "Kyrgyzstani Som (Kyrgyzstan)");
        CURRENCIES.put("KHR", "Cambodian Riel (Cambodia)");
        CURRENCIES.put("KID", "Kiribati Dollar (Kiribati)");
        CURRENCIES.put("KMF", "Comorian Franc (Comoros)");
        CURRENCIES.put("KRW", "South Korean Won (South Korea)");
        CURRENCIES.put("KWD", "Kuwaiti Dinar (Kuwait)");
        CURRENCIES.put("KYD", "Cayman Islands Dollar (Cayman Islands)");
        CURRENCIES.put("KZT", "Kazakhstani Tenge (Kazakhstan)");
        CURRENCIES.put("LAK", "Lao Kip (Laos)");
        CURRENCIES.put("LBP", "Lebanese Pound (Lebanon)");
        CURRENCIES.put("LKR", "Sri Lanka Rupee (Sri Lanka)");
        CURRENCIES.put("LRD", "Liberian Dollar (Liberia)");
        CURRENCIES.put("LSL", "Lesotho Loti (Lesotho)");
        CURRENCIES.put("LYD", "Libyan Dinar (Libya)");
        CURRENCIES.put("MAD", "Moroccan Dirham (Morocco)");
        CURRENCIES.put("MDL", "Moldovan Leu (Moldova)");
        CURRENCIES.put("MGA", "Malagasy Ariary (Madagascar)");
        CURRENCIES.put("MKD", "Macedonian Denar (North Macedonia)");
        CURRENCIES.put("MMK", "Burmese Kyat (Myanmar)");
        CURRENCIES.put("MNT", "Mongolian Tögrög (Mongolia)");
        CURRENCIES.put("MOP", "Macanese Pataca (Macau)");
        CURRENCIES.put("MRU", "Mauritanian Ouguiya (Mauritania)");
        CURRENCIES.put("MUR", "Mauritian Rupee (Mauritius)");
        CURRENCIES.put("MVR", "Maldivian Rufiyaa (Maldives)");
        CURRENCIES.put("MWK", "Malawian Kwacha (Malawi)");
        CURRENCIES.put("MXN", "Mexican Peso (Mexico)");
        CURRENCIES.put("MYR", "Malaysian Ringgit (Malaysia)");
        CURRENCIES.put("MZN", "Mozambican Metical (Mozambique)");
        CURRENCIES.put("NAD", "Namibian Dollar (Namibia)");
        CURRENCIES.put("NGN", "Nigerian Naira (Nigeria)");
        CURRENCIES.put("NIO", "Nicaraguan Córdoba (Nicaragua)");
        CURRENCIES.put("NOK", "Norwegian Krone (Norway)");
        CURRENCIES.put("NPR", "Nepalese Rupee (Nepal)");
        CURRENCIES.put("NZD", "New Zealand Dollar (New Zealand)");
        CURRENCIES.put("OMR", "Omani Rial (Oman)");
        CURRENCIES.put("PAB", "Panamanian Balboa (Panama)");
        CURRENCIES.put("PEN", "Peruvian Sol (Peru)");
        CURRENCIES.put("PGK", "Papua New Guinean Kina (Papua New Guinea)");
        CURRENCIES.put("PHP", "Philippine Peso (Philippines)");
        CURRENCIES.put("PKR", " Pakistani Rupee (Pakistan)");
        CURRENCIES.put("PLN", "Polish Złoty (Poland)");
        CURRENCIES.put("PYG", "Paraguayan Guaraní (Paraguay)");
        CURRENCIES.put("QAR", "Qatari Riyal (Qatar)");
        CURRENCIES.put("RON", "Romanian Leu (Romania)");
        CURRENCIES.put("RSD", "Serbian Dinar (Serbia)");
        CURRENCIES.put("RUB", "Russian Ruble (Russia)");
        CURRENCIES.put("RWF", "Rwandan Franc (Rwanda)");
        CURRENCIES.put("SAR", "Saudi Riyal (Saudi Arabia)");
        CURRENCIES.put("SBD", "Solomon Islands Dollar (Solomon Islands)");
        CURRENCIES.put("SCR", "Seychellois Rupee (Seychelles)");
        CURRENCIES.put("SDG", "Sudanese Pound (Sudan)");
        CURRENCIES.put("SEK", "Swedish Krona (Sweden)");
        CURRENCIES.put("SGD", "Singapore Dollar (Singapore)");
        CURRENCIES.put("SHP", "Saint Helena Pound (Saint Helena)");
        CURRENCIES.put("SLE", "Sierra Leonean Leone (Sierra Leone)");
        CURRENCIES.put("SOS", "Somali Shilling (Somalia)");
        CURRENCIES.put("SRD", "Surinamese Dollar (Suriname)");
        CURRENCIES.put("SSP", "South Sudanese Pound (South Sudan)");
        CURRENCIES.put("STN", "São Tomé and Príncipe Dobra (São Tomé and Príncipe)");
        CURRENCIES.put("SYP", "Syrian Pound (Syria)");
        CURRENCIES.put("SZL", "Eswatini Lilangeni (Eswatini)");
        CURRENCIES.put("THB", "Thai Baht (Thailand)");
        CURRENCIES.put("TJS", "Tajikistani Somoni (Tajikistan)");
        CURRENCIES.put("TMT", "Turkmenistan Manat (Turkmenistan)");
        CURRENCIES.put("TND", "Tunisian Dinar (Tunisia)");
        CURRENCIES.put("TOP", "Tongan Paʻanga (Tonga)");
        CURRENCIES.put("TRY", "Turkish Lira (Turkey)");
        CURRENCIES.put("TTD", "Trinidad and Tobago Dollar (Trinidad and Tobago)");
        CURRENCIES.put("TVD", "Tuvaluan Dollar (Tuvalu)");
        CURRENCIES.put("TWD", "New Taiwan Dollar (Taiwan)");
        CURRENCIES.put("TZS", "Tanzanian Shilling (Tanzania)");
        CURRENCIES.put("UAH", "Ukrainian Hryvnia (Ukraine)");
        CURRENCIES.put("UGX", "Ugandan Shilling (Uganda)");
        CURRENCIES.put("USD", "United States Dollar (United States)");
        CURRENCIES.put("UYU", "Uruguayan Peso (Uruguay)");
        CURRENCIES.put("UZS", "Uzbekistani So'm (Uzbekistan)");
        CURRENCIES.put("VES", "Venezuelan Bolívar Soberano (Venezuela)");
        CURRENCIES.put("VND", "Vietnamese Đồng (Vietnam)");
        CURRENCIES.put("VUV", "Vanuatu Vatu (Vanuatu)");
        CURRENCIES.put("WST", "Samoan Tālā (Samoa)");
        CURRENCIES.put("XAF", "Central African CFA Franc (CEMAC)");
        CURRENCIES.put("XCD", "East Caribbean Dollar (Organisation of Eastern Caribbean States)");
        CURRENCIES.put("XDR", "Special Drawing Rights (International Monetary Fund)");
        CURRENCIES.put("XOF", "West African CFA franc (CFA)");
        CURRENCIES.put("XPF", "CFP Franc (Collectivités d'Outre-Mer)");
        CURRENCIES.put("YER", "Yemeni Rial (Yemen)");
        CURRENCIES.put("ZAR", "South African Rand (South Africa)");
        CURRENCIES.put("ZMW", "Zambian Kwacha (Zambia)");
        CURRENCIES.put("ZWL", "Zimbabwean Dollar (Zimbabwe)");
    }

    public ConversionData render() {
        Scanner scanner = new Scanner(System.in);

        String banner = " ______     __  __     ______     ______     ______     __   __     ______     __  __        ______     ______     __   __     __   __   ______     ______     ______   ______     ______    \n" + //
                        "/\\  ___\\   /\\ \\/\\ \\   /\\  == \\   /\\  == \\   /\\  ___\\   /\\ \"-.\\ \\   /\\  ___\\   /\\ \\_\\ \\      /\\  ___\\   /\\  __ \\   /\\ \"-.\\ \\   /\\ \\ / /  /\\  ___\\   /\\  == \\   /\\__  _\\ /\\  ___\\   /\\  == \\   \n" + //
                        "\\ \\ \\____  \\ \\ \\_\\ \\  \\ \\  __<   \\ \\  __<   \\ \\  __\\   \\ \\ \\-.  \\  \\ \\ \\____  \\ \\____ \\     \\ \\ \\____  \\ \\ \\/\\ \\  \\ \\ \\-.  \\  \\ \\ \\'/   \\ \\  __\\   \\ \\  __<   \\/_/\\ \\/ \\ \\  __\\   \\ \\  __<   \n" + //
                        " \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\  \\/\\_____\\     \\ \\_____\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\  \\ \\__|    \\ \\_____\\  \\ \\_\\ \\_\\    \\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\ \n" + //
                        "  \\/_____/   \\/_____/   \\/_/ /_/   \\/_/ /_/   \\/_____/   \\/_/ \\/_/   \\/_____/   \\/_____/      \\/_____/   \\/_____/   \\/_/ \\/_/   \\/_/      \\/_____/   \\/_/ /_/     \\/_/   \\/_____/   \\/_/ /_/ \n" + //
                        "                                                                                                                                                                                             ";
        
        System.out.println(banner);
        System.out.println("=================================================");
        System.out.println("  CONVERSOR DE MOEDAS - SELEÇÃO DE CÓDIGOS");
        System.out.println("=================================================");

        // Oferece a opção de ver a lista
        System.out.print("Deseja ver a lista completa de códigos de moedas? (S/N): ");
        String showList = scanner.nextLine().trim().toUpperCase();
        if (showList.equals("S")) {
            displayCurrencyList();
        }

        // 1. Seleciona a moeda de origem
        String baseCode = getCurrencyCode(scanner, "DE ORIGEM (Ex: USD):");

        // 2. Seleciona a moeda de destino
        String targetCode = getCurrencyCode(scanner, "DE DESTINO (Ex: BRL):");

        BigDecimal amount = getAmount(scanner, baseCode);

        System.out.println("\n=================================================");
        System.out.println("✅ SELEÇÃO CONCLUÍDA!");
        System.out.println("Moeda de Origem Selecionada: " + baseCode + " - " + CURRENCIES.get(baseCode));
        System.out.println("Moeda de Destino Selecionada: " + targetCode + " - " + CURRENCIES.get(targetCode));
        System.out.println("=================================================");

        scanner.close();

        return new ConversionData(amount, baseCode, targetCode);
    }

    /**
     * Solicita ao usuário um código de moeda e valida se ele existe.
     * @param scanner O objeto Scanner para leitura de entrada.
     * @param prompt O texto a ser exibido para o usuário.
     * @return O código de moeda válido inserido pelo usuário (em maiúsculas).
     */
    private static String getCurrencyCode(Scanner scanner, String prompt) {
        String code = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("\nInsira o código da moeda " + prompt + " ");
            code = scanner.nextLine().trim().toUpperCase();
            if (CURRENCIES.containsKey(code)) {
                valid = true;
                System.out.println("  -> Selecionado: " + CURRENCIES.get(code));
            } else if (code.length() != 3) {
                System.err.println("❌ Erro: O código da moeda deve ter 3 letras.");
            } else {
                System.err.println("❌ Erro: Código de moeda '" + code + "' não encontrado. Tente novamente ou digite 'S' para ver a lista.");
                // Permite ver a lista caso o usuário erre o código e precise de ajuda
                if (code.equals("S")) {
                     displayCurrencyList();
                }
            }
        }
        return code;
    }

    private static BigDecimal getAmount(Scanner scanner, String currencyCode) {
        BigDecimal amount = null;
        boolean valid = false;

        while (!valid) {
            System.out.print("\nInsira o VALOR em " + currencyCode + " para converter (ex: 100.50): ");
            // Substitui vírgula por ponto para garantir que seja um formato BigDecimal válido,
            // pois o construtor String do BigDecimal espera um ponto.
            String input = scanner.nextLine().trim().replace(',', '.'); 

            try {
                amount = new BigDecimal(input);
                // Verifica se o valor é positivo
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    valid = true;
                    System.out.println("  -> Selecionado: " + currencyCode + " " + amount);
                } else {
                    System.err.println("❌ Erro: O valor deve ser um número positivo.");
                }
            } catch (NumberFormatException e) {
                System.err.println("❌ Erro: Entrada inválida. Por favor, insira um número válido (Ex: 100 ou 50.75).");
            }
        }
        return amount;
    }

    /**
     * Exibe a lista completa de códigos de moedas em colunas formatadas.
     */
    private static void displayCurrencyList() {
        List<String> codes = new ArrayList<>(CURRENCIES.keySet());
        int total = codes.size();
        int columns = 2;
        int rows = (int) Math.ceil((double) total / columns);

        System.out.println("\n----------------- LISTA DE CÓDIGOS DE MOEDAS -----------------");
        System.out.printf("%-5s | %-38s | %-5s | %-38s\n", "CÓD", "MOEDA (PAÍS)", "CÓD", "MOEDA (PAÍS)");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < rows; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < columns; j++) {
                int index = i + j * rows;
                if (index < total) {
                    String code = codes.get(index);
                    String description = CURRENCIES.get(code);
                    line.append(String.format("%-5s | %-38s | ", code, description));
                } else {
                    // Preenche com espaços se não houver mais moedas para a coluna
                    line.append(String.format("%-5s | %-38s | ", "", ""));
                }
            }
            // Remove o último separador '|'
            System.out.println(line.substring(0, line.length() - 2));
        }
        System.out.println("--------------------------------------------------------------\n");
    }
}