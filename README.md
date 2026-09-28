# Banco de Alimentos - POO em Java

Atividade Prática Integradora da disciplina de **Programação Orientada a Objetos** (UniCesumar Londrina).

Sistema de console para controlar doações, estoque, distribuições e perdas de um Banco de Alimentos, sem banco de dados e sem interface gráfica.

## Classes

| Classe | Responsabilidade |
|---|---|
| `Doador` | Dados de quem faz a doação |
| `Alimento` | Dados do produto e verificação de validade |
| `Estoque` | Controle do saldo, sem permitir valores negativos |
| `Doacao` | Entrada de alimentos no estoque (não pode ser processada duas vezes) |
| `Distribuicao` | Saída de alimentos para famílias e instituições |
| `Perda` | Baixa de alimentos danificados, vencidos etc. |
| `Main` | Executa o cenário de teste e a demonstração de identidade |

## Conceitos aplicados

Classes e objetos, atributos, métodos e construtores, encapsulamento (`private`), abstração, identidade e referências entre objetos, colaboração entre objetos e validação de regras de negócio.

## Como executar

Na pasta do projeto:

```
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

## Cenário de teste

1. Doação de 100 kg de arroz → estoque 100 kg
2. Distribuição de 30 kg → estoque 70 kg
3. Perda de 5 kg (embalagem danificada) → estoque 65 kg
4. Distribuição de 80 kg → rejeitada por falta de estoque
5. Estoque final: 65 kg

## Autora

Yasmin Fernanda de Carvalho