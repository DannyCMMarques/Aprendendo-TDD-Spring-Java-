# 🧪 TDD (Test-Driven Development)

O **TDD (Test-Driven Development)**, ou **Desenvolvimento Guiado por Testes**, é uma técnica de desenvolvimento onde você **escreve os testes antes do código**. O fluxo principal do TDD segue três etapas: **Red**, **Green** e **Refactor**.

---

## 🔄 Etapas do TDD

| 🏷️ Etapa      | ✍️ O que significa?                                           | 🔧 O que fazer?                                                 |
|---------------|---------------------------------------------------------------|-----------------------------------------------------------------|
| **Red**       | Escreva um teste que **falha**.                                | Escreva um teste para uma funcionalidade que **ainda não existe**. |
| **Green**     | Faça o teste passar.                                           | Implemente o **código mínimo necessário** para o teste passar.   |
| **Refactor**  | Melhore o código sem quebrar o teste.                          | Otimize o código, **remova duplicações**, mas mantenha o teste passando. |

---

## 📋 Benefícios do TDD

| ✅ Benefício                  | 📚 Descrição                                                  |
|-----------------------------|--------------------------------------------------------------|
| **Evita bugs**               | Como você escreve os testes antes, evita erros no código.     |
| **Garante requisitos**       | Você só implementa o que os testes exigem.                    |
| **Facilita mudanças**        | Com testes já escritos, você pode fazer refatorações com mais segurança. |
| **Melhora o design do código** | Como você pensa nos testes antes, seu código tende a ser mais organizado. |

---

## 🚀 Resumo do Fluxo do TDD

| 🔄 Etapa      | 📋 O que você fez?                                             |
|--------------|----------------------------------------------------------------|
| **Red**      | Escreveu um teste que falha, pois o método ainda não existia.  |
| **Green**    | Implementou o método necessário para o teste passar.           |
| **Refactor** | Melhorou o código sem quebrar o teste, garantindo qualidade.    |

---

## 🛠️ Quando usar TDD?

| 📚 Cenário                  | 🎯 Quando usar?                                             |
|----------------------------|------------------------------------------------------------|
| **Novo recurso**            | Quando você está implementando uma nova funcionalidade.    |
| **Correção de bug**         | Quando você precisa corrigir um erro e evitar que ele volte. |
| **Refatoração**             | Quando você está limpando o código existente.              |


## 🧰 Testes em Spring Boot (Repository, Service, Controller)

Em um projeto Spring Boot, você pode aplicar TDD para testar:

1️⃣ **Repository:** Teste consultas ao banco de dados usando **`@DataJpaTest`**.  
2️⃣ **Service:** Teste a lógica de negócios isoladamente usando **Mockito**.  
3️⃣ **Controller:** Teste os endpoints da API, podendo fazer:
   - **Teste de Integração (sem isolamento)** com **`@SpringBootTest`**.
   - **Teste Unitário (com isolamento)** usando **`MockMvcBuilders.standaloneSetup()`**.



## 🧰 Resumo prático

| 📚 Cenário                          | 🎯 Qual Teste Usar                         | Por quê?                                                       |
|------------------------------------|------------------------------------------|----------------------------------------------------------------|
| **Testar o fluxo completo (Controller -> Service -> Repository)** | **Teste de Integração (`@SpringBootTest`)** | Garante que todas as partes funcionam juntas.                  |
| **Focar apenas no Controller**      | **Teste Unitário (`standaloneSetup()`)**   | Teste rápido e isolado.                                        |
| **Simular respostas do Service**    | **Teste Unitário (`standaloneSetup()`)**   | Facilita testar diferentes cenários.                           |
| **Detectar problemas de configuração** | **Teste de Integração (`@SpringBootTest`)** | Detecta problemas reais no contexto do Spring.                 |
| **Testar consultas ao banco de dados** | **Teste de Repository (`@DataJpaTest`)**   | Garante que as queries estão funcionando corretamente.         |
| **Testar lógica de negócios isoladamente** | **Teste de Service (`@ExtendWith(MockitoExtension.class)`)** | Garante que a lógica funciona sem dependências externas.       |

---

## 🛠️ Quando usar cada tipo de teste?

| 📚 Tipo de Teste            | 🧩 Annotation                    | 🎯 Quando usar?                                             |
|----------------------------|----------------------------------|------------------------------------------------------------|
| **Teste de Integração (Controller, Service, Repository)** | `@SpringBootTest` + `@AutoConfigureMockMvc` | Quando você quer garantir que todas as partes funcionam juntas. |
| **Teste Unitário (Controller)** | `MockMvcBuilders.standaloneSetup()` | Quando você quer testar o Controller de forma isolada.     |
| **Teste de Repository**     | `@DataJpaTest`                   | Quando você quer testar consultas ao banco de dados.        |
| **Teste de Service**        | `@ExtendWith(MockitoExtension.class)` | Quando você quer testar a lógica de negócios isoladamente. |


