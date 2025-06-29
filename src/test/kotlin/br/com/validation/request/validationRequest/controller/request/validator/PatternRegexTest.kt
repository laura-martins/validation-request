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
            "ÿacento",
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
            "ÿacento",
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
            "-B",
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
            "ÿacento",
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

    @Test
    fun `should validate NUMBER_ADDRESS regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.NUMBER_ADDRESS_VALID)

        val validFantasyNames = listOf(
            "SN",
            "sn",
            "123",
            "0",
            "1",
            "9999",
            "2AA",
            "456A",
            "A123",
            "KM 15",
            "123-A",
            "12/45",
            "123,5",
            "nº 101",
            "223ª"
        )

        val invalidFantasyNames = listOf(
            "letra",
            "LETRA",
            "-B",
            "4AAA",
            "AAA3",
            "5ccc",
            "ccc6",
            "S/N",
            "s/n",
            " 2A",
            "-2A",
            "/2A",
            ",2A",
            "ª2A",
            "º2A",
            "L4!@#",
            "áéíóú",
            "ÁÉÍÓÚ",
            "L3áéíóú",
            "L3ÁÉÍÓÚ",
            "ÿacento1",
            "L2 !@#$%^&*()",
            "L2 Зafbбcб, 123",
            "L2 ♥ ♦ € ∞, 456",
            "L2 ЗБИОЧ"
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid number address: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid number address: '$it'")
        }
    }

    @Test
    fun `should validate COMPLEMENTARY_ADDRESS regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.COMPLEMENTARY_ADDRESS)

        val validFantasyNames = listOf(
            "APTO 101",
            "Apto 101",
            "Bloco A",
            "Bloco 1",
            "Fundos",
            "Casa dos Fundos",
            "Studio compacto",
            "Kitnet mobiliada",
            "A",
            "Ap",
            "áéíóúâêîôûãõçñà",
            "ÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ",
            "Casa à direita",
            "Chácara urbana",
            "Prédio Azul",
            "Térreo",
            "Edifício moderno",
            "Módulo C",
            "Condomínio Lúcio Costa",
            "Entrada Ângela",
            "Vila Ênio Silva",
            "Travessa Îndio Poti",
            "Lote Ômega 7",
            "Edifício Jûlio Ribeiro",
            "Praça São João",
            "Residencial Pinhõ",
            "Peña Nieto",
            "Apt'o 15",
            "Casa-2",
            "Bloco/Torre A",
            "Sala, 301",
            "Casa (fundos)",
            "1ª casa",
            "Andar 5º",
            "Ap 15º andar",
            "5º Casa",
            "Loja nº 10",
            "A1",
            "B2",
            "1A",
            "2B",
            "3º",
            "4ª"
        )

        val invalidFantasyNames = listOf(
            "1234567",
            "0",
            "999",
            "123 456",
            "-B",
            "Ed. Central",
            " Apto 101",
            "-Bloco A",
            "/Casa 2",
            ",Sala 301",
            "(Fundos)",
            "'Andar 5",
            "ºSala 1",
            "ªCasa 2",
            "aaaaa",
            "AAAAA",
            "AaAAa",
            "ááááá",
            "ÁÁÁÁÁ",
            "áÁááÁ",
            "ÿacento",
            "!!! !!!",
            "!!!!!!!",
            "casa !@#$%^&*()",
            "casa Зafbбcб",
            "casa ♥ ♦ € ∞, 456",
            "casa ЗБИОЧ"
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid complementary address: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid complementary address: '$it'")
        }
    }

    @Test
    fun `should validate NEIGHBORHOOD_VALID regex with valid and invalid values`() {
        val pattern = Pattern.compile(PatternRegex.NEIGHBORHOOD_VALID)

        val validFantasyNames = listOf(
            "Centro",
            "Vila Nova",
            "A",
            "1",
            "A1",
            "Sé",
            "São João",
            "Barra-da-Tijuca",
            "D'Ávila",
            "Sant’Ana",
            "Centro/Norte",
            "Setor 1",
            "1 Zona",
            "Vila Cenário",
            "Éden",
            "Índios",
            "Óleo",
            "Úrsula Paulino",
            "Ângela",
            "Êxito",
            "Îlha",
            "Ômega",
            "Ûrsula",
            "Ãnchieta",
            "São João",
            "Conceição"
        )

        val invalidFantasyNames = listOf(
            "-B",
            "aaaaa",
            "AAAAA",
            "AaAAa",
            "ááááá",
            "ÁÁÁÁÁ",
            "áÁááÁ",
            "!!! !!!",
            "!!!!!!!",
            " Centro",
            "-Vila",
            "/Jardim",
            "'Bairro",
            "ÿacento",
            "Centro Зafbбcб",
            "Vila ♥ ♦ € ∞",
            "Jardim ЗБИОЧ",
            "Bairro αβγδε",
        )

        validFantasyNames.forEach {
            assertTrue(pattern.matcher(it).matches(), "Should match valid neighborhood: '$it'")
        }

        invalidFantasyNames.forEach {
            assertFalse(pattern.matcher(it).matches(), "Should not match invalid neighborhood: '$it'")
        }
    }
}