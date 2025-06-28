package br.com.validation.request.validationRequest.controller.request.validator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

class PatternRegexTest {

    @Test
    fun `should validate UUID regex with various valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.UUID_VALID)

        val validUuids = listOf(
            "123e4567-e89b-12d3-a456-426614174000",
            "00000000-0000-0000-0000-000000000000",
            "abcdefab-cdef-abcd-efab-cdefabcdefab",
            "ABCDEFAB-CDEF-ABCD-EFAB-CDEFABCDEFAB",
        )

        val invalidUuids = listOf(
            null,                                           // explicitly include null
            "",                                             // empty string
            "   ",                                          // apenas espaços
            "123e4567e89b12d3a456426614174000",             // missing dashes
            "123e4567-e89b-12d3-a456",                      // too short
            "123e4567-e89b-12d3-a456-426614174000021334",   // too short
            "g23e4567-e89b-12d3-a456-426614174000",         // invalid hex char 'g'
            "123e4567--e89b-12d3-a456-426614174000",        // extra dash
            "123e4567-e89b-12d3-a456-426614174000\n",       // newline
            " 123e4567-e89b-12d3-a456-426614174000",        // leading space
            "123e4567-e89b-12d3-a456-426614174000 "         // trailing space
        )

        validUuids.forEach { uuid ->
            assertTrue(pattern.matcher(uuid).matches(), "Should match valid UUID: $uuid")
        }

        invalidUuids.forEach { uuid ->
            assertFalse(uuid?.let { pattern.matcher(it).matches() } ?: false, "Should not match invalid UUID: $uuid")
        }
    }

    @Test
    fun `should validate CUSTOMER_NAME regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.CUSTOMER_NAME_VALID)

        val validNames = listOf(
            "Supermarket ABC",
            "Tech Solutions Ltda",
            "Magazine",
            "Señorita Moda",
            "Lógica Contábil",
            "Máxima Soluções",
            "Café Século",
            "Fácil Logística",
            "Música Viva",
            "Pântano Design",
            "Fênix Energia",
            "Dû Soluções",
            "Padaria & Cia Ltda.",
            "Auto Peças 24h",
            "Mercado São João (Filial)",
            "Restaurante São João - Centro",
            "Loja 100% Legal",
            "12.345.560 Laura Martins",
            "O2 Serviços",
            "@Home Store",
            "#1 Informática",
            "L’Óreal Brasil",
            "D’Ávila Comércio",
            "DOS RÉIS *****",
            "DOS REIS, CASEIRA E DA MATA 33333"
        )

        val invalidNames = listOf(
            "123456",               // apenas números
            "aaaaa",                // sequência de 5 letras repetidas
            "",                     // string vazia
            "   ",                  // apenas espaços
            "!!! ???",              // só caracteres especiais, sem letras nem números
            "!!!!!!!",              // só caracteres especiais
            "12345 67890",          // duas palavras mas só números
            "Loja Зafbбcб",         // caracter estrageiro
            "Loja ♥ ♦ € ∞",         // símbolos especiais
        )

        validNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid name: '$it'")
        }

        invalidNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should NOT match invalid name: '$it'")
        }
    }

    @Test
    fun `should validate FANTASY_NAME regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.FANTASY_NAME_VALID)

        val validFantasyNames = listOf(
            "Supermarket ABC",
            "Tech Solutions Ltda",
            "Magazine",
            "Señorita Moda",
            "Lógica Contábil",
            "Máxima Soluções",
            "Café Século",
            "Fácil Logística",
            "Música Viva",
            "Pântano Design",
            "Fênix Energia",
            "Dû Soluções",
            "Padaria & Cia Ltda.",
            "Auto Peças 24h",
            "Farmácia Popular nº1",
            "Mercado São João (Filial)",
            "Restaurante São João - Centro",
            "Bar & Grill [Zona Sul]",
            "Café do Ponto § Especial",
            "Loja 100% Legal",
            "Loja 1ª Avenida",
            "Consultoria 2º Grau",
            "12.345.560 Laura Martins",
            "O2 Serviços",
            "@Home Store",
            "#1 Informática",
            "L'Óreal",
            "Café com Leite~",
            "B3",
            "L!",
            "DOS RÉIS *****",
            "DOS REIS, CASEIRA E DA MATA 33333"
        )

        val invalidFantasyNames = listOf(
            "123456",                   // Apenas números
            "123 456",                  // Duas palavras mas só números (inválido)
            "aaaaa",                    // Sequência de 5 letras repetidas
            "áÁááÁ",                    // Sequência de 5 letras repetidas
            "",                         // String vazia
            "     ",                    // Espaços apenas
            "!!! !!!",                  // Só caracteres especiais
            "!!!!!!!",                  // Só caracteres especiais
            "Café do Ponto Зafbбcб",    // caracter estrageiro (caracteres cirílicos)
            "Restaurante ♥ ♦ € ∞",      // símbolos especiais
            "Mercado São João ЗБИОЧ"    // caracter estrageiro
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid fantasy name: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid fantasy name: '$it'")
        }
    }
//
//    @Test
//    fun `should validate STREET_ADDRESS regex with valid and invalid values`() {
//        val pattern = Pattern.compile(PatternRegex.STREET_ADDRESS_VALID)
//
//        // Valid street addresses
//        assertTrue(pattern.matcher("123 Main St").matches())
//        assertTrue(pattern.matcher("Rua das Flores, 45").matches())
//
//        // Invalid street addresses
//        assertFalse(pattern.matcher("123456").matches()) // Only numbers
//        assertFalse(pattern.matcher("aaaaa").matches()) // Repeated characters
//        assertFalse(pattern.matcher("").matches()) // Empty string
//    }
}