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
            "",
            "   ",
            "123e4567e89b12d3a456426614174000",
            "123e4567-e89b-12d3-a456",
            "123e4567-e89b-12d3-a456-426614174000021334",
            "g23e4567-e89b-12d3-a456-426614174000",
            "123e4567--e89b-12d3-a456-426614174000",
            "123e4567-e89b-12d3-a456-426614174000\n",
            " 123e4567-e89b-12d3-a456-426614174000",
            "123e4567-e89b-12d3-a456-426614174000 "
        )

        validUuids.forEach { uuid ->
            assertTrue(pattern.matcher(uuid).matches(), "Should match valid UUID: $uuid")
        }

        invalidUuids.forEach { uuid ->
            assertFalse(uuid.let { pattern.matcher(it).matches() } ?: false, "Should not match invalid UUID: $uuid")
        }
    }

    @Test
    fun `should validate CUSTOMER_NAME regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.CUSTOMER_NAME_VALID)

        val validNames = listOf(
            "Supermarket ABC",
            "Tech Solutions Ltda",
            "Magazine",
            "áéíóúâêîôûãõçñà",
            "ÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ",
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
            "L'Óreal Brasil",
            "D’Ávila Comércio",
            "DOS RÉIS *****",
            "DOS REIS, CASEIRA E DA MATA 33333"
        )

        val invalidNames = listOf(
            "123456",
            "12345 67890",
            "aaaaa",
            "AAAAA",
            "AaAAa",
            "ááááá",
            "ÁÁÁÁÁ",
            "áÁááÁ",
            "!!! ???",
            "!!!!!!!",
            "Loja Зafbбcб",
            "Loja ♥ ♦ € ∞",
            "Mercado São João ЗБИОЧ"
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
            "áéíóúâêîôûãõçñà",
            "ÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ",
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
            "D’Ávila Comércio",
            "Café com Leite~",
            "B3",
            "L!",
            "DOS RÉIS *****",
            "DOS REIS, CASEIRA E DA MATA 33333"
        )

        val invalidFantasyNames = listOf(
            "123456",
            "123 456",
            "aaaaa",
            "AAAAA",
            "AaAAa",
            "ááááá",
            "ÁÁÁÁÁ",
            "áÁááÁ",
            "!!! !!!",
            "!!!!!!!",
            "Café do Ponto Зafbбcб",
            "Restaurante ♥ ♦ € ∞",
            "Mercado São João ЗБИОЧ",
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid fantasy name: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid fantasy name: '$it'")
        }
    }

    @Test
    fun `should validate STREET_ADDRESS regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.STREET_ADDRESS_VALID)

        val validFantasyNames = listOf(
            "ENDEREÇO EM MAIÚSCULA, 789",
            "endereço em minúscula, 101",
            "Rua das Flores",
            "Rua A",
            "Rua 1",
            "Sé",
            "áéíóúâêîôûãõçñà",
            "ÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ",
            "Avenida João Cañizo Ñunes",
            "Rua São Tomás de Aquino",
            "Travessa do Comércio",
            "Rua Capitão Luís",
            "Rua Ló da Silva",
            "Rua Lúcia",
            "Rua Fêlix",
            "Jardim Pôr-do-Sol",
            "Avenida Flûor de Lis",
            "Rua Frei Inácio L'Óreal",
            "Rua Frei Inácio d’Ávila",
            "Jardim são Luis",
            "Rua das curaçaus",
            "Rua palmeira àgua",
            "Praça da Sé, s/n",
            "Alameda Santos - Sala 101",
            "Estrada Municipal, Km 15",
            "Rua XV de Novembro, 88",
            "Parque das Nações (bloco 3)",
            "Rua 1º de Maio",
            "3ª Avenida",
            "23 de Maio",
            "1 de Janeiro"
        )

        val invalidFantasyNames = listOf(
            "123456",
            "123 456",
            "A",
            "1",
            "Av. Paulista, 1000",
            "# Rua paulo",
            " Rua paulo",
            "' Rua paulo",
            "’ Rua paulo",
            "/ Rua paulo",
            ", Rua paulo",
            "(Rua) paulo",
            ")Rua( paulo",
            "º Rua paulo",
            "ª Rua paulo",
            "laura amora ЗБИОЧ",
            "aaaaa",
            "AAAAA",
            "AaAAa",
            "ááááá",
            "ÁÁÁÁÁ",
            "áÁááÁ",
            "!!! !!!",
            "!!!!!!!",
            "Rua joao !@#$%^&*()",
            "Rua joao Зafbбcб, 123",
            "Av. barros ♥ ♦ € ∞, 456",
            "Rua São João ЗБИОЧ"
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid street address: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid street address: '$it'")
        }
    }
}